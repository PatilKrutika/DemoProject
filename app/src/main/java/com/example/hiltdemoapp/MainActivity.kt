package com.example.hiltdemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //Field Injection
    @Inject lateinit var simpleDI: SimpleDI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        simpleDI.printHello()
        simpleDI.printName()
    }
}


class SimpleDI @Inject constructor(private val constructorID: ConstructorDI/*ConstructorInjection*/ ){
    fun printHello(){
        println("Hello")
    }

    fun printName(){
        println( constructorID.printHello("Krutika"))
    }
}

class ConstructorDI @Inject constructor(){
    fun printHello(name:String){
        println("Hello: $name")
    }
}