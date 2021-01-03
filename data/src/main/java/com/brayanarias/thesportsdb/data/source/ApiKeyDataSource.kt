package com.brayanarias.thesportsdb.data.source

@FunctionalInterface
interface ApiKeyDataSource {
    fun getApiKey(): String
}