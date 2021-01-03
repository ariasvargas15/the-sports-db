package com.brayanarias.thesportsdb.framework.utils

import com.brayanarias.thesportsdb.data.source.ApiKeyDataSource

class ApiKeyDataSource constructor(private val apiKey: String) : ApiKeyDataSource {
    override fun getApiKey(): String {
       return apiKey
    }
}