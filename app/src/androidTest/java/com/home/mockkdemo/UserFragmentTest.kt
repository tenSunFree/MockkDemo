package com.home.mockkdemo

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.home.mockkdemo.model.UserPojo
import com.home.mockkdemo.model.source.UserRemoteDataSource
import com.home.mockkdemo.view.MainFragmentFactory
import com.home.mockkdemo.view.UserFragment
import io.mockk.every
import io.mockk.mockk
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class UserFragmentTest {

    @Test
    fun test_user_sun() {
        Thread.sleep(1000)
        val id = 0
        val name = "Sun"
        val phone = "0986***441"
        val address = "新北市板橋區四川路二段245巷"
        val user = UserPojo(id, name, phone, address)
        val moviesDataSource = mockk<UserRemoteDataSource>()
        every {
            moviesDataSource.getUser(id)
        } returns user
        val fragmentFactory = MainFragmentFactory(moviesDataSource)
        val bundle = Bundle()
        bundle.putInt("id", id)
        launchFragmentInContainer<UserFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )
        Thread.sleep(1000)
        onView(withId(R.id.text_view_name_content)).check(matches(withText(name)))
        Thread.sleep(1000)
        onView(withId(R.id.text_view_phone_content)).check(matches(withText(phone)))
        Thread.sleep(1000)
        onView(withId(R.id.text_view_address_content)).check(matches(withText(address)))
        Thread.sleep(1000)
    }

    @Test
    fun test_user_faker() {
        Thread.sleep(1000)
        val id = 1
        val name = "Faker"
        val phone = "0983***513"
        val address = "台北市大安區四維路14巷"
        val user = UserPojo(id, name, phone, address)
        val moviesDataSource = mockk<UserRemoteDataSource>()
        every {
            moviesDataSource.getUser(id)
        } returns user
        val fragmentFactory = MainFragmentFactory(moviesDataSource)
        val bundle = Bundle()
        bundle.putInt("id", id)
        launchFragmentInContainer<UserFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )
        Thread.sleep(1000)
        onView(withId(R.id.text_view_name_content)).check(matches(withText(name)))
        Thread.sleep(1000)
        onView(withId(R.id.text_view_phone_content)).check(matches(withText(phone)))
        Thread.sleep(1000)
        onView(withId(R.id.text_view_address_content)).check(matches(withText(address)))
        Thread.sleep(1000)
    }

    @Test
    fun test_user_toyz() {
        Thread.sleep(1000)
        val id = 1
        val name = "Toyz"
        val phone = "0996***217"
        val address = "台北市信義區忠孝東路五段"
        val user = UserPojo(id, name, phone, address)
        val moviesDataSource = mockk<UserRemoteDataSource>()
        every {
            moviesDataSource.getUser(id)
        } returns user
        val fragmentFactory = MainFragmentFactory(moviesDataSource)
        val bundle = Bundle()
        bundle.putInt("id", id)
        launchFragmentInContainer<UserFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )
        Thread.sleep(1000)
        onView(withId(R.id.text_view_name_content)).check(matches(withText(name)))
        Thread.sleep(1000)
        onView(withId(R.id.text_view_phone_content)).check(matches(withText(phone)))
        Thread.sleep(1000)
        onView(withId(R.id.text_view_address_content)).check(matches(withText(address)))
        Thread.sleep(1000)
    }
}