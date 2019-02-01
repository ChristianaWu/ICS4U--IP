/*
Christiana Wu  
Assignement 3 - problem 3b
Jan 28, 2019 
will draw out a pattern using dollar signs and stars and is static when the height
(the # of rows is changed)
input heght (numRows) and output the a pattern
*/
public static void main (String[] args){
  printPattern (3);
  printPattern (5);

} //<>//

public static void printPattern (int numbRows){
  int rows = numbRows;
  int sStar = 0;
  for (int row = 0; row<=(numbRows-1); row++){
    for (int col = 1; col<=(numbRows*4); col++){
      if (col>sStar && col<= (sStar+ rows) || col > ((numbRows*4)-(sStar + rows)) && col<=((numbRows*4)-sStar)){
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
