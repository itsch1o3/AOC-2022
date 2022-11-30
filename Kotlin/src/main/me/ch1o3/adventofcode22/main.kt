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
        return ("Solution for Part A: ${solvePartA(lines)}" + "\n" + "Solution for Part B: ${solvePartB(lines)}");
    }
    fun solvePartA(lines: List<String>): String
    {
        return "[not yet completed]"
    }
    fun solvePartB(lines: List<String>): String {
        return "[not yet completed]"
    }
}