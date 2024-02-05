package com.khan.jettrivia.data


// This is a wrapper class to the question repository
data class DataOrException<T,Boolean, E:Exception>(
    var data:T? = null,
    var loading:Boolean?=null,
    var e:E?=null
)
