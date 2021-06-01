package com.raywenderlich.firstapichallenge.ui.countryscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.raywenderlich.firstapichallenge.data.Country
import com.raywenderlich.firstapichallenge.databinding.CountriesScreenFragmentBinding


class CountriesScreenFragment : Fragment() {


    private lateinit var binding: CountriesScreenFragmentBinding

    private lateinit var adapter: CountriesAdapter

    private val viewModel: CountriesScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CountriesScreenFragmentBinding.inflate(inflater,container,false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.swipe.setOnRefreshListener {
            adapter.clear()
            viewModel.load()
        }

        viewModel.load()
        viewModel.countryModel.observe(viewLifecycleOwner){
            showCountry(it)
        }

        viewModel.loading.observe(viewLifecycleOwner){
            binding.swipe.isRefreshing = it
        }

    }

    private fun showCountry(cntry: List<Country>){
        adapter = CountriesAdapter()
        adapter.countryList = cntry
        adapter.notifyDataSetChanged()
        val layoutManager = GridLayoutManager(context,1)
        binding.recyclerview.layoutManager = layoutManager
        binding.recyclerview.adapter = adapter


    }





}