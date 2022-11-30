package me.ch1o3.adventofcode22.days

import me.ch1o3.adventofcode22.AOCFileInput
import me.ch1o3.adventofcode22.DaySolver

class DayTemplate() : DaySolver {
    override val n: Int = 0
}

fun main(args: Array<String>){
    val solver : DaySolver = DayTemplate();
    if(args.isNotEmpty()) {
        print(solver.solve(AOCFileInput(args[0]).get_lines()));
    } else {
        val defaultDir : String? = System.getenv("AOC_INPUT_DIRECTORY")
        if(defaultDir != null) {
            print(solver.solve(AOCFileInput("$defaultDir/Day${solver.n}.txt").get_lines()));
        } else {
            error("You must provide either a file path to the relevant input, or an AOC_INPUT_DIRECTORY environment variable.")
        }
    }
}