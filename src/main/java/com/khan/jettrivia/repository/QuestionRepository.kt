package com.khan.jettrivia.repository

import android.util.Log
import com.khan.jettrivia.data.DataOrException
import com.khan.jettrivia.model.QuestionItem
import com.khan.jettrivia.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api:QuestionApi) {

    private val dataOrException = DataOrException<ArrayList<QuestionItem>,
            Boolean,
            Exception>()

    suspend fun getAllQuestion():DataOrException<ArrayList<QuestionItem>,Boolean,java.lang.Exception>
    {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestion()
            if (dataOrException.data.toString().isNotEmpty())
            {
                dataOrException.loading= false
            }
        }
        catch (exception:Exception){
            dataOrException.e = exception
            Log.d("EXCEPTION", "getAllQuestion: {${dataOrException.e!!.localizedMessage}}")

        }
        return dataOrException
    }
}