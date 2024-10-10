CREATE TABLE movies (
                        id INT PRIMARY KEY,
                        anno INT NOT NULL,
                        descrizione TEXT NOT NULL,
                        genre VARCHAR(100) NOT NULL,
                        img VARCHAR(255) NOT NULL,
                        like_count INT NOT NULL,
                        title VARCHAR(255) NOT NULL
);
