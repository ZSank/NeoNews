package com.example.topnewsapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.topnewsapp.R
import com.example.topnewsapp.adapter.NewsListAdapter
import com.example.topnewsapp.databinding.FragmentFrag1Binding

class Frag1 : Fragment() {


	private val viewModel: Frag1ViewModel by activityViewModels()

	private lateinit var binding: FragmentFrag1Binding
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_frag1, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding.viewmodel = viewModel
		binding.lifecycleOwner = this
//		val tempData: List<Article> = listOf(
//			Article("Title1"),
//			Article("Title2"),
//			Article("Title3")
//		)

		binding.rcy.adapter = NewsListAdapter()
//		binding.but.setOnClickListener {
//			adapter.submitList(viewModel.news.value?.articles)
//		}


	}
}