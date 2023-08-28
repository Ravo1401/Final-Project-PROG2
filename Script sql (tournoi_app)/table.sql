CREATE DATABASE tournoi_app;

\c tournoi_app;

CREATE TABLE "user"(
    id int primary key,
    name varchar(200) not null,
    pseudo varchar(200) not null
);
INSERT INTO "user" (id, name, pseudo) values (1, 'Ravo', 'Sun Wukong');

CREATE TABLE tournaments(
    id_tournaments int primary key,
    name varchar(200) not null,
    date timestamp,
    location varchar(200)
);
INSERT INTO tournaments(id_tournaments, name, date, location) VALUES (1, 'Tekken Tournaments', '2023,08,30', 'Romania');

CREATE TABLE match(
    id_match int primary key,
    user1_id int,
    user2_id int,
    match_date timestamp,
    user1_score int,
    user2_score int
);
INSERT INTO match(id_match, user1_id, user2_id, match_date, user1_score, user2_score) VALUES (1, 1, 2, '2023,08,30', 1, 0);
