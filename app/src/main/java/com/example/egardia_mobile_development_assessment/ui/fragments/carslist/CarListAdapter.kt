package com.example.egardia_mobile_development_assessment.ui

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.egardia_mobile_development_assessment.R
import com.example.egardia_mobile_development_assessment.data.model.Cars
import com.example.egardia_mobile_development_assessment.data.model.CarsItem

class CarListAdapter(private var cars: List<CarsItem>, val onClick: (item:CarsItem)->Unit) : RecyclerView.Adapter<CarListAdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_item_view, parent, false)
        return CarListAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarListAdapterViewHolder, position: Int) {
        holder.initView(cars[position])
        holder.itemView.setOnClickListener{
            onClick(cars[position])
        }
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    fun updateData(cars:List<CarsItem>){
        this.cars = cars
        this.notifyDataSetChanged()
    }

    fun getDataList():List<CarsItem> = cars
}

class CarListAdapterViewHolder(itemView: View) : ViewHolder(itemView) {
    val image:ImageView = itemView.findViewById<ImageView>(R.id.imageview_zoek_item)
    val brand: TextView = itemView.findViewById(R.id.textview_item_brand)
    val price: TextView = itemView.findViewById(R.id.textview_item_price)
    fun initView(carsItem: CarsItem) {
        Glide.with(itemView.context)
            .load(carsItem.picture)
            .error(R.mipmap.no_image)
            .placeholder(R.mipmap.no_image)
            .into(image)
        brand.text = carsItem.make +" \n"+carsItem.model
        price.text = "€${carsItem.price} \n ${carsItem.year} \n ${carsItem.km}km"
    }

}