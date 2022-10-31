CREATE TABLE dogs (
	id INTEGER GENERATED ALWAYS AS IDENTITY,
	breed VARCHAR(32) NOT NULL,
	name VARCHAR(32) NOT NULL,	
	PRIMARY KEY(id)
);

INSERT INTO dogs (breed, name)
VALUES
 ('Aussie', 'Rosco')
,('Lab', 'Merle')
,('Cane Corso', 'Fancy');