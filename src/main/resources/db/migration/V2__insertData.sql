INSERT INTO Family_DB (id, family_name, nr_of_adults, nr_of_children, nr_of_infants) VALUES
    (1, 'Kowalski',0,0,1),
    (2, 'Lewandowski',1,1,2);

INSERT INTO Family_MemberDB(family_id,family_name, given_name, age, id) VALUES
    (1,'Kowalski','Jan',25, 12),
    (2,'Lewandowski','Robert',33, 2),
    (2,'Lewandowska','Anna', 33,3),
    (2,'Lewandowska','Klara', 25,4),
    (2,'Lewandowska','Laura', 25,5);