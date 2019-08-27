package com.biaobiao.prijectLibrary.kotlintest

import android.view.View

/**
 * @author: biao
 * @create: 2019/8/21
 * @Describe:
 */

fun main(args:Array<String>){
    val nestingClass = OutdoorClass.NestingClass()
    nestingClass.nesteMethou()

    val innerClass = OutClass().InnerClass()
    innerClass.innerFun()

    val anonymousClass = AnonymousClass()
    anonymousClass.setOnClickListener(object :OnClickListener{
        override fun onItemClick(str: String) {
            println("to do something")
        }
    })

    val localClass = LocalClass()
    localClass.partMouth()
}

/**
 * 嵌套类
 */
class OutdoorClass{

    private var name = "biao"
    fun outdoorMethou(){
        //nesteMethou()//无法直接调用嵌套类的成员
        //只能通过实例嵌套类来调用
        val nestingClass = NestingClass()
        nestingClass.nesteMethou()
    }

    class NestingClass{

        fun nesteMethou(){
            //println("name:$name")//无法使用外部类的成员
            println("to do something magic")
        }
    }
}

class OutClass{

    //外部类的私有属性可以被内部类使用
    private var name = "xie"
    //外部类的私有函数可以被内部类使用
    private fun outFun(){
        println("i am outFun")
    }

    //通过此方法实例化内部类，再调用内部类方法
    fun getInnerClassTodo(){
        //innerFun()//这种外部类直接调用内部类成员的方式是编译不通过的，因为此时根本不存在内部类的对象
        val innerClass = InnerClass()
        innerClass.innerFun()
    }

    inner class InnerClass{
        var age = 20

        fun innerFun(){
            println("name: $name+age:$age")
            outFun()
        }
    }
}

/**
 * 定义一个接口
 */
interface OnClickListener{
    fun onItemClick(str : String)
}

/**
 * 匿名内部类
 */
class AnonymousClass{
    lateinit private var listener : OnClickListener

    fun setOnClickListener(listener: OnClickListener){
        this.listener = listener
    }

    fun testListener(){
        listener.onItemClick("我是匿名内部类的测试方法")
    }
}

/**
 * 局部类
 */
class LocalClass{

    var numOut = 1

    fun partMouth(){

        var name = "partMouth"

        class PartClass{
            var numPart : Int = 2

            fun test(){
                name = "PartClass"
                numOut = 3
                numPart = 4
                println("我是局部类中的方法")
            }
        }

        val partClass = PartClass()
        println("name = $name \t numPart = " + partClass.numPart + "\t numOut = $numOut")
        partClass.test()
        println("name = $name \t numPart = " + partClass.numPart + "\t numOut = $numOut")
    }
}