CREATE TABLE `mymi`.`logininfo` (
  `username` VARCHAR(60) NOT NULL,
  `userIp` VARCHAR(20) NULL,
  `onlineState` BIT(1) NULL,
  `loginTime` DATE NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `loginuser`
    FOREIGN KEY (`username`)
    REFERENCES `mymi`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
