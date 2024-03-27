fun cont(s:String, aux1: Int ): Int{
    

    if(aux1 < 0 ){
        return 0
    }
    
   	else if( (s[aux1] == 'a')||(s[aux1] == 'e')||(s[aux1] == 'i')||(s[aux1] == 'o')||(s[aux1] == 'u') ){
        return 1+ cont(s,aux1-1)
    }
    else{
        return 0 + cont(s,aux1-1)
    }
    
    
}



fun main() {
   val a = "ddasd"
   //cont(a,a.length-1)
   print(cont(a,a.length-1))
}