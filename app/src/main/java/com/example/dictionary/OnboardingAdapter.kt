package com.example.dictionary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.databinding.ItemOnboardingSlideBinding

class OnboardingAdapter : RecyclerView.Adapter<OnboardingAdapter.SlideViewHolder>() {

    companion object {
        private const val SIZE = 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideViewHolder {
        val binding = ItemOnboardingSlideBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return SlideViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SlideViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = SIZE

    inner class SlideViewHolder(private val binding: ItemOnboardingSlideBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val resInfo = when (position) {
                0 -> SlideInfo(
                    R.drawable.ic_learn,
                    R.string.onboarding_learn_title
                )
                1 -> SlideInfo(
                    R.drawable.ic_find,
                    R.string.onboarding_find_course_title
                )
                else -> SlideInfo(
                    R.drawable.ic_improve,
                    R.string.onboarding_improve_skills_title
                )
            }

            with(binding) {
                imageView.setImageResource(resInfo.imageRes)
                titleText.setText(resInfo.titleRes)
            }
        }
    }

    private data class SlideInfo(
        @DrawableRes
        val imageRes: Int,
        @StringRes
        val titleRes: Int
    )
}