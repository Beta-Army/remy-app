package com.example.remy.onboarding

import com.example.remy.R

object OnBoarding {

    public const val ONBOARD_STEP = "onboard_step"

    public val ONBOARD_STEP_GIFS = intArrayOf(
        R.drawable.namaste,
        R.drawable.looking_excited,
        R.drawable.thinking,
        R.drawable.excited_claps,
        R.drawable.thumbs_up,
        R.drawable.shrug,
        R.drawable.wave_bye
    )

    public val ONBOARD_STEP_INSTRUCTIONS = arrayOf(
        "Namaste! I am Remy, your friendly assistant",
        "I am going to be your constant companion and friend",
        "You might be thinking, what will I do?",
        "We will meet everyday at 08:00 AM and do some fun activities!",
        "I will make sure you have no health troubles",
        "You can always open the Remy app to talk to me!",
        "Let us meet tomorrow morning! Till then, have a nice day!"
    )
}