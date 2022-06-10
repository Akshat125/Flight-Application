package apis;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import utils.api.weather.WeatherAPI;

public class WeathersAPIMockUp implements WeathersAPI {

    // Source: https://openweathermap.org/
    // key = ac41346439bcc8dd543aedd632306b4c
    // https://api.openweathermap.org/data/2.5/forecast?lat=48.353004&lon=11.790143&unit=metric&cnt=40&lang=de&appid=ac41346439bcc8dd543aedd632306b4c

    private WebClient webClient;
    private String mockedData;

    public WeathersAPIMockUp() {
        webClient = WebClient.builder().baseUrl("https://api.openweathermap.org/data/2.5/forecast?").defaultHeader(MediaType.APPLICATION_JSON_VALUE).build();
        mockedData = "{\"cod\":\"200\",\"message\":0,\"cnt\":40,\"list\":[{\"dt\":1654819200,\"main\":{\"temp\":285.47,\"feels_like\":285.19,\"temp_min\":282.73,\"temp_max\":285.47,\"pressure\":1022,\"sea_level\":1022,\"grnd_level\":969,\"humidity\":93,\"temp_kf\":2.74},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":3.31,\"deg\":255,\"gust\":6.15},\"visibility\":10000,\"pop\":0.03,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2022-06-10 00:00:00\"},{\"dt\":1654830000,\"main\":{\"temp\":284.21,\"feels_like\":283.83,\"temp_min\":281.7,\"temp_max\":284.21,\"pressure\":1022,\"sea_level\":1022,\"grnd_level\":970,\"humidity\":94,\"temp_kf\":2.51},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"Mäßig bewölkt\",\"icon\":\"03n\"}],\"clouds\":{\"all\":26},\"wind\":{\"speed\":3.07,\"deg\":257,\"gust\":5.25},\"visibility\":10000,\"pop\":0.03,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2022-06-10 03:00:00\"},{\"dt\":1654840800,\"main\":{\"temp\":285.45,\"feels_like\":284.98,\"temp_min\":285.44,\"temp_max\":285.45,\"pressure\":1023,\"sea_level\":1023,\"grnd_level\":971,\"humidity\":86,\"temp_kf\":0.01},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"Mäßig bewölkt\",\"icon\":\"03d\"}],\"clouds\":{\"all\":39},\"wind\":{\"speed\":3,\"deg\":274,\"gust\":4.11},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-10 06:00:00\"},{\"dt\":1654851600,\"main\":{\"temp\":290.2,\"feels_like\":289.71,\"temp_min\":290.2,\"temp_max\":290.2,\"pressure\":1024,\"sea_level\":1024,\"grnd_level\":972,\"humidity\":67,\"temp_kf\":0},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"Ein paar Wolken\",\"icon\":\"02d\"}],\"clouds\":{\"all\":12},\"wind\":{\"speed\":2.37,\"deg\":314,\"gust\":2.55},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-10 09:00:00\"},{\"dt\":1654862400,\"main\":{\"temp\":292.69,\"feels_like\":292.21,\"temp_min\":292.69,\"temp_max\":292.69,\"pressure\":1023,\"sea_level\":1023,\"grnd_level\":971,\"humidity\":58,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"Leichter Regen\",\"icon\":\"10d\"}],\"clouds\":{\"all\":16},\"wind\":{\"speed\":2.03,\"deg\":344,\"gust\":2.21},\"visibility\":10000,\"pop\":0.2,\"rain\":{\"3h\":0.13},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-10 12:00:00\"},{\"dt\":1654873200,\"main\":{\"temp\":293.02,\"feels_like\":292.58,\"temp_min\":293.02,\"temp_max\":293.02,\"pressure\":1022,\"sea_level\":1022,\"grnd_level\":971,\"humidity\":58,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"Überwiegend bewölkt\",\"icon\":\"04d\"}],\"clouds\":{\"all\":74},\"wind\":{\"speed\":1.51,\"deg\":15,\"gust\":1.94},\"visibility\":10000,\"pop\":0.01,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-10 15:00:00\"},{\"dt\":1654884000,\"main\":{\"temp\":290.89,\"feels_like\":290.6,\"temp_min\":290.89,\"temp_max\":290.89,\"pressure\":1023,\"sea_level\":1023,\"grnd_level\":971,\"humidity\":72,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"Überwiegend bewölkt\",\"icon\":\"04d\"}],\"clouds\":{\"all\":61},\"wind\":{\"speed\":1.47,\"deg\":14,\"gust\":1.57},\"visibility\":10000,\"pop\":0.04,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-10 18:00:00\"},{\"dt\":1654894800,\"main\":{\"temp\":286.2,\"feels_like\":285.68,\"temp_min\":286.2,\"temp_max\":286.2,\"pressure\":1024,\"sea_level\":1024,\"grnd_level\":971,\"humidity\":81,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01n\"}],\"clouds\":{\"all\":8},\"wind\":{\"speed\":0.67,\"deg\":106,\"gust\":0.87},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2022-06-10 21:00:00\"},{\"dt\":1654905600,\"main\":{\"temp\":284.75,\"feels_like\":284.21,\"temp_min\":284.75,\"temp_max\":284.75,\"pressure\":1024,\"sea_level\":1024,\"grnd_level\":971,\"humidity\":86,\"temp_kf\":0},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"Ein paar Wolken\",\"icon\":\"02n\"}],\"clouds\":{\"all\":17},\"wind\":{\"speed\":1.41,\"deg\":182,\"gust\":1.41},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2022-06-11 00:00:00\"},{\"dt\":1654916400,\"main\":{\"temp\":283.84,\"feels_like\":283.26,\"temp_min\":283.84,\"temp_max\":283.84,\"pressure\":1024,\"sea_level\":1024,\"grnd_level\":971,\"humidity\":88,\"temp_kf\":0},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"Ein paar Wolken\",\"icon\":\"02n\"}],\"clouds\":{\"all\":15},\"wind\":{\"speed\":1.04,\"deg\":216,\"gust\":1.07},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2022-06-11 03:00:00\"},{\"dt\":1654927200,\"main\":{\"temp\":288.09,\"feels_like\":287.7,\"temp_min\":288.09,\"temp_max\":288.09,\"pressure\":1024,\"sea_level\":1024,\"grnd_level\":972,\"humidity\":79,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01d\"}],\"clouds\":{\"all\":9},\"wind\":{\"speed\":0.71,\"deg\":209,\"gust\":0.7},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-11 06:00:00\"},{\"dt\":1654938000,\"main\":{\"temp\":292.89,\"feels_like\":292.56,\"temp_min\":292.89,\"temp_max\":292.89,\"pressure\":1024,\"sea_level\":1024,\"grnd_level\":973,\"humidity\":63,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":1.06,\"deg\":64,\"gust\":1.23},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-11 09:00:00\"},{\"dt\":1654948800,\"main\":{\"temp\":295.22,\"feels_like\":294.84,\"temp_min\":295.22,\"temp_max\":295.22,\"pressure\":1023,\"sea_level\":1023,\"grnd_level\":972,\"humidity\":52,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":1.13,\"deg\":34,\"gust\":1.3},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-11 12:00:00\"},{\"dt\":1654959600,\"main\":{\"temp\":295.65,\"feels_like\":295.26,\"temp_min\":295.65,\"temp_max\":295.65,\"pressure\":1023,\"sea_level\":1023,\"grnd_level\":972,\"humidity\":50,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01d\"}],\"clouds\":{\"all\":4},\"wind\":{\"speed\":0.36,\"deg\":49,\"gust\":1.44},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-11 15:00:00\"},{\"dt\":1654970400,\"main\":{\"temp\":292.96,\"feels_like\":292.77,\"temp_min\":292.96,\"temp_max\":292.96,\"pressure\":1023,\"sea_level\":1023,\"grnd_level\":972,\"humidity\":68,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01d\"}],\"clouds\":{\"all\":2},\"wind\":{\"speed\":1.15,\"deg\":192,\"gust\":1.38},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-11 18:00:00\"},{\"dt\":1654981200,\"main\":{\"temp\":288.42,\"feels_like\":287.88,\"temp_min\":288.42,\"temp_max\":288.42,\"pressure\":1024,\"sea_level\":1024,\"grnd_level\":972,\"humidity\":72,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":1.61,\"deg\":193,\"gust\":1.66},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2022-06-11 21:00:00\"},{\"dt\":1654992000,\"main\":{\"temp\":286.53,\"feels_like\":286.01,\"temp_min\":286.53,\"temp_max\":286.53,\"pressure\":1024,\"sea_level\":1024,\"grnd_level\":972,\"humidity\":80,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":1.73,\"deg\":176,\"gust\":1.79},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2022-06-12 00:00:00\"},{\"dt\":1655002800,\"main\":{\"temp\":285.14,\"feels_like\":284.61,\"temp_min\":285.14,\"temp_max\":285.14,\"pressure\":1024,\"sea_level\":1024,\"grnd_level\":971,\"humidity\":85,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01n\"}],\"clouds\":{\"all\":2},\"wind\":{\"speed\":1.71,\"deg\":175,\"gust\":1.74},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2022-06-12 03:00:00\"},{\"dt\":1655013600,\"main\":{\"temp\":289.53,\"feels_like\":289.16,\"temp_min\":289.53,\"temp_max\":289.53,\"pressure\":1024,\"sea_level\":1024,\"grnd_level\":972,\"humidity\":74,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01d\"}],\"clouds\":{\"all\":8},\"wind\":{\"speed\":1.57,\"deg\":139,\"gust\":2.08},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-12 06:00:00\"},{\"dt\":1655024400,\"main\":{\"temp\":294.68,\"feels_like\":294.51,\"temp_min\":294.68,\"temp_max\":294.68,\"pressure\":1023,\"sea_level\":1023,\"grnd_level\":972,\"humidity\":62,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01d\"}],\"clouds\":{\"all\":8},\"wind\":{\"speed\":2.25,\"deg\":114,\"gust\":2.85},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-12 09:00:00\"},{\"dt\":1655035200,\"main\":{\"temp\":297.24,\"feels_like\":297.09,\"temp_min\":297.24,\"temp_max\":297.24,\"pressure\":1021,\"sea_level\":1021,\"grnd_level\":971,\"humidity\":53,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01d\"}],\"clouds\":{\"all\":4},\"wind\":{\"speed\":1.97,\"deg\":95,\"gust\":1.92},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-12 12:00:00\"},{\"dt\":1655046000,\"main\":{\"temp\":297.65,\"feels_like\":297.51,\"temp_min\":297.65,\"temp_max\":297.65,\"pressure\":1020,\"sea_level\":1020,\"grnd_level\":970,\"humidity\":52,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01d\"}],\"clouds\":{\"all\":7},\"wind\":{\"speed\":1.11,\"deg\":20,\"gust\":1.29},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-12 15:00:00\"},{\"dt\":1655056800,\"main\":{\"temp\":294.89,\"feels_like\":294.87,\"temp_min\":294.89,\"temp_max\":294.89,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":968,\"humidity\":67,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01d\"}],\"clouds\":{\"all\":7},\"wind\":{\"speed\":0.56,\"deg\":79,\"gust\":0.99},\"visibility\":10000,\"pop\":0.01,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-12 18:00:00\"},{\"dt\":1655067600,\"main\":{\"temp\":290.29,\"feels_like\":289.91,\"temp_min\":290.29,\"temp_max\":290.29,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":968,\"humidity\":71,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01n\"}],\"clouds\":{\"all\":4},\"wind\":{\"speed\":1.27,\"deg\":220,\"gust\":1.59},\"visibility\":10000,\"pop\":0.22,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2022-06-12 21:00:00\"},{\"dt\":1655078400,\"main\":{\"temp\":288.07,\"feels_like\":288.02,\"temp_min\":288.07,\"temp_max\":288.07,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":967,\"humidity\":92,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"Leichter Regen\",\"icon\":\"10n\"}],\"clouds\":{\"all\":42},\"wind\":{\"speed\":2.22,\"deg\":288,\"gust\":2.3},\"visibility\":10000,\"pop\":0.51,\"rain\":{\"3h\":0.76},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2022-06-13 00:00:00\"},{\"dt\":1655089200,\"main\":{\"temp\":287.04,\"feels_like\":287.02,\"temp_min\":287.04,\"temp_max\":287.04,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":967,\"humidity\":97,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"Leichter Regen\",\"icon\":\"10n\"}],\"clouds\":{\"all\":86},\"wind\":{\"speed\":3.15,\"deg\":258,\"gust\":4.12},\"visibility\":9692,\"pop\":0.97,\"rain\":{\"3h\":1.26},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2022-06-13 03:00:00\"},{\"dt\":1655100000,\"main\":{\"temp\":289.1,\"feels_like\":289.07,\"temp_min\":289.1,\"temp_max\":289.1,\"pressure\":1021,\"sea_level\":1021,\"grnd_level\":969,\"humidity\":89,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"Leichter Regen\",\"icon\":\"10d\"}],\"clouds\":{\"all\":55},\"wind\":{\"speed\":4.42,\"deg\":279,\"gust\":6.87},\"visibility\":10000,\"pop\":0.99,\"rain\":{\"3h\":1.39},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-13 06:00:00\"},{\"dt\":1655110800,\"main\":{\"temp\":291.48,\"feels_like\":291.2,\"temp_min\":291.48,\"temp_max\":291.48,\"pressure\":1022,\"sea_level\":1022,\"grnd_level\":970,\"humidity\":70,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"Überwiegend bewölkt\",\"icon\":\"04d\"}],\"clouds\":{\"all\":64},\"wind\":{\"speed\":4.91,\"deg\":288,\"gust\":6.46},\"visibility\":10000,\"pop\":0.24,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-13 09:00:00\"},{\"dt\":1655121600,\"main\":{\"temp\":293.96,\"feels_like\":293.48,\"temp_min\":293.96,\"temp_max\":293.96,\"pressure\":1021,\"sea_level\":1021,\"grnd_level\":970,\"humidity\":53,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"Mäßig bewölkt\",\"icon\":\"03d\"}],\"clouds\":{\"all\":42},\"wind\":{\"speed\":5.37,\"deg\":298,\"gust\":7.06},\"visibility\":10000,\"pop\":0.14,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-13 12:00:00\"},{\"dt\":1655132400,\"main\":{\"temp\":293.91,\"feels_like\":293.48,\"temp_min\":293.91,\"temp_max\":293.91,\"pressure\":1021,\"sea_level\":1021,\"grnd_level\":970,\"humidity\":55,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01d\"}],\"clouds\":{\"all\":7},\"wind\":{\"speed\":4.71,\"deg\":321,\"gust\":6.28},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-13 15:00:00\"},{\"dt\":1655143200,\"main\":{\"temp\":290.01,\"feels_like\":289.71,\"temp_min\":290.01,\"temp_max\":290.01,\"pressure\":1021,\"sea_level\":1021,\"grnd_level\":969,\"humidity\":75,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01d\"}],\"clouds\":{\"all\":4},\"wind\":{\"speed\":2.85,\"deg\":338,\"gust\":6.48},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-13 18:00:00\"},{\"dt\":1655154000,\"main\":{\"temp\":285.78,\"feels_like\":285.06,\"temp_min\":285.78,\"temp_max\":285.78,\"pressure\":1022,\"sea_level\":1022,\"grnd_level\":970,\"humidity\":75,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":0.73,\"deg\":269,\"gust\":1.09},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2022-06-13 21:00:00\"},{\"dt\":1655164800,\"main\":{\"temp\":284.34,\"feels_like\":283.6,\"temp_min\":284.34,\"temp_max\":284.34,\"pressure\":1022,\"sea_level\":1022,\"grnd_level\":969,\"humidity\":80,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":0.58,\"deg\":183,\"gust\":0.56},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2022-06-14 00:00:00\"},{\"dt\":1655175600,\"main\":{\"temp\":283.36,\"feels_like\":282.55,\"temp_min\":283.36,\"temp_max\":283.36,\"pressure\":1021,\"sea_level\":1021,\"grnd_level\":969,\"humidity\":81,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01n\"}],\"clouds\":{\"all\":5},\"wind\":{\"speed\":0.7,\"deg\":139,\"gust\":0.99},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2022-06-14 03:00:00\"},{\"dt\":1655186400,\"main\":{\"temp\":287.65,\"feels_like\":287.04,\"temp_min\":287.65,\"temp_max\":287.65,\"pressure\":1021,\"sea_level\":1021,\"grnd_level\":969,\"humidity\":72,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01d\"}],\"clouds\":{\"all\":6},\"wind\":{\"speed\":0.73,\"deg\":112,\"gust\":0.84},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-14 06:00:00\"},{\"dt\":1655197200,\"main\":{\"temp\":292.22,\"feels_like\":291.72,\"temp_min\":292.22,\"temp_max\":292.22,\"pressure\":1021,\"sea_level\":1021,\"grnd_level\":969,\"humidity\":59,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01d\"}],\"clouds\":{\"all\":6},\"wind\":{\"speed\":1.86,\"deg\":52,\"gust\":1.56},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-14 09:00:00\"},{\"dt\":1655208000,\"main\":{\"temp\":294.7,\"feels_like\":294.24,\"temp_min\":294.7,\"temp_max\":294.7,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":969,\"humidity\":51,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01d\"}],\"clouds\":{\"all\":4},\"wind\":{\"speed\":1.73,\"deg\":40,\"gust\":1.38},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-14 12:00:00\"},{\"dt\":1655218800,\"main\":{\"temp\":294.94,\"feels_like\":294.48,\"temp_min\":294.94,\"temp_max\":294.94,\"pressure\":1018,\"sea_level\":1018,\"grnd_level\":968,\"humidity\":50,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"Bedeckt\",\"icon\":\"04d\"}],\"clouds\":{\"all\":95},\"wind\":{\"speed\":1.41,\"deg\":7,\"gust\":1.8},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-14 15:00:00\"},{\"dt\":1655229600,\"main\":{\"temp\":292.54,\"feels_like\":292.26,\"temp_min\":292.54,\"temp_max\":292.54,\"pressure\":1018,\"sea_level\":1018,\"grnd_level\":967,\"humidity\":66,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"Überwiegend bewölkt\",\"icon\":\"04d\"}],\"clouds\":{\"all\":64},\"wind\":{\"speed\":0.59,\"deg\":17,\"gust\":0.84},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-06-14 18:00:00\"},{\"dt\":1655240400,\"main\":{\"temp\":287.44,\"feels_like\":286.91,\"temp_min\":287.44,\"temp_max\":287.44,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":967,\"humidity\":76,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Klarer Himmel\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":0.7,\"deg\":168,\"gust\":1.07},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2022-06-14 21:00:00\"}],\"city\":{\"id\":2925470,\"name\":\"Franzheim\",\"coord\":{\"lat\":48.353,\"lon\":11.7901},\"country\":\"DE\",\"population\":0,\"timezone\":7200,\"sunrise\":1654830724,\"sunset\":1654888359}}";
    }

    public WeatherAPI getWeatherByCoordinates(double lon, double lat) {
        // Munich Airport
        // lon = 11.790143;
        // lat = 48.353004;
        return WeathersAPI.jsonStringToJavaClass(mockedData);
    }
/*
    public static void main(String[] args) {
        WeatherAPIMockUp weatherAPIMockUp = new WeatherAPIMockUp();
        WeatherAPI weather = weatherAPIMockUp.getWeatherByCoordinates(0., 0.); // doesnt matter at mockup
        System.out.println("Weather at " + weather.getCity().getName() + " is " + weather.getList().get(0).getMain().getTemp() + "K");
    }

 */
}


