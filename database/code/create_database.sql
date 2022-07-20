DROP DATABASE IF EXISTS `jedi_academy`;

CREATE DATABASE `jedi_academy`;

USE `jedi_academy`;

SET
    NAMES utf8;

SET
    character_set_client = utf8mb4;

-- CREATE TABLES --
CREATE TABLE `students` (
    `id` int NOT NULL AUTO_INCREMENT,
    `first_name` varchar(255) NOT NULL,
    `last_name` varchar(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `phone` varchar(255),
    `birth_date` date,
    `address` varchar(255),
    `iq` int,
    `batch_id` int,
    PRIMARY KEY (`id`)
);

CREATE TABLE `batches` (
    `id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `start_date` date NOT NULL,
    `description` varchar(255),
    `instructor_id` int,
    PRIMARY KEY (`id`)
);

CREATE TABLE `instructors` (
    `id` int NOT NULL AUTO_INCREMENT,
    `first_name` varchar(255) NOT NULL,
    `last_name` varchar(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `phone` varchar(255),
    PRIMARY KEY (`id`)
);

-- ADD FOREIGN KEYS -- 
ALTER TABLE
    `students`
ADD
    FOREIGN KEY (`batch_id`) REFERENCES `batches`(`id`);

ALTER TABLE
    `batches`
ADD
    FOREIGN KEY (`instructor_id`) REFERENCES `instructors`(`id`);

-- INSERT DATA --
-- Instructors --
INSERT INTO
    `instructors` (`first_name`, `last_name`, `email`, `phone`)
VALUES
    ('Master', 'Yoda', 'y@jedi.com', '123-456-7890'),
    (
        'Obi-Wan',
        'Kenobi',
        'o@jedi.com',
        '123-456-7890'
    ),
    (
        'Sherlock',
        'Holmes',
        's@sherlock.ed',
        '123-456-7890'
    ),
    (
        'Rani',
        'Laxmi Bai',
        'r@rebelli.on',
        '123-456-7890'
    ),
    (
        'Thor',
        'Odinson',
        't@thunder.com',
        '123-456-7890'
    );

-- Batches --
INSERT INTO
    `batches` (
        `name`,
        `start_date`,
        `instructor_id`
    )
VALUES
    (
        'Jedi Academy 1',
        '2012-01-01',
        1
    ),
    (
        'Jedi Academy 2',
        '2014-01-01',
        2
    ),
    (
        'Sherlock Academy',
        '2017-01-01',
        3
    ),
    (
        'Independence Academy',
        '1857-01-01',
        4
    ),
    (
        'Love and Thunder Academy',
        '2022-01-01',
        5
    );

-- Students --
INSERT INTO
    `students` (
        `first_name`,
        `last_name`,
        `email`,
        `phone`,
        `birth_date`,
        `address`,
        `iq`,
        `batch_id`
    )
VALUES
    (
        'Anakin',
        'Skywalker',
        'darth@empire.blr',
        '123-456-7890',
        '1973-01-01',
        'Tatooine',
        130,
        1
    ),
    (
        'Luke',
        'Skywalker',
        'luke@resistance.com',
        '123-456-7890',
        '1994-01-01',
        'Tatooine',
        120,
        2
    ),
    (
        'Leia',
        'Organa',
        'leia@resistance.com',
        '123-456-7890',
        '1994-01-01',
        'Alderaan',
        130,
        2
    ),
    (
        'John',
        'Watson',
        'j@sherlock.ed',
        '123-456-7890',
        '1657-01-01',
        'London',
        130,
        3
    ),
    (
        'Mycroft',
        'Holmes',
        'm@sherlock.ed',
        '123-456-7890',
        '1657-01-01',
        'London',
        150,
        3
    ),
    (
        'Tantia',
        'Tope',
        't@rebelli.on',
        '123-456-7890',
        '1657-01-01',
        'Jhansi',
        130,
        4
    ),
    (
        'Jane',
        'Foster',
        'jane@th.or',
        '123-456-7890',
        '2022-01-01',
        'New Asgard',
        160,
        5
    ),
    (
        'Korg',
        'Rock',
        'korg@th.or',
        '123-456-7890',
        '2022-01-01',
        'New Asgard',
        80,
        5
    );

INSERT INTO 
students (first_name, last_name, email, iq)
VALUES ("Moriarty", "Patel", "mo@sherlock.ed", 170);

INSERT INTO 
batches (name, start_date)
VALUES ("Crime Academy", "2022-10-01");