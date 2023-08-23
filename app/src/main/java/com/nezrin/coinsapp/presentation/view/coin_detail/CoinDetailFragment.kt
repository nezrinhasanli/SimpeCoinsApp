package com.nezrin.coinsapp.presentation.view.coin_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.nezrin.coinsapp.R
import com.nezrin.coinsapp.common.Resource
import com.nezrin.coinsapp.databinding.FragmentCoinDetailBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinDetailFragment : Fragment() {
    private lateinit var binding: FragmentCoinDetailBinding
    private val viewModel by viewModels<CoinDetailViewModel>()
    val args by navArgs<CoinDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoinDetailBinding.inflate(inflater, container, false)



        viewModel.getCoinById(args.id).observe(viewLifecycleOwner){

            when(it){
                is Resource.Loading ->{
//                    binding.progressBar.visibility= View.VISIBLE
                }
                is Resource.Success ->{
                    val data=it.data

                    binding.textViewName.text=data.name
                    binding.textViewSymbol.text=data.symbol
                    binding.textViewType.text=data.type
                    binding.textViewDescription.text=data.description
                    Picasso.get().load(data.logo).into(binding.imageViewCoin)

//                    binding.progressBar.visibility= View.GONE
//                    adapter.update(data)
                }
                is Resource.Error ->{
//                    binding.progressBar.visibility= View.GONE
                    val error=it.exception
                    Toast.makeText(requireContext(), error.toString(), Toast.LENGTH_SHORT).show()

                }
            }
        }

        return binding.root
    }

}