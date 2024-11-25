package arduino.server.api.service;

import arduino.server.api.model.DeviceConfiguration;
import arduino.server.api.model.DeviceTemperature;
import arduino.server.api.repository.ConfigurationRepository;
import arduino.server.api.repository.TemperatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final TemperatureRepository temperatureRepository;

    private final ConfigurationRepository configurationRepository;

    public DeviceConfiguration registerTemperatureAndSendConfig(String deviceId, DeviceTemperature deviceTemperature) {
        temperatureRepository.registerTemperature(deviceId, deviceTemperature);
        return configurationRepository.getConfiguration(deviceId);
    }
}
