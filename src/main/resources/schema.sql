CREATE TABLE movies
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    anno        INT          NOT NULL,
    descrizione TEXT         NOT NULL,
    genre       VARCHAR(100) NOT NULL,
    img         VARCHAR(255) NOT NULL,
    like_count  INT          NOT NULL,
    title       VARCHAR(255) NOT NULL
);

CREATE TABLE users
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    email    VARCHAR(1000),
    password VARCHAR(255)
);
