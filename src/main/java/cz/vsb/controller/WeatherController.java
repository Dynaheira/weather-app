package cz.vsb.controller;

import cz.vsb.City;
import cz.vsb.connector.WeatherApiConnector;
import cz.vsb.dto.WeatherDto;
import cz.vsb.service.WeatherService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WeatherController {
    @CrossOrigin
    @RequestMapping({"/weather","/weather/"})
    public List<WeatherDto> getWeather(){
        List<WeatherDto> weatherList = new ArrayList<>();
        City cityEnum;
        for(City city : City.values()){
            cityEnum = City.valueOf(city.toString());
            weatherList.add(getWeatherForCity(cityEnum.name()));
        }
//        WeatherService service = new WeatherService();
//        for (City city : City.values()) {
//            weatherList.add(service.getWeatherForCity(city));
//        }
        return weatherList;
    }
    @CrossOrigin
    @RequestMapping("/weather/{city}")
    public WeatherDto getWeatherForCity(@PathVariable("city") String city){
        City cityEnum = City.valueOf(city.toUpperCase());
        WeatherService weatherService = new WeatherService();
        return weatherService.getWeatherForCity(cityEnum);
    }
}
