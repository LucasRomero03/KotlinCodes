class Lista<T>(val valor: T, val prox:Lista<T>?){
    
    fun imprime(l: Lista<T>?): T?{  
        if (l == null) {
            return null 
        } else {
            print(l.valor)
            print(" ")
            return imprime(l.prox)
        }
    }
    
    fun enesimo(v: Int,l: Lista<T>?):T?{
        if(l == null)
            return null
        if(v == 0)
            return l.valor
        else{
            return enesimo(v-1, l.prox)
        }
    }
    
    fun pertence(v: T, l: Lista<T>?): Boolean{
        if(l == null){
            return false
        } else {
            if(v == l.valor){
            return true
        } else {
            return pertence(v, l.prox)
        }
        }

    }
    
    fun nElementos(l: Lista<T>?): Int{
        if (l == null){
            return 0
        } else {
            return 1 + nElementos(l.prox)
        }
        
    }
        
    fun contaOcorrencias(v: T, l: Lista<T>?): Int{
        if(l == null){
            return 0
        } else {
          if (v == l.valor){
            return 1 + contaOcorrencias(v, l.prox)
        } else {
            return contaOcorrencias(v, l.prox)
        }  
        }   
    }
       
    fun unicaOcorrencia(v: T, l:Lista<T>?): Boolean{
        if (contaOcorrencias(v, l) == 1){
            return true
        } else {
            return false
        }
        
    }
           
    fun maior (l1: Lista<Int>?, l2: Lista<Int>?): Int?{
        if (l1 == l2){
            return maior(l1, l2?.prox)
        }
        if (l2 == null){
            return l1?.valor
        }
        if (l1 == null){
            return l2.valor
        }
        if (l1.valor > l2.valor){
            return maior(l1, l2.prox)
        } else {
            return maior(l1.prox, l2)
        }
        
    }
    
    fun maioresQue(v: Int, l: Lista<Int>?): Lista<Int>?{
        if(l == null){
           return null 
        }
        if (l.valor > v){
            return Lista(l.valor, maioresQue(v, l.prox))
        } else {
            return maioresQue(v, l.prox)
        }
        
    }
    
    fun concatenar(l1: Lista<T>?, l2: Lista<T>?): Lista<T>?{
        if (l1 == null){
            return l2
        } else if (l2 == null){
            return l1
        } else {
            return Lista(l1.valor, concatenar(l1.prox, l2))
        }
    }
    
    fun removerPrimeiro(v: T, l: Lista<T>?): Lista<T>?{
        if (l == null){
            return null
        }
        if(l.prox == null){
            return null
        }
        if (v == l.valor){
            return Lista(l.prox.valor, l.prox.prox)
        } else {
            return Lista(l.valor, removerPrimeiro(v, l.prox))
        }
        
    }
    
    fun removerValor (v: T, l: Lista<T>?):Lista<T>?{
        if (l == null){
            return null
        }
        if(v == l.valor){
            return removerValor(v, l.prox)
        } else {
            return Lista(l.valor, removerValor(v, l.prox))
        }
    }
    
    fun menor (l1: Lista<Int>?, l2: Lista<Int>?): Int{
        if (l1 == l2){
            return menor(l1, l2?.prox)
        }
        if (l2 == null){
            return l1!!.valor
        }
        if (l1 == null){
            return l2.valor
        }
        if (l1.valor < l2.valor){
            return menor(l1, l2.prox)
        } else {
            return menor(l1.prox, l2)
        }
        
    }
    
    fun removerUltimo(l: Lista<T>?): Lista<T>? {
    if (l?.prox == null) {
        return null
    } else {
        return Lista(l.valor, removerUltimo(l.prox))
    }
}
    
    fun removerRepetido(l1:Lista<T>?, l2:Lista<T>?): Lista<T>?{
        if(l1 == null){
            return null
        }
        if(l2 == null){
            return null
        }
        return Lista(l1.valor, removerRepetido(removerValor(l1.valor, l1), removerValor(l1.valor, l1)))
    }
 
 	fun inverte (l1: Lista<T>?, l2: Lista<T>?): Lista<T>?{
        if(l1 == null){
            return null
        }else if(l1.prox == null){
            return Lista(l1.valor, inverte(removerUltimo(l2), removerUltimo(l2)))
        } else {
            return inverte(l1.prox, l2)
        }
    }
    
    fun intercala(l1: Lista<T>?, l2: Lista<T>?): Lista<T>?{
         if (l1 == null){
             return l2
         } else if (l2 == null){
             return l1
         } else {
             return Lista(l1.valor, intercala(l2, l1.prox))
         }
         
     } 
    
    fun insereOrdenada(v: Int, l: Lista<Int>?): Lista<Int>?{
        if (l == null){
            return null
        }
        
        if (v <= l.valor){
            return Lista(v, l)
        } else if (v > l.valor && l.prox == null){
            return Lista(l.valor, Lista(v, null))
        } else if (v >= l.valor && v < l.prox!!.valor){
            return Lista(l.valor, Lista(v, l.prox))
        } else {
            return Lista(l.valor, insereOrdenada(v, l.prox))
        }
           
    }
 
}


fun main() {
    
    val lista = Lista(1,Lista(2,(Lista(3,(Lista(5, Lista(6, null)))))))
    
    val pertence = lista.pertence(3, lista)
    println("3 pertence a lista? $pertence \n")
    
    val nElementos = lista.nElementos(lista)
    println("A lista tem $nElementos elementos \n")
    
    val enesimo = lista.enesimo(2, lista)
    print("o enesimo termo e: $enesimo \n\n")
    
    val contaOcorrencias = lista.contaOcorrencias(3, lista)
    println("A lista possui $contaOcorrencias ocorrencias do numero 3\n")
    
    val unicaOcorrencia = lista.unicaOcorrencia(3, lista)
    println("3 possui apenas uma ocorrencia? $unicaOcorrencia\n")
    
    val maior = lista.maior(lista, lista)
    println("O maior numero da lista e: $maior\n")
    
    val maioresQue = lista.maioresQue(3, lista)
    print("Na lista, os valores maiores que 3 sao: ")
    lista.imprime(maioresQue)
    println("\n")
    
    val concatenar = lista.concatenar(lista, lista)
    print("Concatenando a lista com ela mesma, fica: ")
    concatenar?.imprime(concatenar)
    println("\n")
    
    val removerPrimeiro = lista.removerPrimeiro(4, lista)
    print("Removendo a primeira ocorrencia na lista, fica: ")
    removerPrimeiro?.imprime(removerPrimeiro)
    println("\n")
    
    val removerUltimo = lista.removerUltimo(lista)
    print("A lista sem o ultimo digito eh: ")
   	removerUltimo?.imprime(removerUltimo)
    println("\n")
    
    val removerRepetido = lista.removerRepetido(lista, lista)
    print("Removendo os valores repetidos de l1 fica: ")
    removerRepetido?.imprime(removerRepetido)
    println("\n")
    
    val inverte = lista.inverte(lista, lista)
    print("Invertendo lista fica: ")
    inverte?.imprime(inverte)
    println("\n")
    
   	val intercala = lista.intercala(lista, lista)
   	print("Intercalando as listas 1 e 2: ")
   	intercala?.imprime(intercala)
    println("\n")
    
    val menor = lista.menor(lista, lista)
    println("O menor numero da lista e: $menor")
    val removerMenor = lista.removerValor(menor, lista)
    print("A lista sem o menor valor fica: ")
    removerMenor?.imprime(removerMenor)
    println("\n")
    
    val insereOrdenada = lista.insereOrdenada(4, lista)
    insereOrdenada?.imprime(insereOrdenada)
}


