package com.example.dictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.dictionary.databinding.ActivityOnboardingBinding
import com.example.dictionary.OnboardingAdapter

class OnboardingActivity : AppCompatActivity(R.layout.activity_onboarding) {

    private lateinit var binding: ActivityOnboardingBinding
    private val adapter = OnboardingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() = with(binding) {
        viewPager.adapter = adapter
        viewPager.registerOnPageChangeCallback(
            object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    changePage(position)
                }
            }
        )

        pageIndicator.attachTo(viewPager)

        nextButton.setOnClickListener {
            if (adapter.itemCount == viewPager.currentItem + 1) {
                onContinue()
            } else {
                changePage(viewPager.currentItem.plus(1))
            }
        }
        skipText.setOnClickListener {
            onContinue()
        }
    }

    private fun changePage(position: Int) = with(binding) {
        viewPager.currentItem = position
        
        nextButton.text = getString(
            if (adapter.itemCount == viewPager.currentItem + 1) R.string.onboarding_continue else R.string.onboarding_next
        )
    }

    private fun onContinue() {
        //TODO: Go to Auth Screen
    }
}