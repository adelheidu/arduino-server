package arduino.server.api.controllers;

import arduino.server.api.ApiPaths;
import arduino.server.api.CommonApiResponses;
import arduino.server.api.model.DeviceConfiguration;
import arduino.server.api.model.Temperature;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.module.Configuration;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Методы для взаимодействия с МП")
public class MobileController {

    @Operation(summary = "Задание конфигурации на устройстве")
    @CommonApiResponses
    @PostMapping(ApiPaths.MOBILE_CONFIGURATION)
    public Configuration createConfig(@PathVariable String deviceId, @RequestBody DeviceConfiguration deviceConfiguration) {
        return null;
    }

    @Operation(summary = "Получение конфигурации устройства")
    @GetMapping(ApiPaths.MOBILE_CONFIGURATION)
    public DeviceConfiguration updateConfig(@PathVariable String deviceId) {
        return null;
    }

    @Operation(summary = "Получение последней температуры")
    @GetMapping(ApiPaths.MOBILE_LAST_TEMPERATURE)
    public Temperature getLastTemperature(@PathVariable String deviceId) {
        return null;
    }

    @Operation(summary = "Получение температуры за последние 24 часа")
    @GetMapping(ApiPaths.MOBILE_TEMPERATURE)
    public List<Temperature> getTemperature(@PathVariable String deviceId) {
        return null;
    }

}
