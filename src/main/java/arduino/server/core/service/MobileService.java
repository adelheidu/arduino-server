package arduino.server.core.service;

import arduino.server.api.mapper.TemperatureMapper;
import arduino.server.api.model.DeviceConfiguration;
import arduino.server.api.model.Temperature;
import arduino.server.core.repository.ConfigurationRepository;
import arduino.server.core.repository.TemperatureRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MobileService {

    private final ConfigurationRepository configurationRepository;

    private final TemperatureRepository temperatureRepository;

    private final TemperatureMapper temperatureMapper;

    public DeviceConfiguration createConfig(String deviceId, DeviceConfiguration deviceConfiguration) {
        configurationRepository.addConfiguration(deviceId, deviceConfiguration);
        return getConfiguration(deviceId);
    }

    public DeviceConfiguration getConfiguration(String deviceId) {
        return configurationRepository.getConfiguration(deviceId);
    }

    public Temperature getLastTemperature(String deviceId) {
        return temperatureMapper.map(temperatureRepository.getLastTemperature(deviceId));
    }

    public List<Temperature> getTemperature(String deviceId) {
        return temperatureRepository.getTemperature(deviceId).
                stream().
                map(temperatureMapper::map)
                .toList();
    }
}
