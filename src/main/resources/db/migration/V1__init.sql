CREATE TABLE IF NOT EXISTS film (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    director VARCHAR(255),
    duration INT,
    UNIQUE (title)
);

CREATE TABLE IF NOT EXISTS scene (
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    budget DECIMAL(12,2) DEFAULT 0.00,
    minutes INT,
    film_id INT,
    FOREIGN KEY (film_id) REFERENCES Film (id)
);

CREATE TABLE IF NOT EXISTS character (
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    cost DECIMAL(12,2) DEFAULT 0.00,
    stock INT,
    scene_id INT,
    FOREIGN KEY (scene_id) REFERENCES Scene (id)
);
