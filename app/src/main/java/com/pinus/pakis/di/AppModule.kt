package com.pinus.pakis.di

import com.pakis.pinus.core.domain.repository.IMainRepository
import com.pakis.pinus.core.domain.usecase.MainAppInteractor
import com.pakis.pinus.core.domain.usecase.MainAppUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideUsecase(repository: IMainRepository) =
        MainAppInteractor(repository) as MainAppUseCase
}