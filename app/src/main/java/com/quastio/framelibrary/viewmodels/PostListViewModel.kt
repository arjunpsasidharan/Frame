package com.quastio.framelibrary.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quastio.framelibrary.models.Child
import com.quastio.framelibrary.models.ResultWrapper
import com.quastio.framelibrary.respositories.PostListRepository

class PostListViewModel:ViewModel() {
    private var _postData: MutableLiveData<ResultWrapper<List<Child>>>?=null

    init {
        _postData=PostListRepository.getPostList<Child>()

    }

    fun getPosts(): LiveData<ResultWrapper<List<Child>>> {
        return if (_postData!=null){
            _postData as LiveData<ResultWrapper<List<Child>>>
        }else{
            _postData=PostListRepository.getPostList<Child>()
            _postData as LiveData<ResultWrapper<List<Child>>>
        }
    }
}