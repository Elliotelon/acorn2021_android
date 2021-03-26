package com.example.hellokotlin

fun main(){
    //수정 가능한 map
    val map1=mutableMapOf("num" to 1, "name" to "김구라")
    map1.put("isMan", true)

    // key 의 Generic => String
    // value 의 Generic => Any
    val map2 = mutableMapOf<String, Any>()
    val map3 : MutableMap<String, Any> = mutableMapOf()

    // 빈 Map에 데이터 넣기
    map2.put("num", 2)
    map2.put("name", "해골")

    // 빈 Map에 데이터 넣기2
    map3["num"]=3
    map3["name"]="원숭이"



}