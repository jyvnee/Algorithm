fun main(){
    val (T, W) = readLine()!!.split(" ").map {it.toInt()}
    val drops = IntArray(T + 1)

    for (i in 1..T){
        drops[i] = readLine()!!.toInt()
    }

    val dp = Array(T+1) {IntArray(W+1)}

    for (i in 1..T){
        for(j in 0..W){
            val currentTree = if(j%2==0) 1 else 2
            val fruit = if (drops[i] == currentTree) 1 else 0

            if(j==0){
                dp[i][j] = dp[i-1][j] + fruit
            }else{
                dp[i][j] = maxOf(dp[i-1][j], dp[i-1][j-1]) + fruit
            }
        }
    }
    println(dp[T].maxOrNull())
}