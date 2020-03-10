-- // create account
-- Migration SQL that makes the change goes here.
CREATE TABLE account
(
      id SERIAL PRIMARY KEY,
      email_address CHARACTER VARYING(255) NOT NULL UNIQUE,
      password CHARACTER VARYING(255) NOT NULL
);

-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE account;
