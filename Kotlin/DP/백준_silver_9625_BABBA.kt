fun main(){
    val k = readLine()!!.toInt()

    var a = 1
    var b = 0

    for (i in 1..k){
        val newA = b
        val newB = a + b

        a = newA
        b = newB
    }

    println("$a $b")
}