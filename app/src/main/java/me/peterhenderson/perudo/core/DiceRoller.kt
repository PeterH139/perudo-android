package me.peterhenderson.perudo.core

interface DiceRoller {
    fun rollNd6(n: Int): List<Int>
}

class PseudoRandomDiceRoller : DiceRoller {
    override fun rollNd6(n: Int): List<Int> {
        return listOf((1..n)).flatten().map { rollD6() }
    }

    private fun rollD6(): Int {
        return (Math.floor(Math.random() * 6) + 1).toInt()
    }
}