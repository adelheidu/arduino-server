package arduino.server.api.controllers;

import arduino.server.api.ApiPaths;
import arduino.server.api.model.DeviceConfiguration;
import arduino.server.api.model.DeviceTemperature;
import arduino.server.api.service.DeviceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Методы для взаимодействия с устройством")
public class DeviceController {

    private final DeviceService deviceService;

    @Operation(summary = "Получение температуры с устройства и отправка конфигурации")
    @PostMapping(ApiPaths.DEVICE_TEMPERATURE)
    public DeviceConfiguration registerTemperatureAndSendConfig(
            @PathVariable String deviceId,
            @RequestBody DeviceTemperature deviceTemperature
    ) {
        return deviceService.registerTemperatureAndSendConfig(deviceId, deviceTemperature);
    }

}
