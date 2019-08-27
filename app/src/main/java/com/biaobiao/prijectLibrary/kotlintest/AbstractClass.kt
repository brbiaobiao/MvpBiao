package com.biaobiao.prijectLibrary.kotlintest

/**
 * @author: biao
 * @create: 2019/8/19
 * @Describe:
 */
abstract class AbstractClass {
    //自身的属性
    var tag = this.javaClass.simpleName

    //自身的方法
    fun simpleFun():Unit{//Unit相当于java中的void，表示没有返回值，可以省略不写
        TODO("do something")
    }

    //抽象属性和方法
    abstract var string:String
    abstract fun init()
}

class ChildrenClass : AbstractClass() {
    //不是抽象类的子类必须实现父类的方法和属性
    override var string: String
        get() = tag
        set(value) {}

    override fun init() {
        println("Implementing parent class methods，Obtain tag:$string")
    }
}

abstract class AbsChildrenClass : AbstractClass(){
    //抽象子类可不用实现父类的方法和属性
    var name = this.javaClass.simpleName
    abstract fun check()
}

class absExtend : AbsChildrenClass(){
    var className = this.javaClass.simpleName
    override var string: String
        get() = name
        set(value) {}

    override fun init() {
        println("name:$name")
    }

    override fun check() {
        if (className == string) println("do something")
        else println("Nothing can be done")
    }
}

fun main(args : Array<String>){
    //抽象类不能直接实例化
    //val abstractClass = AbstractClass()//Cannot create an instance of an abstract class
    val childrenClass = ChildrenClass()
    var abstractClass:AbstractClass = ChildrenClass()//若要实现抽象类的实例化，需要依靠子类采用向上转型的方式处理
    val absExtend = absExtend()

    childrenClass.init()
    absExtend.init()
    absExtend.check()
}