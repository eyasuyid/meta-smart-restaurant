SELECT * FROM alimamadb.receptionist;

-- testing database

INSERT INTO alimamadb.receptionist
(firstName, lastName, phone, email, hashedPassword, shift, status)
values ("receptionist1", "receptionist1", "phone1", "email1", "hash1", "day", "avaliable" ),
("receptionist2", "receptionist2", "phone2", "email2", "hash2", "day", "avaliable" ),
("receptionist3", "receptionist3", "phone3", "email3", "hash3", "day", "avaliable" );
