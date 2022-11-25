package aveek.kmm_flickr.androidapp.di

import aveek.kmm_flickr.api.HttpClientFactory
import aveek.kmm_flickr.api.ImageApi
import aveek.kmm_flickr.data.repository.ImageRepositoryImpl
import aveek.kmm_flickr.domain.repository.ImageRepository
import aveek.kmm_flickr.domain.use_cases.ImageUseCases
import aveek.kmm_flickr.domain.use_cases.download.DownloadImageUseCase
import aveek.kmm_flickr.domain.use_cases.image_fetch.GetImagesFromServerUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient {
        return HttpClientFactory().build()
    }

    @Provides
    @Singleton
    fun provideFetchImageApi(httpClient: HttpClient): ImageApi {
        return ImageApi(httpClient)
    }

    @Provides
    @Singleton
    fun provideFetchImageRepository( api : ImageApi ) : ImageRepository {
        return ImageRepositoryImpl(api)
    }


    @Provides
    @Singleton
    fun provideFetchImageUseCases(repository: ImageRepository) : ImageUseCases {
        return ImageUseCases(fetchImages = GetImagesFromServerUseCase(repository), downloadImages = DownloadImageUseCase(repository))
    }
}