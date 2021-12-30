package com.example.audiophile.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.audiophile.R
import com.example.audiophile.domain.model.Stores

typealias OnShopClickListener = (Stores) -> Unit

class StoresAdapter (
    private val shops : List<Stores>,
    private val listener : OnShopClickListener,
) : RecyclerView.Adapter<StoresAdapter.StoresVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoresVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        return StoresVH(
            layoutInflater.inflate(R.layout.item_shop, parent, false),
            listener
        )
    }

    override fun onBindViewHolder(holder: StoresVH, position: Int) =
        holder.bind(shops[position])

    override fun getItemCount(): Int = shops.size


    class StoresVH(
        view: View,
        listener: OnShopClickListener
    ) : RecyclerView.ViewHolder(view) {

        private val imageShop = view.findViewById<ImageView>(R.id.imageShop)
        private val nameShop = view.findViewById<TextView>(R.id.nameShop)
        private val itemPrice = view.findViewById<TextView>(R.id.itemPrice)
        private val itemAvailable = view.findViewById<TextView>(R.id.itemAvailable)
        private val itemDelivery = view.findViewById<TextView>(R.id.itemDelivery)
        private lateinit var stores: Stores

        init {
            view.setOnClickListener { listener(stores) }
        }

        fun bind(stores: Stores) {
            this.stores = stores
            nameShop.text = stores.nameShop
            itemPrice.text = stores.price
            itemAvailable.text = stores.available
            itemDelivery.text = stores.delivery
            Glide
                .with(itemView)
                .load(stores.iconShopURL)
                .centerCrop()
                .placeholder(R.drawable.image_icon)
                .into(imageShop)
        }
    }
}