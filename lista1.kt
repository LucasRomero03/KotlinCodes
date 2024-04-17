ALUNOS APROVADOS E REPROVADOS:

class Aluno(val nome: String, val nota: Double)

class Lista(val aluno: Aluno, val prox:Lista?){
    
    fun imprime(l: Lista?) {
        if (l == null) {
            return
        } else {
            println( l.aluno.nome +" "+ l.aluno.nota)
            imprime(l.prox)
        }
    }
}
fun merofilter(l: Lista?, t: (Aluno) -> Boolean): Lista? {
    if (l == null) {
        return null
    } else if (t(l.aluno)) {
        return Lista(l.aluno, merofilter(l.prox, t))
    } else {
        return merofilter(l.prox, t)
    }
}

fun divideAlunos(l: Lista?): Pair<Lista?, Lista?> {
    val aprovados = merofilter(l) { it.nota > 7 }
    val reprovados = merofilter(l) { it.nota < 5 }
    return Pair(aprovados, reprovados)
}

fun main() {
   val listaAlunos = Lista(Aluno("João", 5.0),Lista(Aluno("Maria", 8.0),Lista(Aluno("Pedro", 8.5),Lista(Aluno("Ana", 9.0),Lista(Aluno("Carlos", 3.0), null)))))
    

    val (aprovados, reprovados) = divideAlunos(listaAlunos)

    println("Os alunos aprovados foram:")
    aprovados?.imprime(aprovados)

    println("Os alunos reprovados foram:")
    reprovados?.imprime(reprovados)
}


