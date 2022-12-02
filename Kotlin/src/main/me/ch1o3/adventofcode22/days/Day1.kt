package me.ch1o3.adventofcode22.days

import me.ch1o3.adventofcode22.DaySolver
import me.ch1o3.adventofcode22.sharedMain

class Day1() : DaySolver {
    override val n: Int = 1

    fun calculateCaloriesPerElf(input: List<String>) : List<Int>{
        var currentCalorieTally = 0
        var result : List<Int> = emptyList()
        for(line in input) {
            if (line.isBlank()) {
                result = result.plus(currentCalorieTally)
                currentCalorieTally = 0
            } else {
                currentCalorieTally += line.trim().toInt()
            }
        }
        return result.plus(currentCalorieTally)
    }

    override fun solvePartA(lines: List<String>): String {
        return calculateCaloriesPerElf(lines).maxOrNull().toString()
    }

    override fun solvePartB(lines: List<String>): String {
        return calculateCaloriesPerElf(lines).sortedDescending().subList(0,3).sum().toString()
    }
}

fun main(args: Array<String>){
    sharedMain(args, Day1())
}
