USE alimamadb;

SELECT * FROM alimamadb.chef;

-- testing database

INSERT INTO alimamadb.chef
(firstName, lastName, phone, email, hashedPassword, shift, status)
values ("chef1", "chef1", "phone1", "email1", "hash1", "day", "avalible"),
("chef2", "chef2", "phone2", "email2", "hash2", "day", "avalible"),
("chef3", "chef3", "phone3", "email3", "hash3", "day", "avalible");

