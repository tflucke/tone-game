-- Pronunciation Schema

-- !Ups

ALTER TABLE WordGroups ADD COLUMN enabled BOOLEAN NOT NULL DEFAULT TRUE;

-- !Downs

ALTER TABLE WordGroups DROP COLUMN enabled;
