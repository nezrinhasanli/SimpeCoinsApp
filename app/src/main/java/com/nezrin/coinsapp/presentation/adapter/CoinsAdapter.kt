package com.nezrin.coinsapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.nezrin.coinsapp.domain.model.CoinsResponseItem
import com.nezrin.coinsapp.databinding.CardViewBinding
import com.nezrin.coinsapp.presentation.view.coin_list.CoinListFragmentDirections

class CoinsAdapter(private var coinsList:List<CoinsResponseItem>): RecyclerView.Adapter<CoinsAdapter.CoinsItemsHolder>() {

    inner class CoinsItemsHolder(val view: CardViewBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinsItemsHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = CardViewBinding.inflate(layoutInflater, parent, false)
        return CoinsItemsHolder(view)
    }

    override fun onBindViewHolder(holder: CoinsItemsHolder, position: Int) {
        val coin = coinsList[position]
        val binding = holder.view

        binding.name.text = coin.name
        binding.symbol.text = coin.symbol

        binding.cardView.setOnClickListener {
            val directions=CoinListFragmentDirections.fromListToDetail(coin.id)
            Navigation.findNavController(it).navigate(directions)
        }
    }

    override fun getItemCount(): Int {
        return coinsList.size
    }
    fun update(newCoinList: List<CoinsResponseItem>){
        this.coinsList= newCoinList
        notifyDataSetChanged()
    }
}