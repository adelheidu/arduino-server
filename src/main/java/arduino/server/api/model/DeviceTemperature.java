package arduino.server.api.model;

import io.swagger.v3.oas.annotations.media.Schema;

public record DeviceTemperature (

        @Schema(description = "Значение температуры",
                requiredMode = Schema.RequiredMode.REQUIRED)
        int temperature,

        @Schema(description = "Флаг критической температуры",
                requiredMode = Schema.RequiredMode.REQUIRED)
        boolean isCritical
) {
}
