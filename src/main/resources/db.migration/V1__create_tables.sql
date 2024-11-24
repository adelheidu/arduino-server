CREATE TABLE temperature
(
    id              INTEGER,
    device_id       VARCHAR,
    date_time       TIMESTAMP,
    temperature     INTEGER,
    critical        BOOLEAN,
    PRIMARY KEY(id)
);

CREATE TABLE configuration
(
    device_id                   VARCHAR,
    min_critical_temperature    INTEGER,
    max_critical_temperature    INTEGER,
    update_interval             BIGINT,
    PRIMARY KEY(device_id)
);

CREATE SEQUENCE sequence_temperature_id
    INCREMENT 1
    START 1
    OWNED BY temperature.id;