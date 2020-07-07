package com.quastio.framelibrary.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.quastio.framelibrary.Frame
import com.quastio.framelibrary.R
import com.quastio.framelibrary.adapters.PostListAdapter
import com.quastio.framelibrary.models.Child
import com.quastio.framelibrary.models.ResultWrapper
import com.quastio.framelibrary.viewmodels.PostListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PostListAdapter.Interaction {
    private lateinit var postListViewModel:PostListViewModel
    private lateinit var postListAdapter: PostListAdapter
    private lateinit var packLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postListAdapter= PostListAdapter(this)
        recycler_view.adapter = postListAdapter
        packLayoutManager = LinearLayoutManager(this)
        packLayoutManager.orientation = RecyclerView.VERTICAL
        val dividerItemDecoration = DividerItemDecoration(
            recycler_view.context,
            packLayoutManager.orientation
        )
        recycler_view.addItemDecoration(dividerItemDecoration)
        recycler_view.layoutManager = packLayoutManager

        postListViewModel=ViewModelProvider(this).get(PostListViewModel::class.java)
        postListViewModel.getPosts().observe(this, Observer {
            it?.let {
                when(it){
                    is ResultWrapper.Success -> {
                        val list=it.data
                        if (list!=null&&list.isNotEmpty()){
                        if (this::postListAdapter.isInitialized){
                            postListAdapter.submitList(list)
                        }

                        }
                    }
                    is ResultWrapper.Error -> {
                        Toast.makeText(this, "code  " + it.code + "  error " + it.error, Toast.LENGTH_SHORT)
                            .show()
                    }
                    ResultWrapper.NetworkError -> {
                        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()

                    }
                }
            }
        })


    }

    override fun onItemSelected(position: Int, item: Child) {
        Toast.makeText(this,item.data.thumbnail,Toast.LENGTH_SHORT).show()
    }
}