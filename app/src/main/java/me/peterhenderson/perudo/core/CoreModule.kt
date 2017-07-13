@file:Suppress("unused")

package me.peterhenderson.perudo.core

import dagger.Module
import dagger.Provides

@Module
class CoreModule {
    @Provides
    fun providesRandomNumberGenerator() : DiceRoller = PseudoRandomDiceRoller()
}