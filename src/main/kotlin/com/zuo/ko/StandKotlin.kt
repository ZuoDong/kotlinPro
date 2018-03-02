package com.zuo.ko

import com.sun.org.apache.xpath.internal.functions.FunctionDef1Arg
import java.io.BufferedReader
import java.io.FileReader
import java.util.function.Function

/**
 * run、with、let、also、apply、takeIf、takeUnless、repeat等操作函数
 */
fun main(args: Array<String>) {
    getUserA()?.let {
        println(it.name)
        println(it.age)
    }

    getUserA()?.apply {
        println(name)
        println(age)
    }

    readFile()
}

data class UserA(val name:String,val age:Int)

fun getUserA():UserA?{
    return null
}

fun readFile(){
    val br = BufferedReader(FileReader("hello.txt"))
    with(br){
        var line:String
        while (true){
            line = readLine()?:break
            println(line + "  with")
        }
        close()
    }

    //优化 use关闭Closeable
    BufferedReader(FileReader("hello.txt")).use {
        var line:String
        while (true){
            line = it.readLine()?:break
            println(line + "  use")
        }
    }

    //进一步优化
    println(BufferedReader(FileReader("hello.txt")).readText() + "  readText()")
}

//val m() = f() compose g()
infix fun <P1,P2,R> Function1<P2,R>.compose(function:Function1<P1,P2>):Function1<P1,R>{
    return fun(p1:P1):R{
        return this.invoke(function.invoke(p1))
    }
}
