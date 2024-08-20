package hahmadfaiq21.beginner.commonview.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemViews (
    val name: String,
    val photo: Int
): Parcelable