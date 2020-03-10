-- // create_default_accounts_and_item_types
-- Migration SQL that makes the change goes here.
INSERT INTO account (email_address, password)
	    VALUES ('admin@freewheelers.bike', 'Yellow bikes are just amazingly awesome, right? Says Robert, my good friend!');
INSERT INTO account (email_address, password)
	    VALUES ('user@example.com', 'Part 3: Tall zebra mobile responsive communication patterns!');

INSERT INTO account (email_address, password)
	    VALUES ('phillip.fry@example.com', 'I Am Literally Angry With Rage!');

INSERT INTO account (email_address, password)
	    VALUES ('bender@example.com', 'Another pointless day where I accomplish nothing.');

INSERT INTO account (email_address, password)
	    VALUES ('zoidberg@example.com', 'Your music is bad and you should feel bad.');

INSERT INTO item (name, description) VALUES ('Item1', 'The first item');
INSERT INTO item (name, description) VALUES ('Item2', 'The second item');


-- //@UNDO
-- SQL to undo the change goes here.