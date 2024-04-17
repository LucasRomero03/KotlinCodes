import kotlin.random.*
////Avaliação Lazy

// Problemas com Coleções Lazy
// Ou a coleção não é avaliada ou ela é TODA avaliada

fun main() {
	println("Programa Carregado")
    val x by lazy {
        println("x calculado")
        generateSequence(0) {n -> 
            println("calculando x[$n]")
            n+1
        }
    }
    val y by lazy {
        println("y calculado")
        generateSequence(5) {n -> 
            println("calculando y[$n]")
            n+1
        }
    }
    println("Inicio")
    println("x[1] = ${x.take(5).toList()}")
    println("y[2] = ${y.take(10).toList()}")
    println("y[2] = ${y.take(5).toList()}")
    println("Fim")
}