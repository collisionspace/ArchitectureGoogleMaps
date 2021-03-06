package com.example.danielslone.architecturegooglemaps.presentation.bike.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.danielslone.architecturegooglemaps.R
import com.example.danielslone.architecturegooglemaps.presentation.bike.adapter.model.BikeShareCityInformationItem
import kotlinx.android.synthetic.main.item_city_bike_info.view.*

/**
 * Created by danielslone on 2/24/18.
 */
class GoogleMapsAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    private companion object {
        const val VIEW_TYPE_CITY = 0
    }

    // region Adapter
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    var bikeShareCityInformationRows: List<BikeShareCityInformationItem> = listOf()

    override fun getItemViewType(position: Int): Int {
        return VIEW_TYPE_CITY
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val cityInformationItem = bikeShareCityInformationRows[position]

        with(holder.itemView) {
            when (cityInformationItem) {
               is BikeShareCityInformationItem -> setCityInformation(context, bikeShareNameTextView, cityTextView, cityInformationItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            VIEW_TYPE_CITY -> CityInformationItemViewHolder(layoutInflater.inflate(R.layout.item_city_bike_info, parent, false))
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int = bikeShareCityInformationRows.size
    // endregion

    // region Private Functions
    private fun setCityInformation(context: Context, bikeShareNameTextView: TextView, cityTextView: TextView, bikeShareCityInformationItem: BikeShareCityInformationItem) {
        with(bikeShareCityInformationItem) {
            val formattedCityName = context.getString(R.string.city_country_name, city, country)

            bikeShareNameTextView.text = bikeShareName
            cityTextView.text = formattedCityName
        }
    }
    // endregion

    // region View Holders
    private class CityInformationItemViewHolder(cityInformationItem: View) : RecyclerView.ViewHolder(cityInformationItem)
    // endregion
}