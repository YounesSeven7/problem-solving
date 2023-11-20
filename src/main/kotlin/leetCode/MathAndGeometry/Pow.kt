package leetCode.MathAndGeometry

class Pow {
    fun myPow(x: Double, n: Int): Double {
        fun recursion(pow: Int): Double{
            if (pow == 0) return 1.0
            if (pow == 1) return x
            var value = recursion(pow / 2)
            value *= value
            return if (pow % 2 == 0) return value else value * x
        }
        return if (n >= 0) recursion(n) else (1 / recursion(n * -1))
    }
}