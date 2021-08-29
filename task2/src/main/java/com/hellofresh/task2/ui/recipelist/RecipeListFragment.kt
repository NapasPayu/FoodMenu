package com.hellofresh.task2.ui.recipelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellofresh.task2.databinding.FragmentRecipeListBinding
import com.hellofresh.task2.ui.common.BaseFragment
import com.hellofresh.task2.ui.recipelist.adapter.CurrentDateAdapter
import com.hellofresh.task2.ui.recipelist.adapter.RecipeListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipeListFragment : BaseFragment() {

    private lateinit var binding: FragmentRecipeListBinding
    private val viewModel: RecipeListViewModel by viewModel()
    private val headerAdapter by lazy { CurrentDateAdapter() }
    private val listAdapter by lazy { RecipeListAdapter() }
    private val concatAdapter by lazy { ConcatAdapter(headerAdapter, listAdapter) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentRecipeListBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = concatAdapter

        viewModel.alertEvent.observe(viewLifecycleOwner) {
            it?.let {
                showAlert(it)
            }
        }

        viewModel.currentDate.observe(viewLifecycleOwner) {
            it?.let {
                headerAdapter.submitList(listOf(it))
            }
        }

        viewModel.recipes.observe(viewLifecycleOwner) {
            it?.let {
                listAdapter.submitList(it)
            }
        }
    }
}

