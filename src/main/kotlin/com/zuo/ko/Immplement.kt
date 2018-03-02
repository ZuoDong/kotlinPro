package com.zuo.ko

import java.lang.StringBuilder

abstract class A{
    abstract val j:Int

    fun methA(){

    }
}
interface B{
    fun methB()
}
interface C{
    fun methC(){

    }
}

open class D(override val j: Int) :A(),B,C{
    override fun methB() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun methD(){

    }
}

class F:D(2){

}

//静态方法
fun methodA(){

}

object SingletonT{
    const val a:Int = 0
}

class StaticFiled{
    companion object {
        val staticFiled = "haha"
        fun staticMethod():String{
            return "我是静态方法"
        }
    }
}

fun main(args: Array<String>) {
    val d = D(0)
    val a:A = D(0)

    val singleton = SingletonT.a
    val static = StaticFiled()
    println(StaticFiled.staticFiled)
    println(StaticFiled.staticMethod())


//    (0..6).map(::factoria3).forEach(::println)

    println((0..6).map(::factoria3).fold(StringBuilder()){ acc, i ->
        acc.append(i).append(",")
    }.toString())

    println((0..6).joinToString())
}

enum class AlarmType(val type: String, val generalType: Int) {
    MEMORY("memory", AlarmType.CONTAINER_TYPE),
    CPU("cpu", AlarmType.CONTAINER_TYPE);

    companion object {
        const val DEFAULT_TYPE = 0
        const val CONTAINER_TYPE = 1
        const val DOCKER_DAEMON_TYPE = 2
        const val AGENT_TYPE = 3
    }

    override fun toString(): String {
        return "$type is $generalType"
    }
}

fun factoria3(n:Int):Int{
    if(n == 0) return 1
    return (1..n).reduce { acc, i -> acc * i }
}
