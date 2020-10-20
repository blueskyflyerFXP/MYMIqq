CREATE TABLE `mymi`.`userinfo` (
  `username` VARCHAR(60) NOT NULL,
  `nickname` VARCHAR(60) NULL,
  `protraitPicture` BLOB NULL,
  `sex` VARCHAR(10) NULL,
  `signature` VARCHAR(200) NULL,
  `locale` VARCHAR(60) NULL,
  `birthday` DATE NULL,
  `telepone` SMALLINT(11) NULL,
  `hobby` VARCHAR(100) NULL,
  `email` VARCHAR(40) NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `username1`
    FOREIGN KEY (`username`)
    REFERENCES `mymi`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
