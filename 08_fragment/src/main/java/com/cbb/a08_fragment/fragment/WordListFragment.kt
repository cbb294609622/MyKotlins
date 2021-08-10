package com.cbb.a08_fragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.cbb.a08_fragment.databinding.FragmentWordListBinding
import com.cbb.a08_fragment.fragment.adapter.WordAdapter
import kotlinx.android.synthetic.main.fragment_word_list.*

class WordListFragment : Fragment() {
    companion object{
        const val LETTER = "letter"
        val SEARCH_PREFIX = "https://www.baidu.com/s?wd="
    }

    private lateinit var letterId:String
    private var _binding: FragmentWordListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            letterId = it.getString(LETTER).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler_view.layoutManager = LinearLayoutManager(requireContext())
        recycler_view.adapter = WordAdapter(letterId,requireContext())
        recycler_view.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}