package leetcode.top

fun main(args: Array<String>) {
    val listNode = ListNode(2)
    listNode.next = ListNode(4)
    listNode.next?.next = ListNode(3)


    val listNode2 = ListNode(5)
    listNode2.next = ListNode(6)
    listNode2.next?.next = ListNode(4)

    print(AddTwoNumbers().addTwoNumbers(listNode, listNode2))
}

class AddTwoNumbers {
    fun addTwoNumbers(listNode1: ListNode?, listNode2: ListNode?): ListNode? {
        fun valueFromSum(sum: Int): Int {
            return if (sum >= 10) sum - 10 else sum
        }

        fun carryOverFromSum(sum: Int): Int {
            return if (sum >= 10) 1 else 0
        }

        fun add(l1: ListNode?, l2: ListNode?, carryOver: Int, accumulator: ListNode?): ListNode? {
            if (l1?.`val` == null && l2?.`val` == null && carryOver == 0) return accumulator
            else if (l1?.`val` == null && l2?.`val` == null) {
                accumulator!!.next = ListNode(carryOver)
                return accumulator
            } else if (l1?.`val` == null) {
                val sum = l2!!.`val` + carryOver
                accumulator?.next = add(null, l2.next, carryOverFromSum(sum),
                    ListNode(valueFromSum(sum))
                )
                return accumulator
            } else if (l2?.`val` == null) {
                val sum = l1.`val` + carryOver
                accumulator?.next = add(null, l1.next, carryOverFromSum(sum),
                    ListNode(valueFromSum(sum))
                )
                return accumulator
            } else {
                val sum = l1.`val` + l2.`val` + carryOver
                accumulator!!.next = add(l1.next, l2.next, carryOverFromSum(sum),
                    ListNode(valueFromSum(sum))
                )
                return accumulator
            }

        }

        fun add(l1: ListNode?, l2: ListNode?): ListNode? {
            val sum = l1!!.`val` + l2!!.`val`
            return add(l1.next, l2.next, carryOverFromSum(sum),
                ListNode(valueFromSum(sum))
            )
        }

        return add(listNode1, listNode2)
    }
}

data class ListNode(var `val`: Int) {
    var next: ListNode? = null
}