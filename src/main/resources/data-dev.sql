drop table if exists booking
create table booking (
    id bigint not null auto_increment,
    booker_name varchar(15) not null,
    movie_date date not null,
    movie_title varchar(15) not null,
    number_of_seats bigint not null,
    ticket_type varchar(15) not null,
    total bigint not null,
    primary key (id));

INSERT INTO `qacinemaDB`.`booking` (`booker_name`, `movieDate`, `movie_title`, `number_of_seats`, `ticket_type`, `total`) values ('John Smith', 2020-05-03, 'Ghostbusters', 2, 'adult', 20);
INSERT INTO `qacinemaDB`.`booking` (`booker_name`, `movieDate`, `movie_title`, `number_of_seats`, `ticket_type`, `total`) values ('Bob the Builder', 2021-05-03, 'Ghostbusters 2', 1, 'adult', 10);