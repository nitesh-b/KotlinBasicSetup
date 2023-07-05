package au.com.niteshb.kotlinbasicsetup.interfaces

interface ItemClickListener<T> {
    fun onItemClick(item: T, position: Int)
}