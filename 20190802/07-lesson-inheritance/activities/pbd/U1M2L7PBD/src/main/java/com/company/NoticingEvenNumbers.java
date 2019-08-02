package com.company;

public class NoticingEvenNumbers {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.printf(i + " <%n");
            } else {
                System.out.printf(i + "%n");
            }
        }
    }
}

//Noticing Even Numbers
//Write a program that uses a for loop to display all the numbers from 1 to 20, marking those which are even (divisible by two). It should use modulus by 2: if the remainder is zero, it's divisible by 2.
//
//This means you'll need an if statement inside the loop.
//
//for ( <stuff> )
//{
//    if ( <something with modulus> )
//    {
//        System.out.println( <something> );
//    }
//    else
//    {
//        System.out.println( <something different> );
//    }
//}
//1
//2 <
//3
//4 <
//5
//6 <
//7
//8 <
//9
//10 <
//11
//12 <
//13
//14 <
//15
//16 <
//17
//18 <
//19
//20 <