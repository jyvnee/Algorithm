fun main(){
    val N = readLine()!!.toInt()
    val mod = 10007

    val dp = Array(N+1) {IntArray(10)}

    for (i in 0..9){
        dp[1][i] = 1
    }

    for (i in 2..N){
        for (j in 0..9){
            for (k in j..9){
                dp[i][j] = (dp[i][j] + dp[i-1][k]) % mod
            }
        }
    }

    var result = 0
    for (i in 0..9){
        result = (result + dp[N][i]) % mod
    }

    println(result)
}