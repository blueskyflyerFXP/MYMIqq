CREATE TABLE `mymi`.`groups` (
  `gid` BIGINT(64) NOT NULL AUTO_INCREMENT,
  `groupname` VARCHAR(60) NOT NULL,
  `createTime` DATE NULL,
  PRIMARY KEY (`gid`),
  UNIQUE INDEX `groupname_UNIQUE` (`groupname` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

ALTER TABLE `mymi`.`groups`
ADD COLUMN `groupOwer` VARCHAR(60) NOT NULL AFTER `groupname`,
ADD UNIQUE INDEX `groupOwer_UNIQUE` (`groupOwer` ASC) VISIBLE;
;
ALTER TABLE `mymi`.`groups`
ADD CONSTRAINT `groupower`
  FOREIGN KEY (`groupOwer`)
  REFERENCES `mymi`.`users` (`username`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;