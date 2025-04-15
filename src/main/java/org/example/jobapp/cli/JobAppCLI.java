package org.example.jobapp.cli;

import java.util.Scanner;

public class JobAppCLI
{
    public static void main( String[] args )
    {

        try (Scanner scan = new Scanner(System.in)) {
            //prompts user to enter job name
            System.out.println("Enter job you are looking for");
            String job = scan.nextLine();//stores job user is looking for

        }

    }
}
