package com.san.demo.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

fun <ResultType> networkOnlyResource(
    context: Context, fetch: suspend () -> ResultType
) = flow {
    if (!isNetworkConnected(context)) {
        emit(Resource.Error(Error("No Network")))
        return@flow
    }
    val flow = flow {
        try {
            emit(Resource.Success(fetch()))
        } catch (throwable: Throwable) {
            emit(Resource.Error(throwable))
        }
    }.onStart { emit(Resource.Loader(true)) }.onCompletion { emit(Resource.Loader(false)) }

    emitAll(flow)
}

fun <ResultType, RequestType> networkBoundResource(
    query: () -> Flow<ResultType>,
    fetch: suspend () -> RequestType,
    saveFetchResult: suspend (RequestType) -> Unit,
    shouldFetch: (ResultType?) -> Boolean = { true }
) = flow {
    val data = query().first()
    emit(BoundResource.Loading(true))
    val flow = if (shouldFetch(data)) {
        try {
            saveFetchResult(fetch())
            query().map { BoundResource.Success(it) }
        } catch (throwable: Throwable) {
            emit(BoundResource.Loading(false))
            query().map { BoundResource.Error(throwable, it) }
        }
    } else {
        query().map { BoundResource.Success(it) }
    }
    emit(BoundResource.Loading(false))
    emitAll(flow)
}.flowOn(Dispatchers.IO)

fun <ResultType> makeApiCall(
    fetch: suspend () -> ResultType
) = flow {
    val flow = flow {
        try {
            emit(Resource.Success(fetch()))
        } catch (throwable: Throwable) {
            emit(Resource.Error(throwable))
            throwable.localizedMessage?.let { Log.e("POKE", it) }
        }
    }.onStart { emit(Resource.Loader(true)) }.onCompletion { emit(Resource.Loader(false)) }
        .flowOn(Dispatchers.IO)

    emitAll(flow)
}

fun isNetworkConnected(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkCapabilities = connectivityManager.activeNetwork ?: return false
    val activeNetwork =
        connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
    val result = when {
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
        else -> false
    }
    return result
}


sealed class Resource<out T> {
    data class Success<out T>(val result: T) : Resource<T>()
    data class Error(val exception: Throwable) : Resource<Nothing>()
    data class Loader(val isLoading: Boolean) : Resource<Nothing>()
}

sealed class BoundResource<out T> {
    data class Success<out T>(val result: T) : BoundResource<T>()
    data class Error<out T>(val exception: Throwable, val result: T) : BoundResource<T>()
    data class Loading(val isLoading: Boolean) : BoundResource<Nothing>()
}


