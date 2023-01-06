package com.example.egardia_mobile_development_assessment.ui.fragments.carslist

import android.app.Activity
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.egardia_mobile_development_assessment.R
import com.example.egardia_mobile_development_assessment.data.model.CarsItem
import com.example.egardia_mobile_development_assessment.databinding.FragmentCarlistBinding
import com.example.egardia_mobile_development_assessment.ui.CarListAdapter
import com.example.egardia_mobile_development_assessment.utils.ActionMenuStateNotifier
import com.example.egardia_mobile_development_assessment.utils.FilterEvent
import com.example.egardia_mobile_development_assessment.utils.Status
import com.example.egardia_mobile_development_assessment.utils.carlistFromUitls
import com.google.gson.Gson
import okhttp3.Cache


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CarListFragment : Fragment(), ActionMenuStateNotifier, View.OnClickListener {

    private var _binding: FragmentCarlistBinding? = null
    lateinit var carListVM: CarListViewModel
    var carList = listOf<CarsItem>()
    private val binding get() = _binding!!
    var recyclerAdapter: CarListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCarlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carListVM = ViewModelProvider(this)[CarListViewModel::class.java]
        binding.kmRefresh.setOnClickListener(this)
        binding.priceRefresh.setOnClickListener(this)
        binding.yearRefresh.setOnClickListener(this)
        binding.btnResetFilter.setOnClickListener(this)

        carListVM.getAllCars().observe(viewLifecycleOwner) {
            if (it.status == Status.SUCCESS) {
                Log.e(ContentValues.TAG, "onViewCreated: ${it.data}")
                carList = it.data!!
                recyclerAdapter = CarListAdapter(it.data!!) { car ->
                    val bundle = Bundle()
                    bundle.putString("car", Gson().toJson(car))
                    Log.e(TAG, "onViewCreated: secilen car ${car}")
                    findNavController().navigate(
                        R.id.action_FirstFragment_to_SecondFragment,
                        bundle
                    )
                }
                binding.recyclerview.adapter = recyclerAdapter
            }
        }
        FilterEvent.stateLiveData.observe(viewLifecycleOwner) {
            binding.filterLinear.isVisible = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    var filterState: Boolean = false
    override fun filterClikced() {
        filterState = !filterState
        binding.filterLinear.isVisible = filterState
    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.kmRefresh -> {
                recyclerAdapter?.updateData(recyclerAdapter!!.getDataList().filter { carsItem ->
                    carsItem.km >= (if(binding.kmMin.text.isNotEmpty()) binding.kmMin.text.toString() else "0" ).toInt() &&
                            carsItem.km <= (if(binding.kmMax.text.toString().isNotEmpty()) binding.kmMax.text.toString().toInt() else Int.MAX_VALUE)
                })
                FilterEvent.filterStateEvent()
                hideKeyboard()
            }
            binding.yearRefresh -> {
                recyclerAdapter?.updateData(recyclerAdapter!!.getDataList().filter { carsItem ->
                    carsItem.year >= (if(binding.yearMin.text.isNotEmpty()) binding.yearMin.text.toString() else "0" ).toInt() &&
                            carsItem.year <= (if(binding.yearMax.text.toString().isNotEmpty()) binding.yearMax.text.toString().toInt() else Int.MAX_VALUE)
                })
                FilterEvent.filterStateEvent()
                hideKeyboard()
            }
            binding.priceRefresh -> {
                recyclerAdapter?.updateData(recyclerAdapter!!.getDataList().filter { carsItem ->
                    carsItem.price >= (if(binding.priceMin.text.isNotEmpty()) binding.priceMin.text.toString().toDouble() else 0.0) &&
                            carsItem.price <= (if(binding.priceMax.text.toString().isNotEmpty()) binding.priceMax.text.toString().toDouble() else Double.MAX_VALUE)
                })
                FilterEvent.filterStateEvent()
                hideKeyboard()
            }
            binding.btnResetFilter -> {
                binding.priceMax.text.clear()
                binding.priceMin.text.clear()
                binding.yearMax.text.clear()
                binding.yearMin.text.clear()
                binding.kmMax.text.clear()
                binding.kmMax.text.clear()
                recyclerAdapter?.updateData(carList)
                hideKeyboard()
            }
        }
    }

    fun hideKeyboard(){
        val imm: InputMethodManager = getSystemService(requireContext(), InputMethodManager::class.java) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
    }
}