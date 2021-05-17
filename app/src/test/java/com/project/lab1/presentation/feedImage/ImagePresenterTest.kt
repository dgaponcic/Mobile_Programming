package com.project.lab1.presentation.feedImage

import com.project.lab1.network.models.AuthToken
import com.project.lab1.network.models.Image
import com.project.lab1.network.models.URLS
import com.project.lab1.network.models.User
import com.project.lab1.presentation.APIClient
import com.project.lab1.presentation.feedImage.models.FeedImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.*


@ExperimentalCoroutinesApi
class ImagePresenterTests {
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
    fun getImage_onSuccess_shouldUpdateUI() = runBlockingTest {
        val imageInputMock = mock<ImageInput>()
        val apiServiceMock = mock<APIClient>()
        val presenter = ImagePresenter(imageInputMock, apiServiceMock)

        val tokenStub = mock<AuthToken>()
        whenever(tokenStub.access_token).thenReturn(("some-auth-token"))

        val link = "test-link"

        val urlsStub = mock<URLS>()
        whenever(urlsStub.small).thenReturn("test-url")

        val userStub = mock<User>()
        whenever(userStub.username).thenReturn("test-username")

        val imageStub = mock<Image>()
        whenever(imageStub.id).thenReturn(("test-id"))
        whenever(imageStub.alt_description).thenReturn(("test-description"))
        whenever(imageStub.urls).thenReturn(urlsStub)
        whenever(imageStub.user).thenReturn(userStub)

        val image = FeedImage(imageStub.id, imageStub.alt_description, imageStub.urls.small, imageStub.user.username)
        whenever(apiServiceMock.getImage(tokenStub.access_token, link)).thenReturn(imageStub)

        presenter.getImage(tokenStub.access_token, link)

        verify(apiServiceMock).getImage(tokenStub.access_token, link)
        verify(imageInputMock).updateUI(image)
    }


    @Test
    fun getImage_onDataFetchError_shouldNotUpdateUI() = runBlockingTest {
        val imageInputMock = mock<ImageInput>()
        val apiServiceMock = mock<APIClient>()
        val presenter = ImagePresenter(imageInputMock, apiServiceMock)

        val tokenStub = mock<AuthToken>()
        whenever(tokenStub.access_token).thenReturn(("some-auth-token"))

        val link = "test-link"

        val errorMessage = "Network Error"
        val error = Error(errorMessage)
        whenever(apiServiceMock.getImage(tokenStub.access_token, link)).thenThrow(error)

        presenter.getImage(tokenStub.access_token, link)

        verify(apiServiceMock).getImage(tokenStub.access_token, link)
        verify(imageInputMock, never()).updateUI(anyVararg())
        verify(imageInputMock).showErrorAlert("An error occurred.")
    }


    @Test
    fun addNote_onSuccess_shouldShowNoteAdded() = runBlockingTest {
        val imageInputMock = mock<ImageInput>()
        val apiServiceMock = mock<APIClient>()
        val presenter = ImagePresenter(imageInputMock, apiServiceMock)

        val tokenStub = mock<AuthToken>()
        whenever(tokenStub.access_token).thenReturn(("some-auth-token"))

        val link = "test-link"

        presenter.addNote(tokenStub.access_token, link)

        verify(apiServiceMock).addNote(tokenStub.access_token, link)
        verify(imageInputMock).showNoteAdded()
    }


    @Test
    fun addNote_onError_shouldShowError() = runBlockingTest {
        val imageInputMock = mock<ImageInput>()
        val apiServiceMock = mock<APIClient>()
        val presenter = ImagePresenter(imageInputMock, apiServiceMock)

        val tokenStub = mock<AuthToken>()
        whenever(tokenStub.access_token).thenReturn(("some-auth-token"))

        val link = "test-link"

        val errorMessage = "Network Error"
        val error = Error(errorMessage)
        whenever(apiServiceMock.addNote(tokenStub.access_token, link)).thenThrow(error)

        presenter.addNote(tokenStub.access_token, link)

        verify(apiServiceMock).addNote(tokenStub.access_token, link)
        verify(imageInputMock, never()).showNoteAdded()
        verify(imageInputMock).showErrorAlert("An error occurred.")
    }
}
