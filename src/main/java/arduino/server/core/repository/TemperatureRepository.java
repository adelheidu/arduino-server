package arduino.server.core.repository;


import arduino.server.api.model.DeviceTemperature;
import arduino.server.core.entity.TemperatureEntity;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindMethods;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterConstructorMapper(value = TemperatureEntity.class)
public interface TemperatureRepository {

    @SqlQuery("""
            SELECT * from temperature WHERE device_id = :deviceId ORDER BY date_time DESC LIMIT 1
            """)
    TemperatureEntity getLastTemperature(@Bind("deviceId") String deviceId);

    @SqlQuery("""
            SELECT * from temperature WHERE device_id = :deviceId AND EXTRACT(DAY FROM now()-date_time) < 1;
            """)
    List<TemperatureEntity> getTemperature(@Bind("deviceId") String deviceId);

    @SqlUpdate("""
            INSERT INTO temperature (id, device_id, date_time, temperature, critical)
            VALUES (
                nextval('sequence_temperature_id'),
                :deviceId, now(),
                :temperature.temperature,
                :temperature.isCritical
            )
            """)
    void registerTemperature(@Bind("deviceId") String deviceId,
                             @BindMethods("temperature") DeviceTemperature temperature);
}
