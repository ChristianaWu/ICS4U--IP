/*
Christiana Wu  
Assignement 3 - problem 3a
Jan 28, 2019 
will draw out a pattern using dollar signs and starts 
input nothing and output the a pattern
*/
public static void main (String[] args){
  int rows = 7;
  int sStar = 0;
  for (int row = 0; row<=6; row++){
    for (int col = 1; col<=28; col++){ //<>//
      if (col>sStar && col<= (sStar+ rows) || col > (28-(sStar + rows)) && col<=(28-sStar)){
        print ("$");
      } else {
        print ("*");
      }
  }
    print ("\n");
    rows--;
    sStar+=2;
  }
}
