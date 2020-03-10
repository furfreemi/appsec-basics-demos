-- // create item
-- Migration SQL that makes the change goes here.

CREATE TABLE item (
   id SERIAL PRIMARY KEY,
   name CHARACTER VARYING(255) NOT NULL,
   description CHARACTER VARYING(255) NOT NULL
 );

-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE item;
