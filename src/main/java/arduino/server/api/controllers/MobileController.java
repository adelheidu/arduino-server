package arduino.server.api.controllers;

import arduino.server.api.ApiPaths;
import arduino.server.api.model.DeviceConfiguration;
import arduino.server.api.model.Temperature;
import arduino.server.api.service.MobileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Методы для взаимодействия с МП")
public class MobileController {

    private final MobileService mobileService;

    @Operation(summary = "Задание конфигурации на устройстве")
    @PostMapping(ApiPaths.MOBILE_CONFIGURATION)
    public DeviceConfiguration createConfig(@PathVariable String deviceId, @RequestBody DeviceConfiguration deviceConfiguration) {
        log.info(Integer.toString(deviceConfiguration.maxCriticalTemperature()));
        return mobileService.createConfig(deviceId, deviceConfiguration);
    }

    @Operation(summary = "Получение конфигурации устройства")
    @GetMapping(ApiPaths.MOBILE_CONFIGURATION)
    public DeviceConfiguration getConfig(@PathVariable String deviceId) {
        return mobileService.getConfiguration(deviceId);
    }

    @Operation(summary = "Получение последней температуры")
    @GetMapping(ApiPaths.MOBILE_LAST_TEMPERATURE)
    public Temperature getLastTemperature(@PathVariable String deviceId) {
        return mobileService.getLastTemperature(deviceId);
    }

    @Operation(summary = "Получение температуры за последние 24 часа")
    @GetMapping(ApiPaths.MOBILE_TEMPERATURE)
    public List<Temperature> getTemperature(@PathVariable String deviceId) {
        return mobileService.getTemperature(deviceId);
    }

}
