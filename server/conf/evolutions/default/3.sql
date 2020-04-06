-- Pronunciation Schema

-- !Ups

CREATE TABLE Users (
    id bigserial NOT NULL,
    username varchar(255) NOT NULL UNIQUE,
    password text NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Pronunciations (
    id bigserial NOT NULL,
    word bigint NOT NULL REFERENCES Words ON DELETE RESTRICT,
    speaker bigint NOT NULL REFERENCES Users ON DELETE RESTRICT,
    audio bytea NOT NULL,
    mime_type varchar(255) NOT NULL DEFAULT 'audio/mpeg',
    PRIMARY KEY (id),
    UNIQUE (word, speaker)
);

-- !Downs

DROP TABLE Pronunciations;

DROP TABLE Users;
