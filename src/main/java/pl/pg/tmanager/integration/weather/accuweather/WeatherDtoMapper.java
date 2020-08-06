package pl.pg.tmanager.integration.weather.accuweather;

public class WeatherDtoMapper {
    private WeatherDtoMapper() {
    }

    public static Weather DtoToEntity(WeatherDto weatherDto) {
        return new Weather().setId(weatherDto.getId())
                .setDate(weatherDto.getDate())
                .setTemperature(weatherDto.getTemperature());
    }

    public static WeatherDto EntityToDto(Weather weather) {
        return new WeatherDto().setId(weather.getId())
                .setDate(weather.getDate())
                .setTemperature(weather.getTemperature());
    }
}
