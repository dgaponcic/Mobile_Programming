package com.project.lab1.presentation.auth

import com.project.lab1.network.models.AuthToken
import com.project.lab1.presentation.APIClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


@ExperimentalCoroutinesApi
class AuthPresenterTests {
    val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun auth_onSuccess_shouldUpdateUI() = runBlockingTest {
        val authInputMock = mock<AuthInput>()
        val apiServiceMock = mock<APIClient>()
        val presenter = AuthPresenter(authInputMock, apiServiceMock)

        val tokenStub = mock<AuthToken>()
        val username = "username"
        val password = "password"

        whenever(tokenStub.access_token).thenReturn(("some-auth-token"))
        whenever(apiServiceMock.auth(username, password)).thenReturn(tokenStub)

        presenter.auth(username, password)

        verify(apiServiceMock).auth(username, password)
        verify(authInputMock).updateUI(tokenStub.access_token)
    }


    @Test
    fun auth_onEmptyToken_shouldNotUpdateUI() = runBlockingTest {
        val authInputMock = mock<AuthInput>()
        val apiServiceMock = mock<APIClient>()
        val presenter = AuthPresenter(authInputMock, apiServiceMock)

        val tokenStub = mock<AuthToken>()
        val username = "username"
        val password = "password"
        whenever(tokenStub.access_token).thenReturn((""))
        whenever(apiServiceMock.auth(username, password)).thenReturn(tokenStub)

        presenter.auth(username, password)

        verify(apiServiceMock).auth(username, password)
        verify(authInputMock, never()).updateUI(tokenStub.access_token)
    }

    @Test
    fun auth_onError_shouldNotUpdateUI() = runBlockingTest {
        val authInputMock = mock<AuthInput>()
        val apiServiceMock = mock<APIClient>()
        val presenter = AuthPresenter(authInputMock, apiServiceMock)

        val tokenStub = mock<AuthToken>()
        val username = "username"
        val password = "password"

        val errorMessage = "Network Error"
        val error = Error(errorMessage)
        whenever(apiServiceMock.auth(username, password)).thenThrow(error)

        presenter.auth(username, password)

        verify(apiServiceMock).auth(username, password)
        verify(authInputMock, never()).updateUI(tokenStub.access_token)
        verify(authInputMock).showErrorAlert("An error occurred.")
    }
}
