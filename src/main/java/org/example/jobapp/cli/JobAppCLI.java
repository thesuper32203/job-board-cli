package org.example.jobapp.cli;

import org.example.jobapp.api.AdzunaClient;
import org.json.simple.JSONArray;

import java.util.Scanner;

public class JobAppCLI
{
    public static void main( String[] args )
    {

        try (Scanner scan = new Scanner(System.in)) {
            //prompts user to enter job name
            System.out.println("Enter job you are looking for");
            String job =  "cashier"; //scan.nextLine();//stores job user is looking for
            AdzunaClient findJob = new AdzunaClient(job);
            JSONArray listing = new JSONArray();
            listing = findJob.getJobListings(findJob);
            findJob.displayListings(listing);
        }

    }
}
