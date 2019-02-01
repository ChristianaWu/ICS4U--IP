/*
Christiana Wu
Tut 3 
20767703 
Jan 29, 2019 
Input nothing out put the pattern 
*/ 
public static void main (String [] args){
  printPattern();
}

public static void printPattern (){
  for (int row = 1; row <= 11; row++){
    for (int col = 1; col <= 28; col++){ 
      if (row % 3 == 0 && col%2 == 1){
        print ("<"); //<>//
      }else if (row % 3 == 0 && col%2 == 0){
        print(">");
      }else if (row % 2 == 1){ //<>//
        print ("="); //<>//
      }else if (row % 2 == 0 && row % 4 == 0){ //<>//
        if (col % 2 == 1 ){ //<>//
          print ("/"); //<>//
        }else{ //<>//
          print ("\\");
        }
      }else {
        if (col % 2 == 1 ){
          print ("\\");
        }else{
          print ("/");
        }
      }
    }
    println();
  }
}
