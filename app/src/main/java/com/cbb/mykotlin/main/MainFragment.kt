package com.cbb.mykotlin.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cbb.mykotlin.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java).apply {
            liveList.observe(this@MainFragment, Observer {
                mAdapter.submitList(it)
                mAdapter.notifyDataSetChanged()
            })
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        return binding.root
    }

}