package arduino.server.api;

import arduino.server.api.exception.ExceptionMessage;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "500", description = "SO BAD",
                content = { @Content(schema = @Schema(implementation = ExceptionMessage.class)) })
})
public @interface CommonApiResponses {
}
