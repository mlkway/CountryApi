package com.raywenderlich.firstapichallenge.ui.countryscreen

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.raywenderlich.firstapichallenge.data.Country
import com.raywenderlich.firstapichallenge.databinding.CountrieItemBinding

class CountriesAdapter:RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    var countryList: List<Country> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CountrieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = countryList.size

    inner class ViewHolder(private val binding: CountrieItemBinding):RecyclerView.ViewHolder(binding.root){

        private lateinit var currentPosition: Country
        fun bind(){
            currentPosition = countryList[adapterPosition]
            binding.imageView3.loadSvg(currentPosition.flag)
            binding.textView.text = currentPosition.name
            binding.textView2.text = currentPosition.capital

        }
    }

    fun clear(){
        countryList = emptyList()
        notifyDataSetChanged()
    }



    fun ImageView.loadSvg(url: String){
        GlideToVectorYou
            .init()
            .with(this.context)
            .load(Uri.parse(url),this)
    }

}