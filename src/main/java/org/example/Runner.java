package org.example;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String name=s.nextLine();
        if(name.matches("^[a-z]{5}$")){
            System.out.println("Valid");
        }
        else{
            System.out.println("Invalid");
        }



    }
}
