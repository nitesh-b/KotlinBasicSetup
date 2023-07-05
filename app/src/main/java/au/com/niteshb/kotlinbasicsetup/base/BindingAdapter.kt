package au.com.niteshb.kotlinbasicsetup.base

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:visibleOrGone")
fun setVisibleOrGone(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}
