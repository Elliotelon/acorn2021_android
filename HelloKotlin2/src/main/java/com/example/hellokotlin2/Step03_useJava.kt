package com.example.hellokotlin2

import java.util.*

/*
    kotlin 에서 java 패키지에 있는 class를 마음대로 import 해서 사용할 수 있다.

 */

fun main(){
    /*
        Random ran=new Random();
        int ranNum=ran.nextInt(10);
        System.out.println("ranNum:"+ranNum);
     */
    var ran:Random = Random()
    var ranNum:Int = ran.nextInt(10)
    System.out.println("ranNum:"+ranNum)

    //Random 클래스만 import 하고 조금더 kotlin 스럽게 코딩한다면
    val ran2 =Random() //type 추론 가능
    val ranNum2 = ran.nextInt(10) // type 추론 가능
    println("ranNum:"+ranNum) // println() 함수 사용

    /*
        Scanner scan=new Scanner(System.in);
        System.out.println("입력:");
        String line=scan.nextLine();
        System.out.println("line:"+line);
     */
    val scan:Scanner = Scanner(System.`in`) //in은 kotlin 에서 예약어 이므로
    println("입력:")
    val line= scan.nextLine()
    println("line:${line}")
}