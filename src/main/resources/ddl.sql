CREATE TABLE customer
(
    id character varying(40) NOT NULL,
    name character varying(100) NOT NULL,
    birthdate date DEFAULT 0,
    cpf character varying(20) NOT NULL,
    email character varying(256) NOT NULL,
    hashpassword character varying(256) NOT NULL,
    CONSTRAINT customer_pkey PRIMARY KEY (id)
);
