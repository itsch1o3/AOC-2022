package me.ch1o3.adventofcode22
import java.io.InputStream
import java.nio.file.Path

class AOCFileInput(filePath: Path){
    constructor(filePath: String): this(Path.of(filePath))
    val _inputStream: InputStream = filePath.toFile().inputStream()
    val raw_text : String = String(_inputStream.readAllBytes())

    fun get_lines() : List<String>{
        return raw_text.split("\n")
    }
}

interface DaySolver {
    val n: Int
    fun solve(lines: List<String>): String {
        return ("Solution for Part A: ${solvePartA(lines)}" + "\n" + "Solution for Part B: ${solvePartB(lines)}")
    }
    fun solvePartA(lines: List<String>): String
    {
        return "[not yet completed]"
    }
    fun solvePartB(lines: List<String>): String {
        return "[not yet completed]"
    }
}

fun sharedMain(args: Array<String>, solver : DaySolver){
        if(args.isNotEmpty()) {
            print(solver.solve(AOCFileInput(args[0]).get_lines()))
        } else {
            val defaultDir : String? = System.getenv("AOC_INPUT_DIRECTORY")
            if(defaultDir != null) {
                print(solver.solve(AOCFileInput("$defaultDir/Day${solver.n}.txt").get_lines()))
            } else {
                error("You must provide either a file path to the relevant input, or an AOC_INPUT_DIRECTORY environment variable.")
            }
        }
}