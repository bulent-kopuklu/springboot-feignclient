

drop table if exists users;

CREATE TABLE  users (
  id LONG AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(256) NOT NULL,
  last_name VARCHAR(256) NOT NULL,
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
);

