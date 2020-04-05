package com.home.mockkdemo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.home.mockkdemo.R
import com.home.mockkdemo.model.UserPojo
import com.home.mockkdemo.model.source.UserDataSource
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment(private val dataSource: UserDataSource? = null) : Fragment() {

    private var user: UserPojo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            bundle.getInt("id").let { id ->
                dataSource?.getUser(id)?.let { user ->
                    this.user = user
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        user?.let {
            text_view_name_content.text = it.name
            text_view_phone_content.text = it.phone
            text_view_address_content.text = it.address
        }
    }
}

















