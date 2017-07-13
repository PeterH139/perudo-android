package me.peterhenderson.perudo.dagger

import android.app.Application
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector
import me.peterhenderson.perudo.PerudoApplication
import me.peterhenderson.perudo.home.HomeActivity


@Module
abstract class ApplicationModule(private val app: Application) {
    @ContributesAndroidInjector abstract fun contributeHomeActivityInjector(): HomeActivity
}

@Component(modules = arrayOf(AndroidInjectionModule::class, ApplicationModule::class))
interface ApplicationComponent {
    fun inject(app: PerudoApplication)
}