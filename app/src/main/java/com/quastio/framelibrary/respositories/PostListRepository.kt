package com.quastio.framelibrary.respositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.quastio.framelibrary.models.Child
import com.quastio.framelibrary.models.RedditResponse
import com.quastio.framelibrary.models.ResultWrapper
import com.quastio.framelibrary.restclient.RestClient
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import retrofit2.HttpException
import java.io.IOException

object PostListRepository {
    var job:CompletableJob?=null

    fun<T> getPostList():MutableLiveData<ResultWrapper<List<Child>>>{
        job= Job()
        return object :MutableLiveData<ResultWrapper<List<Child>>>(){
            override fun onActive() {
                super.onActive()
                job?.let {
                    CoroutineScope(IO + it).launch {
                        try {
                            val data = RestClient.apiService.getJson()
                            if (data != null && data.data != null && data.data.children != null && data.data.children.isNotEmpty()) {
                                withContext(Main){
                                    value=ResultWrapper.Success(data.data.children)
                                    it.complete()
                                }
                            } else {
                                withContext(Main) {
                                    value = ResultWrapper.NetworkError
                                    it.complete()
                                }
                            }
                        }catch (throwable:Throwable){
                            when(throwable){
                                is IOException ->{
                                    withContext(Main) {
                                        value = ResultWrapper.NetworkError
                                        it.complete()
                                    }

                                }
                                is HttpException ->{
                                    withContext(Main) {
                                        value = ResultWrapper.Error(
                                            throwable.code(),
                                            throwable.message()
                                        )
                                        it.complete()
                                    }
                                }
                                else->{
                                    withContext(Main) {
                                        value = ResultWrapper.NetworkError
                                        it.complete()
                                    }

                                }
                            }

                        }
                    }
                }
                }
            }
        }

    }

