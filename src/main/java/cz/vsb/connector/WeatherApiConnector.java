package cz.vsb.connector;

import cz.vsb.City;
import cz.vsb.dto.WeatherApiDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class WeatherApiConnector {
    //https://api.weatherapi.com/v1/current.json?key=fabd011297a6427c95c75153241906&q=Ostrava&aqi=no
    //http://api.weatherapi.com/v1/current.json?key=e5f49b056d054a869ab75027241906&q=Riga&aqi=no

    private static String baseUrl = "https://api.weatherapi.com/";
    private static String urlParametrs = "v1/current.json?key=";
    private static String apiKey = "e5f49b056d054a869ab75027241906";
    private  static String url = baseUrl + urlParametrs + apiKey + "&q=";

    public WeatherApiDto getWeatherForCity(City city){
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url+city);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<WeatherApiDto> response = template.getForEntity(uri, WeatherApiDto.class);
        return response.getBody();
    }
}
