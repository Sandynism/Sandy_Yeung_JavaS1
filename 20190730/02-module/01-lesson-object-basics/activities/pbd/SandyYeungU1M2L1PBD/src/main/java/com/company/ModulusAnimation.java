package com.company;

public class ModulusAnimation
{
    public static void main( String[] args ) throws Exception
    {
        for ( int i=0; i<80; i++ )
        {
            if ( i%10 == 0 )
                System.out.print(" _______       __\n");
            else if ( i%10 == 1 )
                System.out.print("/   ------.   / ._`_\n");
            else if ( i%10 == 2 )
                System.out.print("|  /         ~--~    \\\n");
            else if ( i%10 == 3 )
                System.out.print("| |             __    `.____________________ _^-----^\n");
            else if ( i%10 == 4 )
                System.out.print("| |  I=|=======/--\\=========================| o o o |\n");
            else if ( i%10 == 5 )
                System.out.print("\\ |  I=|=======\\__/=========================|_o_o_o_|\n");
            else if ( i%10 == 6 )
                System.out.print(" \\|                   /  \n");
            else if ( i%10 == 7 )
                System.out.print(" \\       .---.    .\n");
            else if ( i%10 == 8 )
                System.out.print(" -----'     ~~''\n");
            else if ( i%10 == 9 )
                System.out.print("sandy\n");
            Thread.sleep(200);
        }

    }
}

//n this program, you'll use a loop to draw a simple ASCII-based animation on the screen, and you will use modulus (%) to determine which frame of the animation to show.

