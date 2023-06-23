package com.guntermg.colorblindnessapp.ui.model

import android.annotation.SuppressLint
import android.os.Parcelable
import com.guntermg.colorblindnessapp.R

data class IshiharaPlate(
    val src : Int,
    val number: Int,
    val possible: Int? = null,
    val answer: Int? = null,
) {
    companion object {
        @SuppressLint("UseCompatLoadingForDrawables")
        val questions: MutableList<IshiharaPlate> = mutableListOf(
            IshiharaPlate(R.drawable.plate1, 12, 12),
            IshiharaPlate(R.drawable.plate2, 8, 3),
            IshiharaPlate((R.drawable.plate3), 29, 70),
            IshiharaPlate((R.drawable.plate4), 5, 2),
            IshiharaPlate((R.drawable.plate5), 3, 5),
            IshiharaPlate((R.drawable.plate6), 15, 17),
            IshiharaPlate((R.drawable.plate7), 74, 21),
            IshiharaPlate((R.drawable.plate8), 6, -1),
            IshiharaPlate((R.drawable.plate9), 45, -1),
            IshiharaPlate((R.drawable.plate10), 5, -1),
            IshiharaPlate((R.drawable.plate11), 7, -1),
            IshiharaPlate((R.drawable.plate12), 16, -1),
            IshiharaPlate((R.drawable.plate13), 73, -1),
        )
    }
}
