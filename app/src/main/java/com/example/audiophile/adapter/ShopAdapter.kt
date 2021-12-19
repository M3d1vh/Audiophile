package com.example.audiophile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.audiophile.R
import com.example.audiophile.model.Shop

typealias OnShopClickListener = (Shop) -> Unit

class ShopAdapter (
    private val shops : List<Shop>,
    private val listener : OnShopClickListener,
) : RecyclerView.Adapter<ShopAdapter.ShopsVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopsVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ShopsVH(
            layoutInflater.inflate(R.layout.item_shop, parent, false),
            listener
        )
    }

    override fun onBindViewHolder(holder: ShopsVH, position: Int) =
        holder.bind(shops[position])

    override fun getItemCount(): Int = shops.size


    class ShopsVH(
        view: View,
        listener: OnShopClickListener
    ) : RecyclerView.ViewHolder(view) {

        private val imageShop = view.findViewById<ImageView>(R.id.imageShop)
        private val nameShop = view.findViewById<TextView>(R.id.nameShop)
        private val itemPrice = view.findViewById<TextView>(R.id.itemPrice)
        private val itemAvailable = view.findViewById<TextView>(R.id.itemAvailable)
        private val itemDelivery = view.findViewById<TextView>(R.id.itemDelivery)
        private lateinit var shop: Shop

        init {
            view.setOnClickListener { listener(shop) }
        }

        fun bind(shop: Shop) {
            this.shop = shop
            nameShop.text = shop.shopName
            itemPrice.text = shop.price
            itemAvailable.text = shop.available
            itemDelivery.text = shop.delivery
            imageShop.setImageResource(shop.im_shopID)
        }
    }
}