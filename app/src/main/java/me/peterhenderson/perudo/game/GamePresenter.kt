package me.peterhenderson.perudo.game

import me.peterhenderson.perudo.core.DiceRoller
import javax.inject.Inject

class GamePresenter @Inject constructor(val rng: DiceRoller) {
    lateinit var view: GameView

    fun onCreate(view: GameView) {
        this.view = view
    }

    fun rollDiceTapped() {
        view.displayDice(rng.rollNd6(5))
    }
}