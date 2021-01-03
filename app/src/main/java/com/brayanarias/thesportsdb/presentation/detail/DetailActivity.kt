package com.brayanarias.thesportsdb.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brayanarias.thesportsdb.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    companion object {
        const val TEAM = "DetailActivity:team"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}