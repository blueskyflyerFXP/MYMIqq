CREATE TABLE `mymi`.`chatinfo` (
  `chatSpaceId` BIGINT(64) NOT NULL AUTO_INCREMENT,
  `yourself` VARCHAR(60) NOT NULL,
  `chatType` VARCHAR(10) NULL,
  `chatUser` VARCHAR(60) NOT NULL,
  `msgType` VARCHAR(10) NULL,
  `message` BLOB NULL,
  `chatTime` DATE NULL,
  PRIMARY KEY (`chatSpaceId`),
  UNIQUE INDEX `user3_idx` (`yourself` ASC) VISIBLE,
  UNIQUE INDEX `user4_idx` (`chatUser` ASC) VISIBLE,
  CONSTRAINT `user3`
    FOREIGN KEY (`yourself`)
    REFERENCES `mymi`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user4`
    FOREIGN KEY (`chatUser`)
    REFERENCES `mymi`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `group1`
    FOREIGN KEY (`chatUser`)
    REFERENCES `mymi`.`groups` (`groupname`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
