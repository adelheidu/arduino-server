package arduino.server.api.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.OffsetDateTime;

public record Temperature(

        @Schema(description = "Значение температуры",
                requiredMode = Schema.RequiredMode.REQUIRED)
        int temperature,

        @Schema(description = "Время замера температуры",
                requiredMode = Schema.RequiredMode.REQUIRED)
        OffsetDateTime timestamp,

        @Schema(description = "Флаг критической температуры",
                requiredMode = Schema.RequiredMode.REQUIRED)
        boolean isCritical
) {
}
