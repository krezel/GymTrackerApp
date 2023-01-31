package com.example.gymtracker
import android.os.Parcel
import android.os.Parcelable
data class Training(val name: String?, val weight: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(weight)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Training> {
        override fun createFromParcel(parcel: Parcel): Training {
            return Training(parcel)
        }

        override fun newArray(size: Int): Array<Training?> {
            return arrayOfNulls(size)
        }
    }
}