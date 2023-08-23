package com.nezrin.coinsapp.presentation.view.coin_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nezrin.coinsapp.R
import com.nezrin.coinsapp.common.Resource
import com.nezrin.coinsapp.databinding.FragmentCoinListBinding
import com.nezrin.coinsapp.presentation.adapter.CoinsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinListFragment : Fragment() {

    private val viewModel by viewModels<CoinListViewModel>()
    private lateinit var binding: FragmentCoinListBinding
    private lateinit var adapter: CoinsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCoinListBinding.inflate(inflater,container,false)

        addObservers()

        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        binding.rv.setHasFixedSize(true)
        adapter = CoinsAdapter(ArrayList())
        binding.rv.adapter = adapter

        return binding.root
    }

  private fun addObservers(){
        viewModel.getCoins().observe(viewLifecycleOwner){

            when(it){
                is Resource.Loading ->{
                    binding.progressBar.visibility=VISIBLE
                }
                is Resource.Success ->{
                    val data=it.data
                    binding.progressBar.visibility=GONE
                    adapter.update(data)
                }
                is Resource.Error ->{
                    binding.progressBar.visibility=GONE
                    val error=it.exception
                    Toast.makeText(requireContext(), error.toString(), Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}