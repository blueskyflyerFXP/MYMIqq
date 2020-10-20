CREATE TABLE `mymi`.`friendsinfo` (
  `gid` BIGINT(64) NOT NULL AUTO_INCREMENT,
  `myself` VARCHAR(60) NOT NULL,
  `friend` VARCHAR(60) NOT NULL,
  `remark` VARCHAR(60) NULL
  `shipTime` DATE NULL,
  PRIMARY KEY (`gid`),
  UNIQUE INDEX `frienduser_idx` (`myself` ASC) VISIBLE,
  CONSTRAINT `frienduser`
    FOREIGN KEY (`myself`)
    REFERENCES `mymi`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `myuser`
    FOREIGN KEY (`myself`)
    REFERENCES `mymi`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

