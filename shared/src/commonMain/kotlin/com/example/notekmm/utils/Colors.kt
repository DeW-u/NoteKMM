package com.example.notekmm.utils
object Colors {
    const val RedOrangeHex = 0xffffab91
    const val RedPinkHex = 0xfff48fb1
    const val BabyBlueHex = 0xff81deea
    const val VioletHex = 0xffcf94da
    const val LightGreenHex = 0xffe7ed9b

    fun generateRandomColor(): Long {
        val list = listOf<Long>(RedOrangeHex, RedPinkHex, BabyBlueHex, VioletHex, LightGreenHex)

        return list.random()
    }
}