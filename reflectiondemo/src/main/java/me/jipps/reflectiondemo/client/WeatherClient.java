package me.jipps.reflectiondemo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "weatherClient", url = "/v1/weather")
public interface WeatherClient {

    @RequestMapping(method = RequestMethod.GET, value = "/today")
    Map getTodayWeather(@RequestParam("city") String city);
}
