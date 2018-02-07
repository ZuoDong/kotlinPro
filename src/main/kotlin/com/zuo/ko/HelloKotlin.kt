package com.zuo.ko

import rx.Observable
import java.io.File
import java.math.BigInteger
import java.util.concurrent.Executors

fun main(args: Array<String>) {
    val text = File(ClassLoader.getSystemResource("input").path).readText()
    Observable.from(text.toCharArray().asIterable()).filter { !it.isWhitespace() }.groupBy { it }.map{
        o -> o.count().subscribe {
           println("${o.key} -> $it")
        }
    }.subscribe()

//    val run = Executors.newCachedThreadPool()
//    run.execute {
//        println("helloWorld!")
//    }

//    println(factoria(5))
    val result = Result()
    factoria2(10000,result)
    println(result.value)
}

//递归运算阶乘
fun factoria(num:Int):BigInteger{
    if(num == 0) return BigInteger.valueOf(1L)
    return BigInteger.valueOf(num.toLong()).times(factoria(num - 1))
}

//尾递归优化
tailrec fun factoria2(num:Int,result:Result){
    if(num == 0) result.value.times(BigInteger.valueOf(1L))
    else{
        result.value = result.value.times(BigInteger.valueOf(num.toLong()))
        factoria2(num - 1,result)
    }
}

class Result(var value:BigInteger = BigInteger.valueOf(1L))