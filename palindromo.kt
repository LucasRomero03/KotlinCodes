fun cont(s:String, aux1: Int,cont:Int ): Int{
   

    if(aux1 < 0 ){
        return 0
    }
    
   	else if( s[aux1] == s[cont]  ){
        return 1+ cont(s,aux1-1,cont+1)
    }
    else{
        return 0 + cont(s,aux1-1,cont+1)
    }
    
    
}

fun  verifica(s:String,aux:Int,cont:Int):Boolean{
   val a = cont(s,aux,cont)
    if(a==s.length){
        return true
    }else{
        return false
    }
}

fun main() {
   val a = "arara"
   val b = "a"
   print(verifica(a,b.length-1,0))
}