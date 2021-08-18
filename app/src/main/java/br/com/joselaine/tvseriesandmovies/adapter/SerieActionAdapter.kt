package br.com.joselaine.tvseriesandmovies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.joselaine.tvseriesandmovies.R
import br.com.joselaine.tvseriesandmovies.databinding.SerieItemHorizontalBinding
import br.com.joselaine.tvseriesandmovies.helpers.Constants
import br.com.joselaine.tvseriesandmovies.models.Serie
import com.bumptech.glide.Glide

class SerieActionAdapter(private val onClickListener: (serie: Serie) -> Unit) :
    RecyclerView.Adapter<SerieActionAdapter.SerieViewHolder>() {

    inner class SerieViewHolder(val binding: SerieItemHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<Serie>() {
        override fun areItemsTheSame(oldItem: Serie, newItem: Serie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Serie, newItem: Serie): Boolean {
            return newItem == oldItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallBack)
    var series: List<Serie>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SerieViewHolder {
        return SerieViewHolder(
            SerieItemHorizontalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SerieViewHolder, position: Int) {
        val serieAtual = series[position]
        Glide.with(holder.binding.ivPoster)
            .load(Constants.IMAGE + serieAtual.poster_path)
            .placeholder(R.drawable.no_image)
            .error(R.drawable.no_image)
            .into(holder.binding.ivPoster)
        holder.binding.ivPoster.setOnClickListener {
            onClickListener(serieAtual)
        }
    }

    override fun getItemCount() = series.size

}
