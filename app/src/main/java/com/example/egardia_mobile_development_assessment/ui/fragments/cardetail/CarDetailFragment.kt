package com.example.egardia_mobile_development_assessment.ui.fragments.cardetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.egardia_mobile_development_assessment.R
import com.example.egardia_mobile_development_assessment.data.model.CarsItem
import com.example.egardia_mobile_development_assessment.databinding.FragmentCardetailBinding
import com.google.gson.Gson

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CarDetailFragment : Fragment() {

    private var _binding: FragmentCardetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCardetailBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val carString = arguments?.getString("car")
        val car: CarsItem = Gson().fromJson(carString, CarsItem::class.java)
        Glide.with(requireContext())
            .load(car.picture)
            .error(R.mipmap.no_image)
            .into(binding.imageview)
        binding.imageview
        binding.textviewBrand.text = car.make
        binding.textviewSpec.text = "${car.model}"
        binding.textviewSpec2.text = "${car.year}    ${car.km}km    €${car.price}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}