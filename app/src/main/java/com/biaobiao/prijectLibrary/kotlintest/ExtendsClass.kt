package com.biaobiao.prijectLibrary.kotlintest

import com.biaobiao.prijectLibrary.manager.Constants.modufiy.biao

/**
 * @author: biao
 * @create: 2019/8/26
 * @Describe:
 */

open class InheritClass {
    open var num = 3
    open fun funOne() = "funOne"
    open fun funTwo() = 25
    open fun funThree() = "funThree"

    open val valStrOne = "I am val string one"
    open val valStrTwo = "I am val string one"
    open val valStrThree = "I am val string one"
    open val valStrFour = "I am val string four"
    open val valStrFive = "I am val string five"
}

class DemoTest : InheritClass() {
    fun funThree(name: String): String {
        return name
    }

    override fun funThree(): String {
        return super.funThree()
    }

    override var num: Int = 10

    override val valStrOne: String
        get() = super.valStrOne

    override var valStrTwo: String = ""
        get() = super.valStrTwo

    override val valStrThree: String = ""

    override var valStrFour: String = "abc"
        set(value){field = value}

    override var valStrFive: String = "cba"
        get() = super.valStrFive
        set(value){field = value}
}

fun main(args: Array<String>) {
    val demoTest = DemoTest()
    println(demoTest.num)
    println(demoTest.funOne())
    println(demoTest.funTwo())
    println(demoTest.funThree())
    demoTest.funThree("I am funThree,Do you known polymorphic?")

    println(demoTest.valStrOne)
    println(demoTest.valStrTwo)
    println(demoTest.valStrThree)
    println(demoTest.valStrFour)
    demoTest.valStrFour = "I am Icon man"
    println(demoTest.valStrFour)

    println(demoTest.valStrFive)
    demoTest.valStrFive
    println(demoTest.valStrFive)

}