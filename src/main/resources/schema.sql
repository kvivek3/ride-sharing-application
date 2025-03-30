-- USERS TABLE
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- ROLES TABLE (Element Collection)
CREATE TABLE users_roles (
    users_id BIGINT NOT NULL,  -- Refers to 'users.id'
    roles VARCHAR(50) NOT NULL,  -- Stores role names as Strings
    FOREIGN KEY (users_id) REFERENCES users(id) ON DELETE CASCADE
);
