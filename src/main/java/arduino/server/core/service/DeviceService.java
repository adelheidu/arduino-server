package arduino.server.core.service;

import arduino.server.api.model.DeviceConfiguration;
import arduino.server.api.model.DeviceTemperature;
import arduino.server.core.repository.ConfigurationRepository;
import arduino.server.core.repository.TemperatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final TemperatureRepository temperatureRepository;

    private final ConfigurationRepository configurationRepository;

    public DeviceConfiguration registerTemperatureAndSendConfig(String deviceId, DeviceTemperature deviceTemperature) {
        temperatureRepository.registerTemperature(deviceId, deviceTemperature);
        return configurationRepository.getConfiguration(deviceId).orElse(
                        new DeviceConfiguration(0, 30, 30000)
                );
    }
}
