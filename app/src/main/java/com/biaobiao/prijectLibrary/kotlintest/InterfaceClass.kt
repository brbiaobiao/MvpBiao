package com.biaobiao.prijectLibrary.kotlintest

/**
 * @author: biao
 * @create: 2019/8/26
 * @Describe:
 */
interface InterfaceClass {

    fun funOne()

    fun funTwo(num: Int)

    fun funThree(num: Int): Int

    /**
     * 定义了一个有参无返回值的方法
     * 因为有结构体故可以不用重写
     */
    fun funFour(): String {
        return "I am funFour"
    }
}

open class Demo : InterfaceClass {
    override fun funOne() {
        println("funOne are using")
    }

    override fun funTwo(num: Int) {
        println("funTwo are using and parem is num:$num")
    }

    override fun funThree(num: Int): Int {
        println("funThree are using and parem is num:$num")
        return num + 1
    }

    /**
     * 接口中的funFour()方法默认返回”funFour“字符串.
     * 可以用super.funFour()返回默认值
     * 也可以不用super关键字，自己返回一个字符串
     */
    override fun funFour(): String {
        println("user I am funFour")
        return super.funFour()
    }
}

interface InterfaceFeild {
    var num:Int
    var name:String
    val age
        get() = 2

    var number:Int
}

class Demo1(override var num: Int, override var name: String) :InterfaceFeild{

    fun test(){
        println("num:$num\tname:$name")

        println("age:$age\tnumber:$number")
    }

    override val age: Int
        get() = super.age

    override var number: Int = 25
}

interface InfOne{
    fun funTest(){
        println("I am InfOne")
    }
}

interface InfTwo{
    fun funTest(){
        println("I am InfTwo")
    }
}

class Demo2 : InfOne,InfTwo{
    override fun funTest() {
        super<InfOne>.funTest()
        super<InfTwo>.funTest()
    }

}

fun main(args: Array<String>) {
    val demo = Demo()
    demo.funOne()
    demo.funTwo(8)
    println(demo.funThree(9))
    println(demo.funFour())

    val demo1 = Demo1(21, "biao")
    demo1.test()
    demo1.number = 3
    demo1.test()

    val demo2 = Demo2()
    demo2.funTest()
}