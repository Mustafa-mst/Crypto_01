package com.sagul.cryptov2.service

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sagul.cryptov2.databinding.RecyclerRowBinding

class recyclerAdapter(var liste:ArrayList<CryptoModel>):RecyclerView.Adapter<recyclerAdapter.CryptoVh>() {
    class CryptoVh(val binding: RecyclerRowBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoVh {
        val binding=RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CryptoVh(binding)
    }

    override fun getItemCount(): Int {
        return liste.size
    }

    override fun onBindViewHolder(holder: CryptoVh, position: Int) {
        holder.binding.cryptoName.text=liste.get(position).currency
        holder.binding.crptoValues.text=liste.get(position).price
    }
}