package com.example.remy.morningactions.verifier

import com.otaliastudios.cameraview.frame.Frame

interface IVerifier {

    fun verify(frame: Frame)
}