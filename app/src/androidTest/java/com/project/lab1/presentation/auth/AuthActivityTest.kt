package com.project.lab1.presentation.auth

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.project.lab1.R
import com.project.lab1.presentation.APIClient
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.GlobalContext.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import org.mockito.kotlin.UseConstructor
import org.mockito.kotlin.mock

@RunWith(AndroidJUnit4::class)
class AuthActivityTest: TestCase() {
    lateinit var mockModule: Module

    @Before
    fun setup() {
        mockModule = module(override = true) {
            single<AuthOutput>(override = true) { (view: AuthInput) ->
                mock<AuthPresenter>(useConstructor = UseConstructor.withArguments(view, get<APIClient>()))
            }
            single<APIClient> { mock() }
        }

        loadKoinModules(mockModule)
    }


    @get:Rule
    val activityRule = ActivityScenarioRule(AuthActivity::class.java)


    @Test
    fun test_validateEditText() {
        onView(withId(R.id.userLogin)).perform(typeText("test-string")).check(matches(withText("test-string")))
    }
}
