package com.kabekus.theearthcities

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kabekus.theearthcities.databinding.RecyclerRowBinding

class CityAdapter(val cityList : ArrayList<City>) : RecyclerView.Adapter<CityAdapter.CityHolder>() {
    class CityHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    /*
    ViewHolder ilk oluşturulduğunda ne olacak gibi işlemler,
    Layout (recycler_row) ile bağlama işlemi(view binding kullanılarak) onCreateViewHolder'da yapılır .
    */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CityHolder(binding)
    }

    //Kaç tane oluşturulacağı onBindingViewHolder'da yapılır
    override fun getItemCount(): Int {
        return cityList.size
    }

    /*
    Bağlandıktan sonra ne olacağı yani hangi text'te hangi veri kullanılacak gibi işlemler
    getItemCount'ta yapılır
    */
    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        holder.binding.recyclerViewTxt.text = cityList.get(position).name

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            //intent.putExtra("city",cityList.get(position))
            Singleton.chosenCity = cityList.get(position)
            holder.itemView.context.startActivity(intent)
        }
    }
}