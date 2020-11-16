package com.geektech.newsapp.ui.main

import Articles
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.geektech.newsapp.R
import kotlinx.android.synthetic.main.fragment_main.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment(),
    OnClickHolder {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val adapter = MainAdapter(this)
    private var viewModel: MainViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_main, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        request()
    }


    private fun init() {
        recycler_view.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = adapter

        Log.d("ololo", "init: $adapter")
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private fun request() {
        viewModel?.fetchNews()?.observe(this, Observer {
            if (it != null) {
                adapter.update(it.articles)
            }
        })
    }

    override fun onClickHolder(articles: Articles, position: Int) {
        TODO("Not yet implemented")
    }


}