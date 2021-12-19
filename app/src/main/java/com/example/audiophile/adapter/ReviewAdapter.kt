package com.example.audiophile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.audiophile.R
import com.example.audiophile.model.Review

typealias OnReviewClickListener = (Review) -> Unit
class ReviewAdapter (
    private val reviews : List<Review>,
    private val listener : OnReviewClickListener,
) : RecyclerView.Adapter<ReviewAdapter.ReviewsVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ReviewsVH(
            layoutInflater.inflate(R.layout.item_reviews, parent, false),
            listener
        )
    }

    override fun onBindViewHolder(holder: ReviewsVH, position: Int) =
        holder.bind(reviews[position])

    override fun getItemCount(): Int = reviews.size


    class ReviewsVH(
        view: View,
        listener: OnReviewClickListener
    ) : RecyclerView.ViewHolder(view) {

        private val userName = view.findViewById<TextView>(R.id.User_name)
        private val dateReview = view.findViewById<TextView>(R.id.reviews_date)
        private val useTime = view.findViewById<TextView>(R.id.uses_time)
        private val dignity = view.findViewById<TextView>(R.id.dignity_text)
        private val limits = view.findViewById<TextView>(R.id.limitations_text)
        private val commentProduct = view.findViewById<TextView>(R.id.comments_text)
        private lateinit var review: Review

        init {
            view.setOnClickListener { listener(review) }
        }

        fun bind(review: Review) {
            this.review = review
            userName.text = review.userName
            dateReview.text = review.Date
            useTime.text = review.useTime
            dignity.text = review.dignity
            limits.text = review.limits
            commentProduct.text = review.comment
        }
    }
}