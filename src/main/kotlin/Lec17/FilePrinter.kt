package Lec17

import java.io.BufferedReader
import java.io.FileReader

class FilePrinter {

    fun readFile(path: String) {
        BufferedReader(FileReader(path)).use { reader ->
            println(reader.readLine())
        }
    }
}