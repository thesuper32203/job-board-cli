package org.example.jobapp.api;

import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AdzunaClient {

    private String URL;
    private AdzunaApiKey ad;

    //stores the url
    public AdzunaClient(String job){

        //replaces spaces with plus sign allowing ability to read white spaces
        job.replaceAll(" ", "+");

        URL ="http://api.adzuna.com/v1/api/jobs/gb/search/1?app_id={"
                + ad.getId()+
                "}&app_key={" +
                ad.getKey() +
                "}&results_per_page=20&what=" + job + "&content-type=application/json";

    }
    public void displayJobListings() {


        HttpURLConnection client = new HttpURLConnection();


    }
}
