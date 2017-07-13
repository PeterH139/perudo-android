package me.peterhenderson.perudo.game

import android.app.Application
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class GameModule(private val app: Application) {
    @ContributesAndroidInjector abstract fun contributeGameActivityInjector(): GameActivity
}