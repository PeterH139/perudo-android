package me.peterhenderson.perudo.dagger

import android.app.Application
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import me.peterhenderson.perudo.PerudoApplication
import me.peterhenderson.perudo.core.CoreModule
import me.peterhenderson.perudo.game.GameModule


@Suppress("unused")
@Module(includes = arrayOf(
        CoreModule::class,
        GameModule::class
))
abstract class ApplicationModule(private val app: Application)

@Component(modules = arrayOf(
        ApplicationModule::class,
        AndroidInjectionModule::class
))
interface ApplicationComponent {
    fun inject(app: PerudoApplication)
}