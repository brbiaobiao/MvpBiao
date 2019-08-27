package com.biaobiao.prijectLibrary.kotlintest

import android.app.Activity
import android.graphics.RectF
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.biaobiao.prijectLibrary.R


/**
 * @author: biao
 * @create: 2019/6/11
 * @Describe:
 */

class TestKotlinClass constructor(name: String) {
    init {
        println("name--->$name")
    }


    var biao: Int = 1

    constructor(name: String, value: Int) : this(name) {
        println("name-->$name+===value-->$value")
    }

    constructor(name: String, value: Int, cn: String) : this(name) {
        println("name-->$name&&cn-->$cn&&value-->$value")
    }
}

class Runnan constructor(var one: Int = 0, two: String) {

    private val ont:Int = one
    private val twt:String = two

    init {

        println("one:$one///two:$two")
    }

    constructor(three: Int) : this() {
        println("three:$three")
    }

    constructor(one: Int = 1, two: String = "two", four: Int = 3) : this(one, two) {
        println("one:$one///two:$two///four:$four")
    }
}

class privateClass private constructor(name: String) {
    //用到了private修饰符,故不能省略
}

fun canNullFunName() {
    var one: String = "One"//普通变量
    var two: String? = "two"//可空变量

    one = "noNull"
    //one = null  编译器报错：Null can not be a value of a non-null type String
    if (one!=null){}//这一行毫无意义，因为one这辈子都不会为空

    two = null // 编译器通过，two可为空
    if (two == null){
        println("two:$two")
    }

    var twoLength = if (two!=null&&two?.length>0)two.length else -1
    println("twoLength:$twoLength")

    val builderStr = BuilderKotlin.Builder().setName("biao")?.setAge(25)?.setHeight(173)?.toString()
    println("BuilderKotlin:$builderStr")

    var testStr: String? = null
    val dec = testStr?.plus(5)?.length?.dec()
    println("dec:$dec")

    println("MayNull:${MayNull()}")

    var arrayListIndices = arrayOf(10,null,30,40,null)
    //传统的写法
    for (index in arrayListIndices){
        if (index == null){
            continue
        }
        println("index:$index")
    }

    //使用let操作符
    for (index in arrayListIndices){
        index?.let {
            println("index:$index")
        }
    }

    var length = 0
    var first:String? = null
    //传统写法
    length = if (first != null)first.length else -1

    //使用?:操作符，通常和?.一起使用
    length = first?.length ?: -1

    println("firstLenth:$length\nfirstLen:$length")

    var second:String? = "second"
    length = second?.length ?: -1
    println("secondLen:$length")

    var numOne:Int? = "koltin" as? Int
    println("numOne:$numOne")

    LateinitClass().initDate()
}

class BuilderKotlin{

    class Builder{
        public var name:String = ""
        private var age:Int = 0
        private var height:Int = 0

        fun setName(name:String):Builder{
            this.name = name
            return this
        }

        fun setAge(age:Int):Builder{
            this.age = age
            return this
        }

        fun setHeight(height:Int):Builder{
            this.height = height
            return this
        }

        override fun toString(): String {
            return "Bulider:name=$name;age=$age;height=$height"
        }
    }
}

fun MayNull():Int?{
    var name:String? = "biao"
    return name?.length
}

class LateinitClass{

    lateinit var name:String
    //'lateinit' modifier is not allowed on properties of primitive types
//    lateinit var song:String? //'lateinit' modifier is not allowed on properties of nullable types

    fun initDate(){
        name = "biao"
        println(println("name:$name"))
    }
   /* lateinit var textView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        textView = findViewById(R.id.getEdit_btn)
    }*/
}

interface Ikotlin{
    var name:String
}

class IKotlinImpl:Ikotlin{
    override var name: String
        get() = "biao"
        set(value) {}
}

class LazyClass{
    var width:Int=0
    var height:Int=0
    val bound: RectF by lazy {
        RectF(0f, 0f, width.toFloat(), height.toFloat())
    }
    //by lazy是单例模式的(if null init else return),而且当且仅当变量第一次被初始化时，委托方法(by lazy)才会被调用
    val name by lazy {
        println("只调用一次")
        "biao"
    }


    //kotlin 封装：
    fun <V : View> Activity.bindView(id: Int): Lazy<V> = lazy {
        viewFinder(id) as V
    }

    //acitivity中扩展调用
    private val viewFinder: Activity.(Int) -> View?
        get() = { findViewById(it) }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //在activity中的使用姿势
        val mTextView by bindView<TextView>(R.id.edit_query)
        mTextView.text="执行到我时，才会进行控件初始化"
    }*/
}

class simpleClass(var age:Int,name:String){
    val mName = name

    init {
        println("name:$name")
    }

    fun test(){
        println("mName:$mName")
    }

}

class simpleClassSeconddly{

    constructor(age: Int,name: String){
        println("age:$age\nname$name")
    }
}


fun main(args: Array<String>) {
    val runnan = Runnan()
    val runnan1 = Runnan(1, "二")
    val runnan2 = Runnan(3)
    val runnan3 = Runnan(1, "二", 30)
    val one = runnan3.one
    runnan1.one
    println("one--$one")

    var testKotlinClass = TestKotlinClass("biao", 24, "China")
    testKotlinClass.biao = 2
    println("了解class-->${testKotlinClass.biao}")

    canNullFunName()

    val IName = IKotlinImpl().name
    println("IName:$IName")

    val lazyClass = LazyClass()
    val name = lazyClass.name
    val name1 = lazyClass.name
    println("lazy-name:$name")
    println("lazy-name:$name1")

    val simpleClass = simpleClass(10, "biaobiao")
    simpleClass.age
    val mName = simpleClass.mName
    println("mName$mName")
    simpleClass.test()
}
