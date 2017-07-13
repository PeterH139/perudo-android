package me.peterhenderson.perudo.game

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import me.peterhenderson.perudo.core.DiceRoller
import org.junit.Test

class GamePresenterTest {
    lateinit var view: GameView
    lateinit var rng: DiceRoller
    lateinit var presenter: GamePresenter

    @Test
    fun `display new dice on roll dice tapped`() {
        view = mock<GameView>()
        rng = mock<DiceRoller> {
            on { rollNd6(5) } doReturn listOf(1, 2, 3, 4, 5)
        }
        presenter = GamePresenter(rng)

        presenter.onCreate(view)
        presenter.rollDiceTapped()

        verify(view).displayDice(listOf(1, 2, 3, 4, 5))
    }
}