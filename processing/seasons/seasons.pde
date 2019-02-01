/* 
Christiana Wu  
20767703
Assignement 3 - problem 2 
Jan 28 ,2019 
Tells us what season each date is 
input a month and day then out put what season tat date is coorisponding to
*/

public static void  main(String [] args) {
int months = 2;
int days = 32;

  print (season(months, days));
}

public static String season(int months, int days){
  String season = null;
  if (months <= 12 && days>=16 && days<=31 || months <=3 && days <= 15 && days<=1){
    season = "Winter";
  }else if (months <= 6 && days<= 15 && days >=1 || months >=3 && days >= 16 && days <= 31){
    season = "Spring";
  }else if (months <= 6 && days>= 16 && days <= 31|| months <=9 && days <= 15 && days >= 1){
    season = "Summer";
  }else if (months >= 9 && days  >=16 && days <= 31 || months <=12 && days <= 15 && days >=1){
    season = "Fall";
  }
  return season;
}
