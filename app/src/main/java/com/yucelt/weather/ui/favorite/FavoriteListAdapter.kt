package com.yucelt.weather.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.yucelt.domain.model.FavoriteCity
import com.yucelt.weather.R
import com.yucelt.weather.databinding.ItemFavoriteCityBinding

class FavoriteListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val viewDatas: MutableList<FavoriteCity> = ArrayList()

    var eventHandler: FavoriteCityEventHandler? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_favorite_city,
            parent,
            false
        )
        return FavoriteCityItemViewHolder(holderBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? FavoriteCityItemViewHolder)?.onBind(getItem(position))
    }

    override fun getItemCount() = viewDatas.size

    private fun getItem(position: Int) = viewDatas[position]

    fun submitData(list: List<FavoriteCity>) {
        this.viewDatas.clear()
        this.viewDatas.addAll(list)
        notifyDataSetChanged()
    }

    inner class FavoriteCityItemViewHolder(private val dataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {
        fun onBind(viewData: FavoriteCity) {
            val binding = dataBinding as ItemFavoriteCityBinding
            binding.item = viewData
            binding.root.setOnClickListener {
                eventHandler?.onFavoriteCityClicked(viewData)
            }
        }
    }

    interface FavoriteCityEventHandler {
        fun onFavoriteCityClicked(viewData: FavoriteCity)
    }
}