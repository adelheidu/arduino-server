package arduino.server.api.repository;

import arduino.server.api.model.DeviceConfiguration;
import arduino.server.api.model.TemperatureEntity;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindMethods;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterConstructorMapper(value = DeviceConfiguration.class)
@RegisterConstructorMapper(value = TemperatureEntity.class)
public interface MobileRepository {

    @SqlUpdate("""
            INSERT INTO configuration (device_id, min_critical_temperature, max_critical_temperature, update_interval)
            VALUES (:deviceId, :configuration.minCriticalTemperature, :configuration.maxCriticalTemperature, :configuration.updateInterval)
            ON CONFLICT (device_id) DO
            UPDATE
            SET min_critical_temperature = :configuration.minCriticalTemperature,
                max_critical_temperature = :configuration.maxCriticalTemperature,
                update_interval = :configuration.updateInterval
            """)
    void addConfiguration(@Bind("deviceId") String deviceId,
                     @BindMethods(value = "configuration") DeviceConfiguration configuration
    );

    @SqlQuery("""
            SELECT EXISTS(SELECT * FROM configuration WHERE device_id = :deviceId)::bool
            """)
    boolean isDeviceExist(@Bind("deviceId") String deviceId);

    @SqlQuery("""
            SELECT * from configuration WHERE device_id = :deviceId
            """)
    DeviceConfiguration getConfiguration(@Bind("deviceId") String deviceId);

    @SqlQuery("""
            SELECT * from temperature WHERE device_id = :deviceId ORDER BY date_time DESC LIMIT 1
            """)
    TemperatureEntity getLastTemperature(@Bind("deviceId") String deviceId);

    @SqlQuery("""
            SELECT * from temperature WHERE device_id = :deviceId AND EXTRACT(DAY FROM now()-date_time) < 1;
            """)
    List<TemperatureEntity> getTemerature(@Bind("deviceId") String deviceId);
}
