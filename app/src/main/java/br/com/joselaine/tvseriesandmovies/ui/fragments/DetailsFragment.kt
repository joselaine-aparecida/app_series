package br.com.joselaine.tvseriesandmovies.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.joselaine.tvseriesandmovies.R
import br.com.joselaine.tvseriesandmovies.databinding.DetailsFragmentBinding
import br.com.joselaine.tvseriesandmovies.helpers.Constants
import br.com.joselaine.tvseriesandmovies.viewmodel.DetailsViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by viewModels()
    private lateinit var binding: DetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDetails()
        viewModel.detail.observe(viewLifecycleOwner, {
            if (it != null) {
                binding.tvTitleSerie.text = it.name
                binding.tvTemporadas.text = it.number_of_seasons.toString()
                binding.tvEpisodios.text = it.number_of_episodes.toString()
                if (it.original_name != it.name){
                    binding.tvTitleSerieOriginal.text = it.original_name
                } else {
                    binding.tvTitleSerieOriginal.isVisible = false
                }

                if (it.overview.isNotBlank()){
                    binding.tvOverview.text = it.overview
                } else{
                    binding.tvOverview.text = getString(R.string.no_resume)
                }

                when {
                    it.poster_path != null -> {
                        Glide.with(binding.ivPoster).load(Constants.IMAGE + it.poster_path)
                            .into(binding.ivPoster)
                    }
                    it.backdrop_path != null -> {
                        Glide.with(binding.ivPoster).load(Constants.IMAGE + it.backdrop_path)
                            .into(binding.ivPoster)
                    }
                    else -> {
                        binding.ivPoster.setImageResource(R.drawable.no_image)
                    }
                }

            }
        })
        back()
    }

    private fun back() {
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setDetails() {
        val id = arguments?.getInt("ID")
        id?.let { viewModel.getDetails(id) }
    }
}