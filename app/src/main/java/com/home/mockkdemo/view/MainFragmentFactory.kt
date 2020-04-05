package com.home.mockkdemo.view

import androidx.fragment.app.FragmentFactory
import com.home.mockkdemo.model.source.UserDataSource

class MainFragmentFactory(
    private val dataSource: UserDataSource? = null
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String) =
        when (className) {
            UserFragment::class.java.name -> {
                if (dataSource != null) {
                    UserFragment(dataSource)
                } else {
                    super.instantiate(classLoader, className)
                }
            }
            else -> {
                super.instantiate(classLoader, className)
            }
        }
}