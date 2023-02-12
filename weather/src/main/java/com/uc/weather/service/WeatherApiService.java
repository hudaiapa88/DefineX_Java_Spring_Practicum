package com.uc.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uc.weather.exception.NotFountException;
import com.uc.weather.model.FutureWeather;
import com.uc.weather.model.Weather;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import javax.naming.ldap.PagedResultsControl;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@Service
@Slf4j
public class WeatherApiService {

    WeatherApi weatherApi;

    private static String API_KEY="1e3f1f0470864bedadf203204231102";
    private static String BASE_URL="http://api.weatherapi.com/v1/";

    private WeatherApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
     weatherApi=retrofit.create(WeatherApi.class);
    }

    public Weather getCurrent(String q){
        try {
            Response<Weather> response=weatherApi.getCurrent(API_KEY,q).execute();
            return response.body();
        } catch (IOException e) {
            throw new NotFountException("Hava durumu bulunamadı.");
        }
    }

    public FutureWeather getFuture(String q, LocalDate future) {
        try {
            Response<FutureWeather> response=weatherApi.getFuture(API_KEY,q,future).execute();
            return response.body();
        } catch (IOException e) {
            throw new NotFountException("Hava durumu bulunamadı.");
        }
    }

    public interface WeatherApi {

        @GET("current.json")
        Call<Weather> getCurrent(@Query("key") String key,@Query("q")String q);
        @GET("future.json")
        Call<FutureWeather> getFuture(@Query("key") String key,@Query("q")String q,@Query("dt")LocalDate future);
    }

}
