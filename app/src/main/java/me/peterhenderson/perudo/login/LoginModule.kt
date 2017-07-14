package me.peterhenderson.perudo.login

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginModule {
    @ContributesAndroidInjector abstract fun contributeGameActivityInjector(): LoginActivity
}