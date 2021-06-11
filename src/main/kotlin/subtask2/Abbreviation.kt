package subtask2

import java.lang.StringBuilder

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        //throw NotImplementedError("Not implemented")
        val patterForRegex = StringBuilder(".*")
        b.forEach { patterForRegex.append("[$it${it.toLowerCase()}].*") }
        val regex = Regex(patterForRegex.toString())
        return if (a.contains(regex)) {
            "YES"
        } else {
            "NO"
        }
    }
}
