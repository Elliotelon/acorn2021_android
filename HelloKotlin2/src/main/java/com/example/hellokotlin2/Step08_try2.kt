package com.example.hellokotlin2

fun main(){
    var str="1000"
    var str2="천"

    var result = try{
        Integer.parseInt(str)
    }catch (nfe : NumberFormatException){
        0
    }
    println("result:"+result)

    //위와 비슷하게 아래와 같은 문법도 가능하다
    val num = 8
    val result2 = if(num%2 == 0 ){
        "num은 짝수 입니다."
    }else{
        "num은 홀수 입니다."
    }
}