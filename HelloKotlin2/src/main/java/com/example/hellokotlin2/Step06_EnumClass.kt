package com.example.hellokotlin2

//열거형 클래스 (마치 java 에서 사용하던 static final 상수처럼  사용할 수 있다)
enum class MyColor{
    // , 로 구분해서 원하는 이름을 나열하고 끝에는 ; 를 습관적으로 붙여주는 것이 좋다.
    RED, BlUE, GREEN;
}

fun main(){
    val c1 = MyColor.RED
    val c2 = MyColor.BlUE
    val c3:MyColor = MyColor.GREEN

    colorCheck(c1)
    colorCheck(c2)
    colorCheck(c3)
}

fun colorCheck(color:MyColor){
    if(color == MyColor.BlUE){
        println("색상은 파란색입니다.")
    }else{
        println("색상이 파란색이 아닙니다.")
    }
}