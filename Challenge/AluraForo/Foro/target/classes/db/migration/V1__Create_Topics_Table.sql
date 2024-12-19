CREATE TABLE topics (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(75) NOT NULL,
    message VARCHAR(200) NOT NULL,
    course VARCHAR(75) NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    ultima_actualizacion TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL
);
