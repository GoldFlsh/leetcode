package leetcode.top

import java.lang.NumberFormatException

fun main() {
    ReverseInteger().reverseWithString(123).print()
    ReverseInteger().reverseWithString(120).print()
    ReverseInteger().reverseWithString(-321).print()
    ReverseInteger().reverseWithString(1534236469).print()
}

class ReverseInteger {

    fun reverseWithString(x: Int): Int =
        try {
            when (x < 0) {
                true -> (x * -1).toString().reversed().toInt() * -1
                else -> x.toString().reversed().toInt()
            }
        } catch (e : NumberFormatException) {
            0
        }
}

private fun Int.print() {
    println(this)
}