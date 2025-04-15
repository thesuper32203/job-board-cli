package org.example.jobapp.api;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;

public class AdzunaClient {

    private String URL;
    public AdzunaApiKey ad = new AdzunaApiKey();

    //stores the url
    public AdzunaClient(String job){
        //replaces spaces with plus sign allowing ability to read white spaces
        System.out.println(ad.getId()+" " + ad.getKey());
        job.replaceAll(" ", "+");
        URL ="https://api.adzuna.com/v1/api/jobs/us/search/1?app_id="+ad.getId()+"&app_key="+ad.getKey()+"&results_per_page=5&title_only=cashier";


    }
    public JSONArray getJobListings(AdzunaClient url) {

        try {

            // 1. fetch the api response based on api link
            HttpURLConnection client = fetchApiResponse(url);

            //check for response status
            //200 means that the connection was a success
            if(client.getResponseCode() != 200){
                System.out.println("Error! Could not connect to api");
                throw new RuntimeException();
            }

            // 2. read the response and convert store string type
            String response = readApiResponse(client);

            // 3. parse the string into a json object
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(response);

            // 4. retrieve array of job listings
            JSONArray jobListings = (JSONArray) jsonObject.get("results");

            return jobListings;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void displayListings(JSONArray jobArray){

        for(int i = 0; i < jobArray.size(); i++){
            JSONObject job = (JSONObject) jobArray.get(i);
            System.out.println("Title " + (String) job.get("description").toString());
            System.out.println("URL " + (String) job.get("redirect_url"));
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

    public String readApiResponse(HttpURLConnection api){
        try{
            //create a string builder to store the resulting json data
            StringBuilder resultJson = new StringBuilder();
            //create a scanner to read from the InputStream of the HttpURLConnection
            Scanner scan = new Scanner(api.getInputStream());
            //loop through each line in the response and append it to the StringBuilder
            while(scan.hasNext()){
                //read and append the current line to the StringBuilder
                resultJson.append(scan.nextLine());
            }
            //close the sacnner to release resources associate with it
            scan.close();
            return resultJson.toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getURL(){
        return URL;
    }
}
