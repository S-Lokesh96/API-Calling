//package sample1;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PutApiCall {
    public static void main(String[] args) {
        String apiUrl ="https://jsonplaceholder.typicode.com/posts/1";

        //creating an instance of httpClient
        HttpClient httpClient = HttpClient.newHttpClient();
        String header ="{\n" +
                "    \"title\": \"foo\",\n" +
                "    \"body\": \"bar\",\n" +
                "    \"userId\": 1\n" +
                "  }";
        //creating an instance of httpRequest with the api URL

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type","application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(header))
                .build();
        try{
            HttpResponse<String > httpResponse = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());

            int statuscode = httpResponse.statusCode();
            System.out.println("staus code: "+ statuscode);

            String responseBody = httpResponse.body();
            System.out.println("api response: "+responseBody);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
