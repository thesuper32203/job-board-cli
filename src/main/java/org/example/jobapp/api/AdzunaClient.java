package org.example.jobapp.api;

import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AdzunaClient {

    private String URL;

    public AdzunaClient(String job){
        URL = "http://api.adzuna.com/v1/api/jobs/gb/search/1?app_id=" +
                {YOUR API ID}&app_key={YOUR API KEY}&results_per_page=20&what=javascript%20developer&content-type=application/json"
    }
    public void displayJobListings() {


        HttpURLConnection client = new HttpURLConnection();


    }
}
