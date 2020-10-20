CREATE TABLE `mymi`.`groupinfo` (
  `gsid` BIGINT(64) NOT NULL AUTO_INCREMENT,
  `youself` VARCHAR(60) NOT NULL,
  `group` VARCHAR(60) NULL,
  `joinTime` DATE NULL,
  PRIMARY KEY (`gsid`),
  UNIQUE INDEX `groupname_UNIQUE` (`youself` ASC) VISIBLE,
  INDEX `groupname_idx` (`group` ASC) VISIBLE,
  CONSTRAINT `username2`
    FOREIGN KEY (`youself`)
    REFERENCES `mymi`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `groupname`
    FOREIGN KEY (`group`)
    REFERENCES `mymi`.`groups` (`groupname`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

