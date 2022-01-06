package com.example.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.moviecatalogue.R
import com.example.moviecatalogue.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest() {

    private val dummyVideoMovie = DataDummy.generateDummyMovie()
    private val dummyVideoTvShow = DataDummy.generateDummyTvShow()


    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadVideoMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyVideoMovie.size
            )
        )
    }
    @Test
    fun loadVideoTvShow() {
        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyVideoTvShow.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_detail)).check(matches(withText(dummyVideoMovie[0].title)))
        onView(withId(R.id.img_poster_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.img_poster_detail)).check(matches(withContentDescription(R.string.contentDescriptionImage)))
        onView(withId(R.id.rating_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.rating_detail)).check(matches(withContentDescription(R.string.contentDescriptionRating)))
        onView(withId(R.id.tv_gendre_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_gendre_detail)).check(matches(withText(dummyVideoMovie[0].gendre)))
        onView(withId(R.id.tv_year_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_year_detail)).check(matches(withText(dummyVideoMovie[0].year)))
        onView(withId(R.id.tv_duration_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration_detail)).check(matches(withText(dummyVideoMovie[0].duration)))
        onView(withId(R.id.tv_desc_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_desc_detail)).check(matches(withText(dummyVideoMovie[0].description)))

    }


    @Test
    fun loadDetailTvShow(){
        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            click()))
        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_detail)).check(matches(withText(dummyVideoTvShow[0].title)))
        onView(withId(R.id.img_poster_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.img_poster_detail)).check(matches(withContentDescription(R.string.contentDescriptionImage)))
        onView(withId(R.id.rating_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.rating_detail)).check(matches(withContentDescription(R.string.contentDescriptionRating)))
        onView(withId(R.id.tv_gendre_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_gendre_detail)).check(matches(withText(dummyVideoTvShow[0].gendre)))
        onView(withId(R.id.tv_year_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_year_detail)).check(matches(withText(dummyVideoTvShow[0].year)))
        onView(withId(R.id.tv_duration_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration_detail)).check(matches(withText(dummyVideoTvShow[0].duration)))
        onView(withId(R.id.tv_desc_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_desc_detail)).check(matches(withText(dummyVideoTvShow[0].description)))

    }
}