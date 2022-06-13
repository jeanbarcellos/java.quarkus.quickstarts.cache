package org.acme.cache.resources;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.acme.cache.entities.WeatherForecast;
import org.acme.cache.services.WeatherForecastService;

@Path("/weather")
public class WeatherForecastResource {

    @Inject
    WeatherForecastService service;

    @GET
    public WeatherForecast getForecast(
            @PathParam("city") String city,
            @PathParam("daysInFuture") long daysInFuture) {
        long executionStart = System.currentTimeMillis();
        List<String> dailyForecasts = Arrays.asList(
                service.getDailyForecast(LocalDate.now().plusDays(daysInFuture), city),
                service.getDailyForecast(LocalDate.now().plusDays(daysInFuture + 1L), city),
                service.getDailyForecast(LocalDate.now().plusDays(daysInFuture + 2L), city));
        long executionEnd = System.currentTimeMillis();
        return new WeatherForecast(dailyForecasts, executionEnd - executionStart);
    }
}