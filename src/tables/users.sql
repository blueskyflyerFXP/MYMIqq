CREATE SCHEMA `mymi` DEFAULT CHARACTER SET utf8 ;
CREATE TABLE `mymi`.`users` (
  `uid` BIGINT(64) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(60) NOT NULL,
  `password` VARCHAR(60) NULL,
  `identCode` VARCHAR(20) NULL,
  PRIMARY KEY (`uid`, `username`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


