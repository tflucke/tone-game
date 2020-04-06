-- Words Schema

-- !Ups
CREATE TYPE tone AS ENUM ('ngang', 'huyen', 'sac', 'hoi', 'nga', 'nang');

CREATE TABLE Words (
    id bigserial NOT NULL,
    spelling varchar(255) NOT NULL,
    root bigint NOT NULL REFERENCES Words ON DELETE RESTRICT,
    tone tone NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (spelling, tone)
);

-- !Downs

DROP Type tone;

DROP TABLE Words;
