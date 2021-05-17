package com.project.lab1.presentation.feed

import com.project.lab1.network.models.AuthToken
import com.project.lab1.network.models.Image
import com.project.lab1.network.models.URLS
import com.project.lab1.presentation.APIClient
import com.project.lab1.presentation.feed.models.FeedItem
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
class FeedPresenterTests {
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
    fun getImages_onSuccess_shouldUpdateUI() = runBlockingTest {
        val feedInputMock = mock<FeedInput>()
        val apiServiceMock = mock<APIClient>()
        val presenter = FeedPresenter(feedInputMock, apiServiceMock)

        val tokenStub = mock<AuthToken>()
        whenever(tokenStub.access_token).thenReturn(("some-auth-token"))

        val linksStub = mock<URLS>()
        whenever(linksStub.small).thenReturn("http://test.com")

        val imageStub = mock<Image>()
        whenever(imageStub.id).thenReturn("test-id")
        whenever(imageStub.alt_description).thenReturn("test-description")
        whenever(imageStub.urls).thenReturn(linksStub)

        val fetchDataStub = arrayListOf(imageStub)
        whenever(apiServiceMock.getPastImages(tokenStub.access_token)).thenReturn(fetchDataStub)

        val expectedDataSet = fetchDataStub.map { FeedItem(
                imageStub.id,
                imageStub.alt_description,
                imageStub.urls.small)
        }.toTypedArray()

        presenter.getPastImages(tokenStub.access_token)

        verify(apiServiceMock).getPastImages(tokenStub.access_token)
        verify(feedInputMock).updateUI(expectedDataSet)
    }


    @Test
    fun getImages_onDataFetchError_shouldNotUpdateUI() = runBlockingTest {
        val feedInputMock = mock<FeedInput>()
        val apiServiceMock = mock<APIClient>()
        val presenter = FeedPresenter(feedInputMock, apiServiceMock)

        val tokenStub = mock<AuthToken>()
        whenever(tokenStub.access_token).thenReturn(("some-auth-token"))

        val errorMessage = "Network Error"
        val error = Error(errorMessage)
        whenever(apiServiceMock.getPastImages(tokenStub.access_token)).thenThrow(error)

        presenter.getPastImages(tokenStub.access_token)

        verify(apiServiceMock).getPastImages(tokenStub.access_token)
        verify(feedInputMock, never()).updateUI(anyVararg())
        verify(feedInputMock).showErrorAlert("An error occurred.")
    }
}
