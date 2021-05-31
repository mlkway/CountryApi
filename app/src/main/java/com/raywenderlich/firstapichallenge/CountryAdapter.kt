package com.raywenderlich.firstapichallenge

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.raywenderlich.firstapichallenge.data.Country
import com.raywenderlich.firstapichallenge.databinding.ItemCountryBinding

class CountryAdapter(
    private val data: List<Country>?) : RecyclerView.Adapter<CountryAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.ViewHolder {
        val view = ItemCountryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryAdapter.ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount()=data!!.size

    inner class ViewHolder(private val binding: ItemCountryBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(){
            binding.countryNameTxt.text = data?.get(adapterPosition)?.name.toString()
            binding.countryFlagImg.loadSvg(data?.get(adapterPosition)?.flag)

        }
    }



    fun ImageView.loadSvg(url: String?) {
        GlideToVectorYou
            .init()
            .with(this.context)
            .load(Uri.parse(url), this)
    }

}