CREATE TABLE retro_games (

    id INT AUTO_INCREMENT PRIMARY KEY,

    title VARCHAR(255) NOT NULL,

    platform VARCHAR(100) NOT NULL,

    release_date DATE NOT NULL,

    description TEXT,

    image_url VARCHAR(500),

    youtube_url VARCHAR(500)
);
