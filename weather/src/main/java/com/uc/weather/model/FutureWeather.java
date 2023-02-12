package com.uc.weather.model;

import lombok.Data;

import java.util.List;

@Data
public class FutureWeather {
    public Location location;
    public Forecast forecast;
    public static class Astro{
        public String sunrise;
        public String sunset;
        public String moonrise;
        public String moonset;
        public String moon_phase;
        public String moon_illumination;
    }

    public static class Condition{
        public String text;
        public String icon;
        public Integer code;
    }

    public static class Day{
        public Double maxtemp_c;
        public Double maxtemp_f;
        public Double mintemp_c;
        public Double mintemp_f;
        public Double avgtemp_c;
        public Double avgtemp_f;
        public Double maxwind_mph;
        public Double maxwind_kph;
        public Double totalprecip_mm;
        public Double totalprecip_in;
        public Double avgvis_km;
        public Double avgvis_miles;
        public Double avghumidity;
        public Condition condition;
        public Double uv;
    }

    public static class Forecast{
        public List<Forecastday> forecastday;
    }

    public static class Forecastday{
        public String date;
        public Integer date_epoch;
        public Day day;
        public Astro astro;
        public List<Hour> hour;
    }

    public static class Hour{
        public Integer time_epoch;
        public String time;
        public Double temp_c;
        public Double temp_f;
        public Integer is_day;
        public Condition condition;
        public Double wind_mph;
        public Double wind_kph;
        public Integer wind_degree;
        public String wind_dir;
        public Double pressure_mb;
        public Double pressure_in;
        public Double precip_mm;
        public Double precip_in;
        public Integer humidity;
        public Integer cloud;
        public Double feelslike_c;
        public Double feelslike_f;
        public Double windchill_c;
        public Double windchill_f;
        public Double heatindex_c;
        public Double heatindex_f;
        public Double dewpoint_c;
        public Double dewpoint_f;
        public Integer will_it_rain;
        public Integer chance_of_rain;
        public Integer will_it_snow;
        public Integer chance_of_snow;
        public Double vis_km;
        public Double vis_miles;
        public Double gust_mph;
        public Double gust_kph;
    }

    public static class Location{
        public String name;
        public String region;
        public String country;
        public Double lat;
        public Double lon;
        public String tz_id;
        public Integer localtime_epoch;
        public String localtime;
    }


   


}
