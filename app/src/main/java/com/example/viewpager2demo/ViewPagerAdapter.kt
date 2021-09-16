package com.example.viewpager2demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2demo.databinding.ItemViewPagerBinding

class ViewPagerAdapter(val images:List<Int>):RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    class ViewPagerViewHolder(view: ItemViewPagerBinding):RecyclerView.ViewHolder(view.root){
    val viewImage = view.ivImage

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val binding:ItemViewPagerBinding = ItemViewPagerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       // val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager,parent,false)
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currentImage = images[position]
        holder.viewImage.setImageResource(currentImage)
    }

    override fun getItemCount(): Int {
       return images.size
    }
}