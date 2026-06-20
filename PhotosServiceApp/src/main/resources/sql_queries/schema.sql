-- DROP TABLE IF EXISTS Photos;

CREATE TABLE Photos
(
    Id            BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Album_Id      BIGINT NOT NULL,
    Title         VARCHAR(255),
    Url           VARCHAR(255),
    Thumbnail_Url VARCHAR(255),
);
