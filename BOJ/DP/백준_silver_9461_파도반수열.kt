fun main(){
    val T = readLine()!!.toInt()
    val maxN = 100

    val P = LongArray(maxN + 1)

    P[1] = 1
    P[2] = 1
    P[3] = 1

    for (i in 3..maxN){
        P[i] = P[i-2] + P[i-3]
    }

    repeat(T){
        val N = readLine()!!.toInt()
        println(P[N])
    }
}