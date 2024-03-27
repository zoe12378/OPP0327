package tw.edu.pu.csim.opp0327

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var txv:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txv = findViewById(R.id.txv)

        var abap = Course("ABAP程式設計", "智慧企業")
        abap.x = "x"
        abap.y = "y"
        var app = Course("行動應用軟體開發", "人工智慧應用", false)

        var tcyang = Teacher("tcyang","csim")

        var zoe = Student("zoe","csim")

        var McQueen = Car()
        var Kitty = Cat()
        txv.text =  "物件導向實力\n" + Course.Add() + app.Display() + Course.Add() + abap.Display() + tcyang.Hello() + tcyang.Work() + zoe.Hello() + zoe.Work()+ McQueen.Sound()+"\n"+Kitty.Sound()


    }
}
class Course(var CourseTitle: String= "",
             var CreditProgram: String = "",
             var SAP: Boolean = true){
    var x:String = ""
    var y:String = ""
    init {
        this.CourseTitle = CourseTitle + "課程"
    }

    fun Display(): String{
        var info:String = CourseTitle + ":"
        info += CreditProgram + "學程"
        if (SAP) info+= " (搭配SAP系統授課)"
        info+= "\n\n"
        return info
    }
    companion object{
        var count: Int = 0
        fun Add():String{
            count++
            return "第" + count.toString() + "門課程：\n"
        }
    }

}
open class Person(var Name:String){
    open fun Hello():String{
        return Name + "，您好！\n"
    }
}

open class Teacher(Name:String, var dep:String):Person(Name){
    open fun Work():String{
        return "任職於" + dep + "\n\n"
    }
}
open class Student(Name:String ,dep:String):Teacher(Name,dep){
    override fun Work():String{
        return "就讀於"+dep+"\n\n"
    }
}
interface A{
    fun Sound():String{
        return "~叭噗"
    }
}
interface B{
    fun Sound():String{
        return "~逼逼"
    }
}

class Car: A,B {
    override fun Sound(): String {
        return "汽車叭叭叭" + super<A>.Sound()+ super<B>.Sound()
    }
}
class Cat:A{
    override fun Sound():String{
        return "貓咪喵喵喵"
    }
}