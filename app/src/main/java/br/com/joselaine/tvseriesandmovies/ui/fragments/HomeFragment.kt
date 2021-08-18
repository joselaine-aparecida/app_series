package br.com.joselaine.tvseriesandmovies.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.joselaine.tvseriesandmovies.R
import br.com.joselaine.tvseriesandmovies.adapter.SerieActionAdapter
import br.com.joselaine.tvseriesandmovies.adapter.SerieAnimationAdapter
import br.com.joselaine.tvseriesandmovies.adapter.SeriePopularAdapter
import br.com.joselaine.tvseriesandmovies.adapter.SerieTopAdapter
import br.com.joselaine.tvseriesandmovies.databinding.HomeFragmentBinding
import br.com.joselaine.tvseriesandmovies.models.Serie
import br.com.joselaine.tvseriesandmovies.viewmodel.SerieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: SerieViewModel by viewModels()
    private lateinit var seriesPopularAdapter: SeriePopularAdapter
    private lateinit var seriesTopAdapter: SerieTopAdapter
    private lateinit var seriesActionAdapter: SerieActionAdapter
    private lateinit var serieAnimationAdapter: SerieAnimationAdapter
    private var binding: HomeFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRv()
        openSearch()
    }

    private fun openSearch() {
        binding?.btnSearch?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }
    }

    private fun configureRv() {
        viewModel.responseSeriesTop.observe(viewLifecycleOwner, { listSerie ->
            seriesTopAdapter.series = listSerie
        })

        viewModel.responsePopular.observe(viewLifecycleOwner, { listSerie ->
            seriesPopularAdapter.series = listSerie
        })

        viewModel.responseAction.observe(viewLifecycleOwner, { listSerie ->
            seriesActionAdapter.series = listSerie
        })

        viewModel.responseAnimation.observe(viewLifecycleOwner, { listSerie ->
            serieAnimationAdapter.series = listSerie
        })

        seriesPopularAdapter = SeriePopularAdapter {
            openDetails(it)

        }
        binding?.rvPopular?.adapter = seriesPopularAdapter
        binding?.rvPopular?.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL, false
        )
        binding?.rvPopular?.setHasFixedSize(true)


        seriesTopAdapter = SerieTopAdapter {
            openDetails(it)
        }

        binding?.rvTop?.adapter = seriesTopAdapter
        binding?.rvTop?.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL, false
        )
        binding?.rvTop?.setHasFixedSize(true)

        seriesActionAdapter = SerieActionAdapter {
            openDetails(it)
        }
        binding?.rvAction?.adapter = seriesActionAdapter
        binding?.rvAction?.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL, false
        )
        binding?.rvAction?.setHasFixedSize(true)

        serieAnimationAdapter = SerieAnimationAdapter {
            openDetails(it)
        }
        binding?.rvAnimation?.adapter = serieAnimationAdapter
        binding?.rvAnimation?.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL, false
        )
        binding?.rvAction?.setHasFixedSize(true)

    }

    private fun openDetails(it: Serie) {
        val bundle = Bundle()
        it.id?.toInt()?.let { id -> bundle.putInt("ID", id) }
        findNavController().navigate(R.id.action_homeFragment_to_detailsFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

