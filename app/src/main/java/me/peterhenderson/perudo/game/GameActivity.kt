package me.peterhenderson.perudo.game

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game.*
import me.peterhenderson.perudo.R
import me.peterhenderson.perudo.core.BaseActivity
import me.peterhenderson.perudo.core.ContentView
import javax.inject.Inject

interface GameView {
    fun displayDice(diceRolls: List<Int>)
}

@ContentView(R.layout.activity_game)
class GameActivity : BaseActivity(), GameView {

    @Inject lateinit var presenter: GamePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onCreate(this)
        roll_dice.setOnClickListener { presenter.rollDiceTapped() }
    }
    override fun displayDice(diceRolls: List<Int>) {
        dice_one_label.text = diceRolls[0].toString()
        dice_two_label.text = diceRolls[1].toString()
        dice_three_label.text = diceRolls[2].toString()
        dice_four_label.text = diceRolls[3].toString()
        dice_five_label.text = diceRolls[4].toString()
    }
}

