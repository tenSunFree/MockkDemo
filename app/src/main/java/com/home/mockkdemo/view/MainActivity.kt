package com.home.mockkdemo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.home.mockkdemo.R
import com.home.mockkdemo.model.source.UserDataSource
import com.home.mockkdemo.model.source.UserRemoteDataSource

class MainActivity : AppCompatActivity() {

    var dataSource: UserDataSource? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        initDependencies()
        supportFragmentManager.fragmentFactory =
            MainFragmentFactory(
                dataSource = dataSource
            )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        if (supportFragmentManager.fragments.size == 0) {
            val random = (Math.random() * 3).toInt()
            val bundle = Bundle()
            bundle.putInt("id", random)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, UserFragment::class.java, bundle)
                .commit()
        }
    }

    private fun initDependencies() {
        if (dataSource == null) {
            dataSource = UserRemoteDataSource()
        }
    }
}