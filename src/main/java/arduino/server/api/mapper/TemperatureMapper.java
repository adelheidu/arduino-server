package arduino.server.api.mapper;

import arduino.server.api.model.Temperature;
import arduino.server.api.model.TemperatureEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TemperatureMapper {

    @Mapping(target = "timestamp", source = "dateTime")
    @Mapping(target = "isCritical", source = "critical")
    Temperature map(TemperatureEntity temperatureEntity);
}
