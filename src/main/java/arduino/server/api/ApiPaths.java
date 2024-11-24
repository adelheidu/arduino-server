package arduino.server.api;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ApiPaths {

    public static final String MOBILE_CONFIGURATION = "/api/mobile/configuration/{deviceId}";

    public static final String MOBILE_TEMPERATURE = "/api/mobile/temperature/{deviceId}";

    public static final String MOBILE_LAST_TEMPERATURE = "/api/mobile/temperature/last/{deviceId}";

    public static final String DEVICE_TEMPERATURE = "/api/device/temperature/{deviceId}";



}
