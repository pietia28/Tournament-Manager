package pl.pg.tmanager.integration.weather.accuweather;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/weathers")
class WeatherController {
    private final String uri =
            "http://dataservice.accuweather.com//locations/v1/cities/geoposition/search?apikey=kQ6nV61oFq1miq6573a165Rqcor2VXKL&q=52.17,20.805";

}
