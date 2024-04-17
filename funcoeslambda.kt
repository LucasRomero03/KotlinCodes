

fun soma(x: Int, y: Int): Int{
    return x+y
}

fun media(x: Double, y: Double): Double{
    return (x+y)/2
}

fun maior(x: Int, y: Int): Int{
    if (x > y){
        return x
    }else{
        return y
    }
}

fun comparar(x: Int, y: Int): Int{
    if (x < y){
        return -1
    }else if(x > y){
        return 1
    }else{
        return 0
    }
}


fun main() {
	//funçoes de alta ordem
	val somaLambda = {x: Int, y: Int -> x+y}
    val mediaLambda = {x: Float, y: Float -> (x+y)/2}
	val maiorLambda = {x: Int, y: Int -> if (x > y) x else y}
    val compararLambda = {x: Int, y: Int -> if (x < y) -1 else if (x > y) 1 else 0}
    
    
    
    
    val teste = compararLambda(2,3)
	println(teste)
    
    
    
    
    
    
    
}