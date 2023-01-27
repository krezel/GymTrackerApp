package com.example.gymtracker
import android.os.Parcelable
import java.io.Serializable
data class Training(val name:String,val weight:String,val date:String) : Serializable