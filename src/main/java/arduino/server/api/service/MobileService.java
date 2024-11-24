package arduino.server.api.service;

import arduino.server.api.mapper.TemperatureMapper;
import arduino.server.api.model.DeviceConfiguration;
import arduino.server.api.model.Temperature;
import arduino.server.api.repository.MobileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MobileService {

    private final MobileRepository mobileRepository;

    private final TemperatureMapper temperatureMapper;

    public DeviceConfiguration createConfig(String deviceId, DeviceConfiguration deviceConfiguration) {
        mobileRepository.addConfiguration(deviceId, deviceConfiguration);
        return getConfiguration(deviceId);
    }

    public DeviceConfiguration getConfiguration(String deviceId) {
        return mobileRepository.getConfiguration(deviceId);
    }

    public Temperature getLastTemperature(String deviceId) {
        return temperatureMapper.map(mobileRepository.getLastTemperature(deviceId));
    }

    public List<Temperature> getTemperature(String deviceId) {
        return mobileRepository.getTemerature(deviceId).
                stream().
                map(temperatureMapper::map)
                .toList();
    }
}
