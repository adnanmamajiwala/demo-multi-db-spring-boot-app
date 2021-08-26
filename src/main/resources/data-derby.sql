CREATE TABLE DERBYDB.USER_INFO
(
    id         bigint GENERATED BY DEFAULT AS IDENTITY,
    name       varchar(255),
    gender     varchar(255),
    title      varchar(255),
    email      varchar(255),
    height     double NOT NULL,
    weight     double NOT NULL,
    birth_date timestamp,
    PRIMARY KEY (id)
);

insert into DERBYDB.USER_INFO (name, gender, title, email, height, weight, birth_date)
values ('Emmett Frost', 'Male', 'Fames Suscipit', 'carrie.goodman@example.com', 9.68, 216.74, TIMESTAMP('2011-01-26 00:00:00.000')),
       ('Joshua Nixon', 'Male', 'Dissentiunt Verterem', 'susanne.brady@example.com', 6.29, 728.66, TIMESTAMP('2016-07-18 00:00:00.000')),
       ('Art Cain', 'Male', 'Praesent', 'tammy.shaw@example.com', 9.85, 595.96, TIMESTAMP('2008-05-01 00:00:00.000')),
       ('Johnny Randolph', 'Male', 'Dicam', 'noreen.banks@example.com', 2.15, 753.79, TIMESTAMP('2008-05-01 00:00:00.000')),
       ('Candice Whitaker', 'Female', 'Honestatis', 'edna.martinez@example.com', 5.69, 583.15, TIMESTAMP('2016-07-18 00:00:00.000')),
       ('Emilia Walter', 'Female', 'Ne', 'clarissa.brock@example.com', 0.05, 123.2, TIMESTAMP('2008-05-01 00:00:00.000')),
       ('Elvia Whitfield', 'Female', 'Graeci Dignissim', 'weldon.adkins@example.com', 9.01, 153.98, TIMESTAMP('2013-10-22 00:00:00.000')),
       ('Cristina Wiley', 'Female', 'Nostra Eros', 'shawn.sanchez@example.com', 0.94, 466.09, TIMESTAMP('2013-10-22 00:00:00.000')),
       ('Esteban Sandoval', 'Male', 'Utinam Meliore', 'isabella.townsend@example.com', 1.55, 925.78, TIMESTAMP('2011-01-26 00:00:00.000')),
       ('Scot Hansen', 'Male', 'Nascetur Netus', 'cassandra.thompson@example.com', 2.99, 994.9, TIMESTAMP('2008-05-01 00:00:00.000')),
       ('Lori Sargent', 'Female', 'Ante Vitae', 'maude.west@example.com', 2.1, 620.37, TIMESTAMP('2016-07-18 00:00:00.000')),
       ('Erik Dunlap', 'Male', 'Vel mus', 'refugio.boyd@example.com', 2.87, 503.75, TIMESTAMP('2013-10-22 00:00:00.000')),
       ('Duncan Roach', 'Male', 'Legimus', 'brandon.hood@example.com', 2.82, 825.86, TIMESTAMP('2008-05-01 00:00:00.000')),
       ('Charlotte Gentry', 'Female', 'Intellegebat Nominavi', 'cara.hester@example.com', 8.97, 241.35, TIMESTAMP('2008-05-01 00:00:00.000')),
       ('Rosanna Riley', 'Female', 'Egestas Errem', 'bernard.david@example.com', 7.61, 17.71, TIMESTAMP('2008-05-01 00:00:00.000')),
       ('Bryon Fitzpatrick', 'Male', 'Ipsum Dignissim', 'daphne.larsen@example.com', 7.84, 610.8, TIMESTAMP('2013-10-22 00:00:00.000')),
       ('Lacey Calderon', 'Female', 'Rhoncus Viris', 'edwin.hickman@example.com', 6.92, 599.7, TIMESTAMP('2011-01-26 00:00:00.000')),
       ('Rocco Contreras', 'Male', 'Veri', 'donny.fischer@example.com', 4.55, 366.71, TIMESTAMP('2013-10-22 00:00:00.000')),
       ('Lavonne Morton', 'Female', 'Urbanitas', 'rory.morrow@example.com', 8.01, 314.3, TIMESTAMP('2016-07-18 00:00:00.000')),
       ('Lynne O Neil', 'Female', 'Torquent Netus', 'elaine.dennis@example.com', 1.48, 763.28, TIMESTAMP('2013-10-22 00:00:00.000'));