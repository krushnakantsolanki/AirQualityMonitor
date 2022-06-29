package com.proximity.airquality.aqcitylist.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.proximity.airquality.R
import com.proximity.airquality.databinding.FragmentCityListBinding
import com.proximity.airquality.di.injectViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [AQICityListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AQICityListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: AQICityListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = injectViewModel(viewModelFactory)
        // Inflate the layout for this fragment

        val binding = FragmentCityListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = LegoThemeAdapter()
        binding.recyclerView.addItemDecoration(
            VerticalItemDecoration(resources.getDimension(R.dimen.margin_normal).toInt(), true) )
        binding.recyclerView.adapter = adapter

        subscribeUi(binding, adapter)

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment CityListFragment.
         */
        @JvmStatic
        fun newInstance() =
            AQICityListFragment()

    }
}