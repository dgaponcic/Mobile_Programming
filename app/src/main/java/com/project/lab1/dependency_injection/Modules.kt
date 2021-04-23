package com.project.lab1.dependency_injection

import com.project.lab1.presentation.APIClient
import com.project.lab1.network.APICommunication
import com.project.lab1.presentation.auth.AuthInput
import com.project.lab1.presentation.auth.AuthOutput
import com.project.lab1.presentation.auth.AuthPresenter
import com.project.lab1.presentation.feed.FeedInput
import com.project.lab1.presentation.feed.FeedOutput
import com.project.lab1.presentation.feed.FeedPresenter
import com.project.lab1.presentation.feedImage.ImageInput
import com.project.lab1.presentation.feedImage.ImageOutput
import com.project.lab1.presentation.feedImage.ImagePresenter
import com.project.lab1.presentation.notes.NotesInput
import com.project.lab1.presentation.notes.NotesOutput
import com.project.lab1.presentation.notes.NotesPresenter
import org.koin.dsl.module

val appModule = module {
    single<APIClient> { APICommunication() }
    single<FeedOutput> { (view: FeedInput) -> FeedPresenter(view, get()) }
    single<AuthOutput> { (view: AuthInput) -> AuthPresenter(view, get()) }
    single<ImageOutput> { (view: ImageInput) -> ImagePresenter(view, get()) }
    single<NotesOutput> { (view: NotesInput) -> NotesPresenter(view, get()) }
}
