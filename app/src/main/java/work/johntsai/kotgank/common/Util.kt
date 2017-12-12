package work.johntsai.kotgank.common

/**
 * Created by John on 2017/12/12.
 */

fun exectionTime(func:()->Any):Long{
    val start = System.currentTimeMillis()
    func()
    return System.currentTimeMillis() - start
}