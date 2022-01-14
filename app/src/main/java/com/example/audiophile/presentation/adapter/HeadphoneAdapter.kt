package com.example.audiophile.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.audiophile.R
import com.example.audiophile.domain.model.Headphone

typealias OnHeadphoneClickListener = (Headphone) -> Unit

class HeadphoneAdapter (
    private val headphones : List<Headphone>,
    private val listener : OnHeadphoneClickListener,
) : RecyclerView.Adapter<HeadphoneAdapter.HeadphonesVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadphonesVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeadphonesVH(
            layoutInflater.inflate(R.layout.item_headpnone, parent, false),
            listener
        )
    }

    override fun onBindViewHolder(holder: HeadphonesVH, position: Int) =
        holder.bind(headphones[position])

    override fun getItemCount(): Int = headphones.size


    class HeadphonesVH(
        view: View,
        listener: OnHeadphoneClickListener
    ) : RecyclerView.ViewHolder(view) {

        private val iconURL= view.findViewById<ImageView>(R.id.imageProduct)
        private val nameProduct = view.findViewById<TextView>(R.id.nameProduct)
        private val descProduct = view.findViewById<TextView>(R.id.descProduct)
        private lateinit var headphone: Headphone

        init {
            view.setOnClickListener { listener(headphone) }
        }

        fun bind(headphone: Headphone) {
            this.headphone = headphone
            nameProduct.text = headphone.model
            descProduct.text = headphone.description
            Glide
                .with(itemView)
                .load(headphone.iconUrl)
                .centerCrop()
                .placeholder(R.drawable.image_icon)
                .into(iconURL)
        }
    }
}