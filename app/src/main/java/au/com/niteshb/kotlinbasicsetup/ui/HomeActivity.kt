package au.com.niteshb.kotlinbasicsetup.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import au.com.niteshb.kotlinbasicsetup.R
import au.com.niteshb.kotlinbasicsetup.adapter.HomePageAdapter
import au.com.niteshb.kotlinbasicsetup.base.BaseActivity
import au.com.niteshb.kotlinbasicsetup.databinding.ActivityHomeBinding
import au.com.niteshb.kotlinbasicsetup.interfaces.ItemClickListener

class HomeActivity : AppCompatActivity(), ItemClickListener<String> {

    private lateinit var binder: ActivityHomeBinding
    private lateinit var homeAdapter: HomePageAdapter

    private lateinit var viewModelFactoryActivityLuncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = DataBindingUtil.setContentView(this, R.layout.activity_home)
        val linearLayoutManager = LinearLayoutManager(this)
        var dataList : ArrayList<String> = ArrayList()
        dataList.add("ViewModelFactory")
        dataList.add("DataBinding with View(XML)")
        dataList.add("Two way DataBinding")
        dataList.add("Bottom Navigation Activity")

        homeAdapter = HomePageAdapter(dataList = dataList, this)
        binder.recyclerView.layoutManager = linearLayoutManager
        binder.recyclerView.adapter = homeAdapter
        configureLunchers()

    }

    private fun configureLunchers() {
        viewModelFactoryActivityLuncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult())
        { result ->
            if(result.resultCode == RESULT_OK){
                Toast.makeText(this, "ViewModelFactory Example success", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onItemClick(item: String, position: Int) {

        when (position){
            0 ->{
                val intent = Intent(this, AddActivity::class.java)
                viewModelFactoryActivityLuncher.launch(intent)
            }
            1 ->{
                val intent = Intent(this, VMDataBindingActivity::class.java)
                viewModelFactoryActivityLuncher.launch(intent)
            }
            2 ->{
                val intent = Intent(this, TwoWayBindingActivity::class.java)
                viewModelFactoryActivityLuncher.launch(intent)
            }
            3 ->{
                val intent = Intent(this, NavigationActivity::class.java)
                viewModelFactoryActivityLuncher.launch(intent)
            }
        }
    }
}