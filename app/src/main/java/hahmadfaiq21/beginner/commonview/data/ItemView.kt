package hahmadfaiq21.beginner.commonview.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemView (
    val name: String,
    val photo: Int
): Parcelable