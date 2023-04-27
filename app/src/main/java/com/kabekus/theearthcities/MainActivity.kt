package com.kabekus.theearthcities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.kabekus.theearthcities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var citiesList : ArrayList<City>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        citiesListFun()
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,citiesList.map { city -> city.name })
        binding.listView.adapter = adapter
        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this@MainActivity,DetailsActivity::class.java)
            intent.putExtra("city",citiesList.get(i))
            startActivity(intent)
        }
    }
    fun citiesListFun(){
        citiesList = ArrayList<City>()
        val istanbul = City("Istanbul","Türkiye",R.drawable.istanbul)
        val seul = City("Seul","South Korea",R.drawable.seul)
        val paris = City("Paris","France",R.drawable.paris)
        val roma = City("Roma","Italy",R.drawable.roma)
        val shenzhen = City("Shenzhen","China",R.drawable.shenzhen)
        val tokyo = City("Tokyo","Japan",R.drawable.tokyo)
        citiesList.add(istanbul)
        citiesList.add(seul)
        citiesList.add(paris)
        citiesList.add(roma)
        citiesList.add(shenzhen)
        citiesList.add(tokyo)
    }
}