package arduino.server.api;

import arduino.server.core.repository.ConfigurationRepository;
import arduino.server.core.repository.TemperatureRepository;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public Jdbi jdbi(DataSource dataSource) {
        return Jdbi.create(dataSource)
                .installPlugin(new SqlObjectPlugin())
                .installPlugin(new PostgresPlugin());
    }

    @Bean
    public ConfigurationRepository configurationRepository(Jdbi jdbi) {
        return jdbi.onDemand(ConfigurationRepository.class);
    }

    @Bean
    public TemperatureRepository mobileRepository(Jdbi jdbi) {
        return jdbi.onDemand(TemperatureRepository.class);
    }

}

