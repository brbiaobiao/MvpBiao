package com.biaobiao.prijectLibrary

/**
 * @author: biao
 * @create: 2019/6/4
 * @Describe:
 */
fun main(args: Array<String>) {//程序入口
    println("kotlin博客")
    testVariable()
    ifCode(3)
    whenCode(5)
    forCode()
}

fun testVariable() {
    var a = 1 //var 定义的变量是可以多次赋值的
    a = 3 //重新赋值
    println(a)
    var x = 5
    x += 1
    println("x = $x")//串模板 串可以包含模板表达式，即：可计算的代码片段，其结果链接到串中。模板表达式以美元符号（$）开始，和简单的名字构成：

    val l = "kotlin" //val定义的是一旦被赋值之后就不能再赋值，类似java的final
//    l = "string" //编译器报错:val cannot be reassigned
    println(l)
    val j: Int = 1 //立即赋值
    val i = 1 //自动推断出类型
    val u: Int //没有赋值，得先确认类型
    u = 3
    println("j:$j===i:$i===u:$u")
}

fun ifCode(tag: Int) {
    var flag = 3
    if (tag == flag) {
        println("$flag == $tag--->true")
    } else {
        println("$flag == $tag--->false")
    }

    var num: Int = if (flag > 3) 3 else 5
    println("num--->$num")

    var numA = if (flag < 3) {
        flag = 10
        println("numA < 3 is true")
        flag
    } else if (flag == 3) {
        flag = 20
        println("numA = 3 is true")
        flag
    } else {
        flag = 30
        println("numA > 3 is true")
        flag
    }
    println("numA ---> $numA")
}


fun whenCode(flag: Int) {
    //相当于switch
    var tag = 6
    when (tag) {
        1 -> println(1)
        2 -> println(2)
        1, 4 -> println("tag等于3或者等于4")
        in 5..10 -> println("tag在5到10之中")
        !in 11..20 -> println("tag不在11到20之中")
        else -> println("else")//这里的else就是switch中的default
    }

    var item = setOf("flutter", "kotlin", "java")
    when {
        "android" in item -> println("android is contains of item")
        "kotlin" in item -> println("kotlin is contains of item")
    }

    when(tag>1){
        true -> println("tag大于1")
        false-> println("tag小于1")
        else-> println("tag等于1")
    }

    when(tag){
        is Int -> println("$tag is a int")
    }
}

fun forCode(){
    //递增规则，until[m,n) 大于等于m，小于n
    for (i in 0 until 5){
        print("递增--->$i")
    }

    //递减规则，downTo[x,y] 大于等于x,小于等于y
    for (i in 8 downTo 6){
        print("递减--->$i")
    }
}