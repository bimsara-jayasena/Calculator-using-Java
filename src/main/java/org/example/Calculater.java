package org.example;


import java.util.ArrayList;
import java.util.Scanner;

public class Calculater {
    ArrayList<Integer> numbers;

    int answer=0;

   public Calculater(){
       go();
   }
   public void go(){
       numbers=new ArrayList<>();


       int x=0;
       String innerAction=null;
       String action=null;
       System.out.print("prompt: ");
       Scanner scanner=new Scanner(System.in);
       String prompt=scanner.nextLine();
       String[] parts = prompt.split("(?<=\\+|\\*|\\-|\\/)|(?<=\\()|(?<=\\d)(?=\\+\\*)|(?<=\\+|\\*|\\-|\\/)(?=\\d)|(?=\\))|(?=\\+|\\*|\\-|\\/)");


           if(parts[0].equals("(")) {
                x=1;
                int y=0;
                action=parts[x+1];
                while (!parts[x].equals(")")){
                    if(!parts[x].equals(action)){
                        numbers.add(Integer.parseInt(parts[x]));
                    }
                    x++;
                    y++;

                }
              answer+=calculate(numbers,action);

                x=0;
               for (int i=y+2 ; i < parts.length; i++) {

                      action=parts[i];

                      if(parts[i+1].equals("(")) {

                          innerAction=parts[i+3];
                          numbers.clear();
                          while (!parts[i].equals(")")) {

                              if (i % 2 == 1 && !parts[i].equals(action)) {
                                  numbers.add(Integer.parseInt(parts[i]));

                              }
                              i++;
                          }
                          switch (action){
                              case "+"-> answer += calculate(numbers, innerAction);
                              case "-"-> answer -= calculate(numbers, innerAction);
                              case "*"-> answer *= calculate(numbers, innerAction);
                              case "/"-> answer /= calculate(numbers, innerAction);
                          }
                      }
                      else{
                          switch (action){
                              case "+"-> answer += Integer.parseInt(parts[i+1]);
                              case "-"-> answer -= Integer.parseInt(parts[i+1]);
                              case "*"-> answer *= Integer.parseInt(parts[i+1]);
                              case "/"-> answer /= Integer.parseInt(parts[i+1]);
                          }
                          break;

                      }
               }
       }
           else {
               int y=0;
               answer+=Integer.parseInt(parts[0]);
               for (int i=y+1 ; i < parts.length; i++) {

                   action=parts[i];
                   if(parts[i+1].equals("(")) {

                       innerAction=parts[i+3];
                       numbers.clear();
                       while (!parts[i].equals(")")) {

                           if (i % 2 == 1 && !parts[i].equals(action)) {
                               numbers.add(Integer.parseInt(parts[i]));

                           }
                           i++;
                       }


                       switch (action){
                           case "+"-> answer += calculate(numbers, innerAction);
                           case "-"-> answer -= calculate(numbers, innerAction);
                           case "*"-> answer *= calculate(numbers, innerAction);
                           case "/"-> answer /= calculate(numbers, innerAction);
                       }


                   }else{
                       switch (action){
                           case "+"-> answer += calculate(numbers, innerAction);
                           case "-"-> answer -= calculate(numbers, innerAction);
                           case "*"-> answer *= calculate(numbers, innerAction);
                           case "/"-> answer /= calculate(numbers, innerAction);
                       }
                       break;
                   }
               }
           }
       System.out.println("Answer: "+answer);
   }
   public int calculate(ArrayList<Integer> numbers,String action) {
       int total=0;
       for (int i : numbers) {
           if (action.equals("+")) {
               total += i;
           }
       }

       return total;

   }
    public static void main(String[] args){
       new Calculater();
    }
}
