class Lista(val info: Int, val prox:Lista?){
    
    fun imprime(l: Lista?): Int?{  
        if (l == null) {
            return null 
        } else {
            print(l.info)
            print(" ")
            return imprime(l.prox)
        }
    }
    
    fun adiciona (numero: Int ,l: Lista?): Lista?{  // pega um número e adiciona no final da lista passada
        if (l == null){
        	return Lista(numero, l)    
        } else {
            return Lista(l.info, adiciona(numero, l.prox))
        }
    }    

// 1
   fun  somaPares(l: Lista?): Int {
       
     val soma= {l: Lista? -> if (l==null) 0 else if (l.info % 2 == 0 ) l.info+ somaPares(l.prox) else somaPares(l.prox)}
   
    return soma(l)
   }   
    
//2 (verificar)
 	fun impar(l: Lista?): Lista? {

    val impar = { l: Lista? ->

        if (l == null) null
        else if (l.info % 2 == 0){
            Lista(l.info,impar(l.prox))
            
        } else {
            Lista(l.info*l.info,impar(l.prox))
           
        }
    }

    return impar(l)
}
 

 
 
}
fun main() {
    
 val lista1 = Lista(1,Lista(2,(Lista(3,(Lista(4, Lista(5, null)))))))
 print("Primeira questão, somar pares: ")
 println(lista1.somaPares(lista1))    
 println("")
 
 val teste = lista1.impar(lista1)
 print("Segunda questão, Lista ímpares: ")
 teste?.imprime(teste)

}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

QUESTÂO PARA FILTRAR A PARTIR DE UMA IDADE

class Pessoa(val nome: String, val idade: Int, val cidade: String)

class Lista(val pessoa: Pessoa, val prox:Lista?){
    
    fun imprime(l: Lista?) {
        if (l == null) {
            return
        } else {
            println( l.pessoa.nome +" "+ l.pessoa.idade + " "+ l.pessoa.cidade)
            imprime(l.prox)
        }
    }
    
    fun imprime2(l: Lista?) {
        if (l == null) {
            return
        } else {
            println( l.pessoa.nome +" "+ l.pessoa.cidade)
            imprime2(l.prox)
        }
    }
    
    
  fun merofilter(l: Lista?, t: (Pessoa) -> Boolean): Lista? {
    if (l == null) {
        return null
    } else if (t(l.pessoa)) {
        return Lista(l.pessoa, merofilter(l.prox, t))
    } else {
        return merofilter(l.prox, t)
    }
}
  
	fun filtragem(l: Lista?): Lista? {

    val filtro = { l: Lista? ->

        if (l == null) null
        else if (l.pessoa.idade > 18){
            Lista(l.pessoa,filtragem(l.prox))
            
        } else {
            filtragem(l.prox)
           
        }
    }

    return filtro(l)
}
    
    fun meromap(l: Lista?, m: (Pessoa)->String):Lista?{
        if(l==null){
            return null
        }
        else{
           return Lista(Pessoa(m(l.pessoa), l.pessoa.idade, ""), meromap(l.prox, m))
        }
    } 
    
   
  
    
    
}

fun main() {
    
    
     val listaPessoas = Lista(Pessoa("João", 19,"Recife"),Lista(Pessoa("Maria", 24,"Olinda"),Lista(Pessoa("Pedro", 26,"SaoPaulo"),Lista(Pessoa("Ana", 9,"Rio de Janeiro"),Lista(Pessoa("Carlos", 18,"Santos"), null)))))
  //listaPessoas.imprime(listaPessoas)
  println("usando o mero filter")
  val teste = listaPessoas.merofilter(listaPessoas) { pessoa -> pessoa.idade > 18 }
teste?.imprime(teste)
val teste1 = listaPessoas.filtragem(listaPessoas)
println("usando expressao 'lambda'")
teste1?.imprime(teste1)
println("mapeando os nomes")
val teste2= teste1?.meromap(teste1){ pessoa -> pessoa.nome }

teste2?.imprime2(teste2)
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

QUESTAO PARA FILTRAR APROVADOS E REPROVADOS 2

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
    
    fun aprovados(l:Lista?):Lista?{
        if(l==null){
            return null
        }
        else if( l.aluno.nota > 7){
            return Lista(l.aluno,aprovados(l.prox))
        }
        else {
            return aprovados(l.prox)
        }
    }
      fun reprovados(l:Lista?):Lista?{
        if(l==null){
            return null
        }
        else if( l.aluno.nota < 5){
            return Lista(l.aluno,reprovados(l.prox))
        }
        else {
            return reprovados(l.prox)
        }
    }
    
 fun separaAlunos(l: Lista?): Pair<Lista?, Lista?> {
    val aprovados = aprovados(l)
    val reprovados = reprovados(l)
    return Pair(aprovados, reprovados)
}
    
    
    
    
    }


fun main() {
    
  
    val listaAlunos = Lista(Aluno("João", 5.0),Lista(Aluno("Maria", 8.0),Lista(Aluno("Pedro", 8.5),Lista(Aluno("Ana", 9.0),Lista(Aluno("Carlos", 3.0), null)))))
   
  
    val (aprovados, reprovados) = listaAlunos.separaAlunos(listaAlunos)
    println("Os alunos aprovados foram:")
     aprovados?.imprime(aprovados)
     println("Os alunos reprovados foram:")
     reprovados?.imprime(reprovados)
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

QUESTÃO SOBRE FILTRAR PEDIDO PELO STATUS


class Pedido(val cliente: String, val valor: Double, val status: String)
class Lista(val pedido: Pedido, val prox:Lista?){
    
    fun imprime(l: Lista?) {
        if (l == null) {
            return
        } else {
            println( l.pedido.cliente +" "+ l.pedido.valor + " "+ l.pedido.status)
            imprime(l.prox)
        }
    }
    
   
    
    
  fun merofilter(l: Lista?, t: (Pedido) -> Boolean): Lista? {
    if (l == null) {
        return null
    } else if (t(l.pedido)) {
        return Lista(l.pedido, merofilter(l.prox, t))
    } else {
        return merofilter(l.prox, t)
    }
}
  
	fun filtragem(l: Lista?): Lista? {

    val filtro = { l: Lista? ->

        if (l == null) null
        else if (l.pedido.status == "enviado"){
            Lista(l.pedido,filtragem(l.prox))
            
        } else {
            filtragem(l.prox)
           
        }
    }

    return filtro(l)
}
    
  fun qtd(l: Lista?): Int{
       
      val quantidade = { l: Lista? ->

        if (l == null) 0
         else {
            1 + qtd(l.prox)
           
        }
    }

    return quantidade(l)
     
        
    } 
    
   
  
    
    
}
fun main() {
    val listaPedidos = Lista(Pedido("João", 19.0,"separando"),Lista(Pedido("Maria", 24.0,"separando"),Lista(Pedido("Pedro", 26.0,"enviado"),Lista(Pedido("Ana", 9.0,"entregue"),Lista(Pedido("Carlos", 18.0,"enviado"), null)))))
 // listaPedidos.imprime(listaPedidos)
 
val teste1 = listaPedidos.filtragem(listaPedidos)
println("usando expressao 'lambda'")
teste1?.imprime(teste1)

val teste2 = teste1?.qtd(teste1)
println("A quantidade de pedidos com o status desejado e: $teste2 ")

}