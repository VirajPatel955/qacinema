drop table if exists booking
create table booking (
    id bigint not null auto_increment,
    booker_name varchar(15) not null,
    date date not null,
    movie_title varchar(15) not null,
    number_of_seats bigint not null,
    ticket_type varchar(15) not null,
    time datetime(6) not null,
    total bigint not null,
    primary key (id));

INSERT INTO booking (booker_name, date, movie_title, number_of_seats, ticket_type, time, total) values ("John Smith", 2020-05-03, "Ghostbusters", 2, "adult", '2020-05-03 11:11:11.11111', 20);
INSERT INTO qacinemaDB.booking (booker_name, date, movie_title, number_of_seats, ticket_type, time, total) values ("Bob the Builder", 2021-05-03, "Ghostbusters 2", 1, "adult", '2020-05-03 11:11:11.11111', 10);