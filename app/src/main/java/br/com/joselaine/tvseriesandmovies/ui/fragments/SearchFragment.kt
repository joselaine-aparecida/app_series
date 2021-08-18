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
import br.com.joselaine.tvseriesandmovies.adapter.SearchAdapter
import br.com.joselaine.tvseriesandmovies.databinding.SearchFragmentBinding
import br.com.joselaine.tvseriesandmovies.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by viewModels()
    lateinit var binding: SearchFragmentBinding
    private val adapter = SearchAdapter {
        val bundle = Bundle()
        it.id?.toInt()?.let { id -> bundle.putInt("ID", id) }
        findNavController().navigate(R.id.action_searchFragment_to_detailsFragment, bundle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        search()
        configRecycle()
        back()
    }

    private fun back() {
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun search() {
        binding.searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel.searchSerie(it)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun configRecycle() {
        viewModel.responseSearch.observe(viewLifecycleOwner, { listSerie ->
            adapter.series = listSerie
        })
        binding.rvSearchSeries.adapter = adapter
        binding.rvSearchSeries.layoutManager = LinearLayoutManager(requireContext())
    }
}