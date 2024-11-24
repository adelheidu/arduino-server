package arduino.server.api.controllers;

import arduino.server.api.ApiPaths;
import arduino.server.api.model.DeviceTemperature;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.module.Configuration;

@RestController
@RequiredArgsConstructor
@Tag(name = "Методы для взаимодействия с устройством")
public class DeviceController {

    @Operation(summary = "Получение температуры с устройства и отправка конфигурации")
    @PostMapping(ApiPaths.DEVICE_TEMPERATURE)
    public Configuration registerTemperatureAndSendConfig(@PathVariable String deviceId, @RequestBody DeviceTemperature deviceTemperature) {
        return null;
    }

}
