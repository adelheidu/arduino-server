package arduino.server.api.model;

import io.swagger.v3.oas.annotations.media.Schema;

public record DeviceConfiguration(

        @Schema(description = "Минимальное значение критической температуры",
                requiredMode = Schema.RequiredMode.REQUIRED)
        int minCriticalTemperature,

        @Schema(description = "Максимальное значение критической температуры",
                requiredMode = Schema.RequiredMode.REQUIRED)
        int maxCriticalTemperature,

        @Schema(description = "Частота обновления температуры в миллисекундах",
                requiredMode = Schema.RequiredMode.REQUIRED)
        long updateInterval
) {
}
