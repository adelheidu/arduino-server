package arduino.server.core.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public enum ExceptionTitles {
    INTERNAL_ERROR,
    INVALID_ARGUMENT,
    NOT_FOUND
}
