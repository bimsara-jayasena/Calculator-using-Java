package org.example;


import java.util.Scanner;

public class Calculater {

   public Calculater(){
       go();
   }
   public void go(){
       int answer=0;
       int res=0;
       int x=1;
       String action=null;
       System.out.print("prompt: ");
       Scanner scanner=new Scanner(System.in);
       String prompt=scanner.nextLine();
       String[] parts = prompt.split("(?<=\\+|\\*)|(?<=\\()|(?<=\\d)(?=\\+\\*)|(?<=\\+|\\*)(?=\\d)|(?=\\))|(?=\\+|\\*)");
       System.out.println("Length: "+parts.length);
       for (int i = 0; i < parts.length; i++) {
           if(parts[i].equals("(")){

               action=parts[x+1];

               while (!parts[x].equals(")")){

                    if(action.equals("+")){
                        if(!parts[x].equals("+")){
                            answer+=Integer.parseInt(parts[x]);
                            System.out.println(parts[x]);
                        }
                       }
                       x++;
                       i++;

                   }
           }
           x+=3;
           i+=2;
           if(parts[i].equals("*")){

               action=parts[x+1];

               while (!parts[x].equals(")")){

                   if(action.equals("+")) {
                       if (!parts[x].equals("+")) {
                           res += Integer.parseInt(parts[x]);

                       }
                   }
                   x++;
                   i++;

               }
               answer*=res;
           }
           break;








       }
       System.out.println("Answer is: "+answer);

   }
    public static void main(String[] args){
       Calculater c=new Calculater();
    }






}
