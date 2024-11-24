package arduino.server.api.model;

import java.time.OffsetDateTime;

public record TemperatureEntity (
    Integer id,
    String deviceId,
    OffsetDateTime dateTime,
    Integer temperature,
    Boolean critical
){}
