package kopo.poly.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@RestController
public class RestTestController {

    @GetMapping("/apitest")
    public String callApiWithXml() {

        StringBuffer result = new StringBuffer();

        try {
            String apiUrl = "http://openapi.airport.co.kr/service/rest/AirportParking/airportparkingRT" +
                    "serviceKey=eOF6GnWVvldbBgvM8HdXTSg2a4ZjW6p90CAQUyGhEWDLEXWqJ6ZCW8VFscCnCbgfPxlbheQPn5zC1E5SP%2BzQOw%3D%3D" +
                    "&numOfRows=10" +
                    "&pageNo=4" +
                    "&type=xml";
            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;
            result.append("<xmp>");

            while((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine + "\n\r");
            }

            urlConnection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result + "</xmp>";
    }
}