package me.ch1o3.adventofcode22.days

import me.ch1o3.adventofcode22.DaySolver
import me.ch1o3.adventofcode22.sharedMain

class Day2() : DaySolver {
    override val n: Int = 2

    enum class Choice(val score: Int) {
        ROCK(1), PAPER(2), SCISSORS(3), UNKNOWN(0);

        companion object {
            fun fromLetter(letter: String): Choice {
                return when (letter) {
                    "A", "X" -> ROCK
                    "B", "Y" -> PAPER
                    "C", "Z" -> SCISSORS
                    else -> UNKNOWN
                }
            }

            fun getChoiceToForceResult(theirChoice: Choice, desiredResult: MatchResult): Choice {
                return when (desiredResult) {
                    MatchResult.WIN -> when (theirChoice) {
                        ROCK -> PAPER
                        PAPER -> SCISSORS
                        SCISSORS -> ROCK
                        else -> UNKNOWN
                    }
                    MatchResult.DRAW -> theirChoice
                    MatchResult.LOSE -> when (theirChoice) {
                        SCISSORS -> PAPER
                        ROCK -> SCISSORS
                        PAPER -> ROCK
                        else -> UNKNOWN
                    }
                    else -> UNKNOWN
                }
            }
        }
    }

    fun calculateScoreForRound(myChoice: Choice, theirChoice: Choice): Int {
        return myChoice.score + MatchResult.calculate(myChoice, theirChoice).score
    }

    enum class MatchResult(val score: Int) {
        WIN(6), DRAW(3), LOSE(0), UNKNOWN(0);

        companion object {
            fun calculate(myChoice: Choice, theirChoice: Choice): MatchResult {
                return if (myChoice == theirChoice) {
                    DRAW
                } else if (myChoice == Choice.SCISSORS && theirChoice == Choice.PAPER) {
                    WIN
                } else if (myChoice == Choice.PAPER && theirChoice == Choice.ROCK) {
                    WIN
                } else if (myChoice == Choice.ROCK && theirChoice == Choice.SCISSORS) {
                    WIN
                } else {
                    LOSE
                }
            }

            fun fromLetter(letter: String): MatchResult {
                return when (letter) {
                    "X" -> LOSE
                    "Y" -> DRAW
                    "Z" -> WIN
                    else -> UNKNOWN
                }
            }
        }

    }

    override fun solvePartA(lines: List<String>): String {
        var totalScore = 0
        for (line in lines) {
            val choices = line.split(" ")
            val theirChoice = Choice.fromLetter(choices[0].trim())
            val ourChoice = Choice.fromLetter(choices[1].trim())
            totalScore += calculateScoreForRound(
                ourChoice, theirChoice
            )
        }
        return totalScore.toString()
    }

    override fun solvePartB(lines: List<String>): String {
        var totalScore = 0
        for (line in lines) {
            val choices = line.split(" ")
            val theirChoice = Choice.fromLetter(choices[0].trim())
            val desiredResult = MatchResult.fromLetter(choices[1].trim())
            val ourChoice = Choice.getChoiceToForceResult(theirChoice,desiredResult)
            totalScore += calculateScoreForRound(ourChoice,theirChoice)
        }
        return totalScore.toString()
    }
}

fun main(args: Array<String>) {
    sharedMain(args, Day2())
}