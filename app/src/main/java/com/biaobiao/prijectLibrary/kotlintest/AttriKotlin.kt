package com.biaobiao.prijectLibrary.kotlintest

/**
 * @author: biao
 * @create: 2019/7/9
 * @Describe:
 */

const val constAttri: String = "顶层声明"

object ObjectClass {
    const val constAttri: String = "在object对象中声明"
}

class AttriKotlin {
    companion object {
        const val constAttri: String = "在伴生对象中声明"
    }

    var biao: String = "biao"
        get() = field.toUpperCase()   // 将变量赋值后转换为大写
        set(value) {
            field = if (value.isNotEmpty()) value else "null"
        }

    var age: Int = 100
        set(value) {
            if (value < 10) {       // 如果传入的值小于 10 返回该值
                field = value
            } else {
                field = -1         // 如果传入的值大于等于 10 返回 -1
            }
        }

    private val num: Int = 0

    val isBland: Boolean
        get() = this.num == 0

    var xie: String = ""
        get() = "不管如何我就是不会改"
        set(value) {
            field = if (value.isNotEmpty()) value else "null"
        }

    var nullable: Int? = null //可空变量 "?"是不能省略的，不然就跟普通变量一样了
}

fun main(args: Array<String>) {
    val attriKotlin = AttriKotlin()
    attriKotlin.biao = "songbiao"
    println("name:${attriKotlin.biao}")

    attriKotlin.biao = ""
    println("name:${attriKotlin.biao}")

    attriKotlin.age = 9
    println("age:${attriKotlin.age}")

    attriKotlin.age = 20
    println("age:${attriKotlin.age}")

    println("isBland:${attriKotlin.isBland}")

    println("xie:${attriKotlin.xie}")
    attriKotlin.xie = ""
    println("xie:${attriKotlin.xie}")
    attriKotlin.xie = "value"
    println("xie:${attriKotlin.xie}")

}