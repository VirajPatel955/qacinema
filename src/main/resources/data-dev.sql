INSERT INTO booking(`booker_name`, `movie_date`, `movie_title`, `number_of_seats`, `ticket_type`, `total`) 
VALUES 
('John Smith', '2020-05-03', 'Ghostbusters', 2, 'adult', 20),
('Piers Barber', '2021-05-03', 'Ghostbusters 2', 1, 'adult', 10);

INSERT INTO listing(`movie`, `director`, `actors`, `showing_times`)
VALUES
    ('Ghostbusters', 'John Abrahams', 'Paul Rudd', 1700);