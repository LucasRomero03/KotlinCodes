typealias F1 = (Int) -> Int

typealias F3 = (Int,Int) -> Int

fun soma(f1: F1, f2: F1): F1 = {x: Int -> f1(x) + f2(x)}

fun soma2(f1: F1, f2: F1):F3 = {x: Int, y: Int -> f1(x) + f2(y)}

fun potencia(f1: F1, f2: F1):F3 = {x: Int, y: Int -> if (y<=1) f1(x) else f1(x)*f2(potencia(f1, f2)(x,y-1))}



fun main() {
    
  	val f1: F1 = { it } 
    
  	val f2: F1 = { it }
   
	//val f4 = soma(f1, f1)//1 parametro
    //val f5 = soma2(f1, f2) //2 parametros
	val pot = potencia(f1, f2)
   val result = potencia(f1, f2)(2, 3)
    
   // println(f4(10))
   // println(f5(10,4)) 
    println(result)
    println(pot(2,3))
   
}
