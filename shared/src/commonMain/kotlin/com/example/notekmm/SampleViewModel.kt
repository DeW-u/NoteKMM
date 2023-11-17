package com.example.notekmm

import dev.icerock.moko.mvvm.viewmodel.ViewModel

class SampleViewModel(private val useCase: KoinSampleUC): ViewModel() {

    fun getString() = useCase.getKoinString()
}