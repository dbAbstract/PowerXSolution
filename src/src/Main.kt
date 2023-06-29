fun main() {
    val testCases = arrayOf(
        arrayOf(-13,0,4,2,19,13,0,0,2,2,1,6,7),
        emptyArray(),
        arrayOf(-13,0),
        arrayOf(-13,0,4,6),
        arrayOf(-1,0,1,2,3),
        arrayOf(5,5,5,5,5),
        arrayOf(4,2,8,5,3,9,1),
        arrayOf(-5,-3,-1,-19,-14),
        arrayOf(3,1,3,2,2)
    )
    testCases.forEach { testCase ->
        println("The third largest value for the list ${testCase.toList()} = \n\t${findThirdLargest(inputList = testCase)}")
    }
}

/**
 * 1. Method will return 0 for empty list.
 * 2. Method will return minimum number if the list has less than 3 elements.
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 *
 * @param inputList The input list provided of which the third-largest number is determined.
 */
fun findThirdLargest(inputList: Array<Int>): Int {
    var firstMax = Float.NEGATIVE_INFINITY
    var secondMax = Float.NEGATIVE_INFINITY
    var thirdMax = Float.NEGATIVE_INFINITY

    if (inputList.isEmpty()) return 0

    // If list has less than 3 elements, this method just returns the smallest
    // If list is exactly of size 3, return the minimum.
    if (inputList.size <= 3) return inputList.min()

    for (num in inputList) {
        if (num.toFloat() == firstMax || num.toFloat() == secondMax || num.toFloat() == thirdMax) continue
        when {
            firstMax == Float.NEGATIVE_INFINITY || num > firstMax -> {
                thirdMax = secondMax
                secondMax = firstMax
                firstMax = num.toFloat()
            }

            secondMax == Float.NEGATIVE_INFINITY || num > secondMax -> {
                thirdMax = secondMax
                secondMax = num.toFloat()
            }

            thirdMax == Float.NEGATIVE_INFINITY || num > thirdMax -> {
                thirdMax = num.toFloat()
            }
        }
    }
    // This conversion can only throw exception if the list has < 3 elements which cannot happen because of the check before loop.
    return thirdMax.let {
        if (it == Float.NEGATIVE_INFINITY) firstMax else it
    }.toInt()
}