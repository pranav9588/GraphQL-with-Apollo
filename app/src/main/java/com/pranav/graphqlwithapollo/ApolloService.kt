package com.pranav.graphqlwithapollo

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.network.okHttpClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

interface ApolloService {
    companion object {
        fun setUpApolloClient(): ApolloClient {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val okHttp = OkHttpClient
                .Builder()
                .addInterceptor(logging)
            return ApolloClient.Builder()
                .serverUrl("https://countries.trevorblades.com")
                .okHttpClient(okHttp.build())
                .build()
        }
    }
}