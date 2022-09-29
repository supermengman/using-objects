package com.nighthawk.spring_portfolio.hacks.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // annotation to create a RESTful web services
@RequestMapping("/api/weather")  //prefix of API
public class WeatherApiController {
    private JSONObject body; //last run result
    private HttpStatus status; //last run status
    Long last_run = null; //last run day of month

    // GET Covid 19 Stats
    @GetMapping("/currentWeather")   //added to end of prefix as endpoint
    public ResponseEntity<JSONObject> getCovid() {

        //calls API once a day, sets body and status properties
        Long currentTime = System.currentTimeMillis()/(1000*60);
        if (last_run == null || (currentTime - last_run)>5)
        {
            try {  //APIs can fail (ie Internet or Service down)
                
                //RapidAPI header
                HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://weatherapi-com.p.rapidapi.com/current.json?q=209.66.205.197"))
                    .header("X-RapidAPI-Key", "0fb4bb4059msh8489d467f79e14ep1d57f9jsnd0d67fb163e6")
                    .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();


                //RapidAPI request and response
                HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

                //JSONParser extracts text body and parses to JSONObject
                this.body = (JSONObject) new JSONParser().parse(response.body());
                this.status = HttpStatus.OK;  //200 success
                this.last_run = currentTime;
            }
            catch (Exception e) {  //capture failure info
                HashMap<String, String> status = new HashMap<>();
                status.put("status", "RapidApi failure: " + e);

                //Setup object for error
                this.body = (JSONObject) status;
                this.status = HttpStatus.INTERNAL_SERVER_ERROR; //500 error
                this.last_run = null;
            }
        }

        //return JSONObject in RESTful style
        return new ResponseEntity<>(body, status);
    }
}