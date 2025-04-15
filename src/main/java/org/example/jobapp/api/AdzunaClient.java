package org.example.jobapp.api;

import java.io.IOException;
import java.net.MalformedURLException;
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
    public void displayJobListings(AdzunaClient url) {

        try {

            //fetch the api response based on api link
            HttpURLConnection client = fetchApiResponse(url);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public HttpURLConnection fetchApiResponse(AdzunaClient api){

        try{

            //takes the url stored in adzunaClient object
            URL url = new URL(api.getURL());
            //attempting to create connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //set request method to GET
            conn.setRequestMethod("GET");

            return conn;

        }catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }//could not make connection

    }

    public String getURL(){
        return URL;
    }
}
