package com.guntermg.colorblindnessapp.ui.model

import android.annotation.SuppressLint
import android.os.Parcelable
import com.guntermg.colorblindnessapp.R
import com.guntermg.colorblindnessapp.common.Constants

data class IshiharaPlate(
    val src : Int,
    val number: Int,
    val relation: String,
    val possible: Int? = null,
    val answer: Int? = null,
) {
    companion object {
        val questions12Plate: MutableList<IshiharaPlate> = mutableListOf(
            IshiharaPlate(R.drawable.ishihara_plate_01_12, 12, Constants.FAKED , 12),
            IshiharaPlate(R.drawable.ishihara_plate_02_8, 8, Constants.RED_GREEN , 3),
            IshiharaPlate((R.drawable.ishihara_plate_03_5), 5, Constants.RED_GREEN , 2),
            IshiharaPlate((R.drawable.ishihara_plate_04_29), 29, Constants.RED_GREEN , 70),
            IshiharaPlate((R.drawable.ishihara_plate_05_74), 74, Constants.RED_GREEN , 21),
            IshiharaPlate((R.drawable.ishihara_plate_06_7), 7, Constants.RED_GREEN , -1),
            IshiharaPlate((R.drawable.ishihara_plate_07_45), 45, Constants.RED_GREEN , -1),
            IshiharaPlate((R.drawable.ishihara_plate_08_2), 2, Constants.RED_GREEN , -1),
            IshiharaPlate((R.drawable.ishihara_plate_09_2), -1, Constants.RED_GREEN , 2),
            IshiharaPlate((R.drawable.ishihara_plate_10_16), 16, Constants.RED_GREEN , -1),
            IshiharaPlate((R.drawable.ishihara_plate_11_35), 35, Constants.DEUTERANOPY , -1),
            IshiharaPlate((R.drawable.ishihara_plate_12_96), 96, Constants.DEUTERANOPY , -1),
        )
    }
}


//@SuppressLint("UseCompatLoadingForDrawables")
//val questions: MutableList<IshiharaPlate> = mutableListOf(
//    IshiharaPlate(R.drawable.plate1, 12, Constants.FAKED , 12),
//    IshiharaPlate(R.drawable.plate2, 8, Constants.PROTANOPY , 3),
//    IshiharaPlate((R.drawable.plate3), 29, Constants.PROTANOPY , 70),
//    IshiharaPlate((R.drawable.plate4), 5, Constants.DEUTERANOPY , 2),
//    IshiharaPlate((R.drawable.plate5), 3, Constants.DEUTERANOPY , 5),
//    IshiharaPlate((R.drawable.plate6), 15, Constants.DEUTERANOPY , 17),
//    IshiharaPlate((R.drawable.plate7), 74, Constants.DEUTERANOPY , 21),
//    IshiharaPlate((R.drawable.plate8), 6, Constants.PROTANOPY , -1),
//    IshiharaPlate((R.drawable.plate9), 45, Constants.PROTANOPY , -1),
//    IshiharaPlate((R.drawable.plate10), 5, Constants.DEUTERANOPY , -1),
//    IshiharaPlate((R.drawable.plate11), 7, Constants.DEUTERANOPY , -1),
//    IshiharaPlate((R.drawable.plate12), 16, Constants.DEUTERANOPY , -1),
//    IshiharaPlate((R.drawable.plate13), 73, Constants.DEUTERANOPY , -1),
//)