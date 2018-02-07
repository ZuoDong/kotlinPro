package com.zuo.ko

fun main(args:Array<String>){
//    for (it in args){
//        println(it)
//    }
//    println()
    /**
     * 竟然可以这么for循环
     */
    for(i in args.indices){
        println(args[i])
    }

    /**
     * 解构声明
     * destructuring declarations
     */
    val pair = Pair(1, "one")
    val (num, namea) = pair
    println("num = $num, name = $namea")

    /**
     * data classes
     */
    val user = getUser()
    println("name = ${user.name}, id = ${user.id}")

    // or
    val (name, id) = getUser()
    println("name = $name, id = $id")

    // or
    println("name = ${getUser().component1()}, id = ${getUser().component2()}")
}

class Pair<K, V>(val first: K, val second: V) {
    operator fun component1(): K {
        return first
    }

    operator fun component2(): V {
        return second
    }
}

data class DataUser(val name: String, val id: Int)

fun getUser(): DataUser {
    return DataUser("Alex", 1)
}