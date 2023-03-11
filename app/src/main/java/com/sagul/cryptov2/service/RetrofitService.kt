package com.sagul.cryptov2.service

import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {
    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
   suspend fun getValues() : Response<ArrayList<CryptoModel>>
}