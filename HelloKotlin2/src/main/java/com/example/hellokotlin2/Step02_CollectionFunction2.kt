package com.example.hellokotlin2

fun main(){
    val nums = listOf(1, 2, 3, 4, 5)
    val names = listOf("김구라", "해골", "원숭이")
    /*
        map() 함수는 original Collection의 각 item을 원하는 형태로
        변환해서 새로운 Collection을 리턴하는 함수이다.
     */
    val nums2 = nums.map{it*it}
    val names2 = names.map{it+"님"}

    println(nums2)
    println(names2)

    val nums3 = nums.filter { it % 2 == 0 }.map{it*it}
    println(nums3)
}
