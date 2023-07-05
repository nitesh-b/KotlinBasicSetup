package au.com.niteshb.kotlinbasicsetup.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import au.com.niteshb.kotlinbasicsetup.databinding.ItemHomeLayoutBinding
import au.com.niteshb.kotlinbasicsetup.interfaces.ItemClickListener

class HomePageAdapter(private val dataList: ArrayList<String>, private val itemClickListener : ItemClickListener<String>): RecyclerView.Adapter<HomePageAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemHomeLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item, position)
    }

    inner class MyViewHolder(private val binding: ItemHomeLayoutBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String, position: Int) {
            binding.titleText.text = item
            binding.executePendingBindings()
            binding.root.setOnClickListener{
                itemClickListener.onItemClick(item, position)
            }
        }
    }

}