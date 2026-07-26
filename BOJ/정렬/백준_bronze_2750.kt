import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val numbers = IntArray(n) { br.readLine().toInt() }

    numbers.sort()

    for (num in numbers) {
        bw.write("$num\n")
    }

    bw.flush()
    bw.close()
    br.close()
}