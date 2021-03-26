package com.example.hellokotlin

//클래스 정의하기
class MyCar

class YourCar{
    //멤버 함수
    fun drive(){
        println("달려요!")

    }
}

// 대표(primary) 생성자는 클래스명 우측에 선언한다.
class OurCar constructor(){

}
class OurCar2(){ //constructor 예약어 생략가능

}
class OurCar3{// 인자로 전달 받을게 없으면 () 생략가능

}
class AirPlane{
    // 초기화 블럭(객체가 생성되는 시점에 무언가 작업할 수 있는 블럭)
    init {
        println("AirPlane 클래스 init{}")
    }
}

class Person(name:String){
    //필드 선언
    var name:String
    init{
        println("name:"+name)
        //생성자의 인자로 전달 받은 값을 필드에 저장하기
        this.name=name
    }
}

class AnotherPerson(var name:String){
    fun showInfo(){
        println("내이름은 : "+name)
        println("내이름은 : "+this.name)
        println("내이름은 : ${name}")

    }
}

fun main(){
    // MyCar 클래스로 객체 생성
    var c1 = MyCar()
    // YourCar 클래스로 객체 생성
    var c2:YourCar = YourCar()
    c2.drive()
    var a1=AirPlane()
    var p1=Person("김구라")
    var name = p1.name // Person 객체의 필드 참조

    var p2=AnotherPerson("해골")
    p2.showInfo()
    var name2=p2.name
    p2.name="원숭이"
    p2.showInfo()
}