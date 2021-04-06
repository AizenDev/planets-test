CREATE TABLE lords (
    lid serial PRIMARY KEY,
    lname text,
    age integer
);


CREATE TABLE planets (
    pid serial PRIMARY KEY,
    pname text,
    lord_id integer,
    FOREIGN KEY (lord_id) REFERENCES lords (lid) ON DELETE RESTRICT
);