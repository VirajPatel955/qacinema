use `qacinemaDB`

drop table if exists `booking`

create table if not exists `booking` (
    id INT not null auto_increment,
    booker_name varchar(40) not null,
    movie_date date not null,
    movie_title varchar(40) not null,
    number_of_seats INT not null,
    ticket_type varchar(40) not null,
    total INT not null,
    primary key (id));
    
INSERT INTO booking('booker_name', 'movie_date', 'movie_title', 'number_of_seats', 'ticket_type', 'total') 
VALUES 
('John Smith', 2020-05-03, 'Ghostbusters', 2, 'adult', 20);
('Bob the Builder', 2021-05-03, 'Ghostbusters 2', 1, 'adult', 10);
