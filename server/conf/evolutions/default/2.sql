-- Word Group Schema

-- !Ups

CREATE TABLE WordGroups (
    id bigserial NOT NULL,
    root_spelling varchar(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

ALTER TABLE Words DROP COLUMN root;
ALTER TABLE Words ADD COLUMN word_group bigint NOT NULL REFERENCES WordGroups ON DELETE CASCADE;


-- !Downs

ALTER TABLE Words DROP COLUMN word_group;
ALTER TABLE Words ADD COLUMN root bigint NOT NULL REFERENCES Words ON DELETE RESTRICT;

DROP TABLE WordGroups;
