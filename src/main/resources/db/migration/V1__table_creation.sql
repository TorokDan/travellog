CREATE TABLE appuser (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE role (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE user_role (
    user_id INT REFERENCES role (id),
    role_id INT REFERENCES appuser (id),
    CONSTRAINT user_role_key PRIMARY KEY (user_id, role_id)
);