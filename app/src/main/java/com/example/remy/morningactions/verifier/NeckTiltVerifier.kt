package com.example.remy.morningactions.verifier

import android.util.Log
import com.google.android.gms.vision.face.Landmark.LEFT_EAR
import com.google.android.gms.vision.face.Landmark.RIGHT_EAR
import com.otaliastudios.cameraview.frame.Frame

class NeckTiltVerifier(val vListener: VerificationListener?, val position: String) :
    Verifier(vListener), IVerifier {

    override fun verify(frame: Frame) {
        if (verificationExpired()) {
            listener?.onVerificationCompleted(false, null)
        }
        faceDetector.detectInImage(super.visionImage(frame)).addOnSuccessListener { faces ->
            Log.d("FACES", "${this.javaClass.simpleName}: ${faces.size}");
            if (faces.isNotEmpty()) {
                for (face in faces) {

                    if (face.getLandmark(RIGHT_EAR) != null &&
                        face.getLandmark(LEFT_EAR) != null
                    ) {

                        if (position == "left") {
                            val success =
                                (face.getLandmark(RIGHT_EAR)!!.position.y
                                        - face.getLandmark(LEFT_EAR)!!.position.y
                                        ) > 100
                            if (success)
                                listener?.onVerificationCompleted(true, face)
                        }
                    }
//                    } else if (position == "right") {
////                        val success =
////                            (face.getLandmark(RIGHT_EAR)!!.position.y
////                                    - face.getLandmark(LEFT_EAR)!!.position.y
////                                    ) > 100
////                        if (success)
////                            listener?.onVerificationCompleted(true, face)
//                        listener?.onVerificationCompleted(true, face)
//                    }
                }
            }

        }.addOnFailureListener {
        }

    }
}