
DROP SCHEMA IF EXISTS `absdb`;
CREATE SCHEMA IF NOT EXISTS `absdb` DEFAULT CHARACTER SET latin1;
USE `absdb`;

-- -----------------------------------------------------
-- Table absdb.announcement
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `absdb`.`announcement` (
  `announcement_id` INT(11) NOT NULL AUTO_INCREMENT,
   title VARCHAR(100) NOT NULL,
   body VARCHAR(1000) NOT NULL,
   picture VARCHAR(300),
   link    VARCHAR(300),
   date DATETIME not null DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (announcement_id));

-- -----------------------------------------------------
-- Table `absdb`.`faq`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `absdb`.`faq` (
  `faq_id` INT(11) NOT NULL AUTO_INCREMENT,
  `faq_title` VARCHAR(100) NOT NULL,
  `faq_question` VARCHAR(200) NOT NULL,
  `faq_answer` VARCHAR(25) NOT NULL,
  `faq_visible` TINYINT(1) NOT NULL default 1,
  `type` TINYINT(1) NOT NULL default 1,
  `position` INT(11),
  PRIMARY KEY (`faq_id`));
  
  -- -----------------------------------------------------
-- Table `absdb`.`safety`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `absdb`.`safety` (
  `safety_id` INT(11) NOT NULL AUTO_INCREMENT,
  `safety_title` VARCHAR(25) NOT NULL,
  `safety_desc` VARCHAR(25) NOT NULL,
  `link` VARCHAR(300) NOT NULL,
  `visible` TINYINT(1) NOT NULL default 1,
  `type` TINYINT(1) NOT NULL default 1,
  `position` INT(11),
  
  PRIMARY KEY (`safety_id`));

-- -----------------------------------------------------
-- Table `absdb`.`state`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `absdb`.`state` (
  `state_id` INT(11) NOT NULL AUTO_INCREMENT,
  `state_name` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`state_id`));
  
  -- -----------------------------------------------------
-- Table `absdb`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `absdb`.`city` (
  `city_id` INT(11) NOT NULL AUTO_INCREMENT,
  `city_name` VARCHAR(25) NOT NULL,
  `stateid` INT(11) NOT NULL,
  PRIMARY KEY (`city_id`),
 CONSTRAINT `fk_state_city`
  FOREIGN KEY (`stateid`)
  REFERENCES `absdb`.`state` (`state_id`)
  );
  
    -- -----------------------------------------------------
-- Table `absdb`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `absdb`.`address` (
  `address_id` INT(11) NOT NULL AUTO_INCREMENT,
  `address_detail` VARCHAR(25) NOT NULL,
  `city_id` INT(11) NOT NULL,
  PRIMARY KEY (`address_id`),
CONSTRAINT `fk_city_address`
  FOREIGN KEY (`city_id`)
  REFERENCES `absdb`.`city` (`city_id`)
  );

-- -----------------------------------------------------
-- Table `absdb`.`affiliation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `absdb`.`affiliation` (
  `affiliation_id` INT(11) NOT NULL AUTO_INCREMENT,
  `affiliation_des` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`affiliation_id`));
  
  -- -----------------------------------------------------
-- Table `absdb`.`diet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `absdb`.`diet` (
  `diet_id` INT(11) NOT NULL AUTO_INCREMENT,
  `diet_des` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`diet_id`));
  
  -- -----------------------------------------------------
-- Table `absdb`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `absdb`.`role` (
  `role_id` INT(11) NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(45) NOT NULL,
  `role_description` VARCHAR(2000) NOT NULL,
  `shift` TINYINT(11) NOT NULL default 1,
   PRIMARY KEY (`role_id`));



-- -----------------------------------------------------
-- Table `absdb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `absdb`.`user` (
 `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(50) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `password` VARCHAR(500) NOT NULL,
 `salt` VARCHAR(100) ,
  `role_id` INT(11),
  `role_id_first` INT(11),
 `role_id_second` INT(11),
  `reset_password_uuid` VARCHAR(50),
   `photoPath` varchar(300),
   `cell_number` BIGINT(11) NOT NULL,
	`address_id` INT(11),
	`diet_id` INT(11) ,
	`shirt_size` TINYINT(11) ,
	`affiliation_id` INT(11),
	`ticket` INT(11),
	 
  PRIMARY KEY (`user_id`),
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `absdb`.`role`(`role_id`),
  CONSTRAINT `fk_user_role1`
    FOREIGN KEY (`role_id_first`)
    REFERENCES `absdb`.`role`(`role_id`),
  CONSTRAINT `fk_user_role2`
    FOREIGN KEY (`role_id_second`)
    REFERENCES `absdb`.`role`(`role_id`),
 CONSTRAINT `fk_user_address`
    FOREIGN KEY (`address_id`)
    REFERENCES `absdb`.`address`( `address_id`),
 CONSTRAINT `fk_user_affiliation`
    FOREIGN KEY (`affiliation_id`)
    REFERENCES `absdb`.`affiliation`( `affiliation_id`),
 CONSTRAINT `fk_user_diet`
    FOREIGN KEY (`diet_id`)
    REFERENCES `absdb`.`diet`( `diet_id`),
  CONSTRAINT email_unique UNIQUE (`email`)
);

    -- -----------------------------------------------------
-- Table `absdb`.`trade_desc`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `absdb`.`trade_desc` (
  `desc_id` INT(11) NOT NULL AUTO_INCREMENT,
  `desc` VARCHAR(30) NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`desc_id`)
  );

    -- -----------------------------------------------------
-- Table `absdb`.`trade_others`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `absdb`.`trade_others` (
  `trade_others_id` INT(11) NOT NULL AUTO_INCREMENT,
  `desc_id` INT(11) NOT NULL,
  `userId`  INT(11) NOT NULL,
  PRIMARY KEY (`trade_others_id`),
CONSTRAINT `fk_user_trade_other`
  FOREIGN KEY (`userId`)
  REFERENCES `absdb`.`user` (`user_id`),
CONSTRAINT `fk_user_trade_desc`
  FOREIGN KEY (`desc_id`)
  REFERENCES `absdb`.`trade_desc` (`desc_id`)
  );

-- -----------------------------------------------------
-- Table `absdb`.`bike`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `absdb`.`bike` (
  `bike_id` INT(11) NOT NULL AUTO_INCREMENT,
  `bike_index` VARCHAR(50) NOT NULL,
  `user_id` int(11) NOT NULL,
  `photo_path` VARCHAR(200),
   `maker` VARCHAR(20),
   `model` VARCHAR(20),
   `size`  TINYINT(1),
   `price` DOUBLE NOT NULL,
   toSell  TINYINT(1) NOT NULL,
   donate  TINYINT(1) NOT NULL,
   `bike_event_tickets` VARCHAR(30),
   `checked` TINYINT(1),
  `photo` MEDIUMBLOB,
  PRIMARY KEY (`bike_id`),
  CONSTRAINT `fk_bike_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `absdb`.`user` (`user_id`)
   );
	
	-- -----------------------------------------------------
-- Table `absdb`.`bike_trade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `absdb`.`trade` (
  `trade_id` INT(11) NOT NULL AUTO_INCREMENT,
  `bike_id` INT(11) NOT NULL,
 `buyer_id`  INT(11) NOT NULL,
  `trans_date`   DATE NOT NULL,
  `seller_id`  INT(11) NOT NULL,
  PRIMARY KEY (`trade_id`),
  CONSTRAINT `fk_seller_id`
    FOREIGN KEY (`seller_id`)
    REFERENCES `absdb`.`user` (`user_id`),
  CONSTRAINT `fk_buyer_id`
	FOREIGN KEY (`buyer_id`)
    REFERENCES `absdb`.`user` (`user_id`),
 CONSTRAINT `fk_bike_trade`
    FOREIGN KEY (`bike_id`)
    REFERENCES `absdb`.`bike`( `bike_id`)
  
  );

-- -----------------------------------------------------
-- Table `absdb`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `absdb`.`event` (
  `event_id` INT(11) NOT NULL AUTO_INCREMENT,
  `event_desc` VARCHAR(2000) NOT NULL,
 `media_path`  VARCHAR(2000) DEFAULT '1',
  PRIMARY KEY (`event_id`));

-- -----------------------------------------------------
-- Table `absdb`.`event_date`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `absdb`.`event_date` (
  `event_date_id` INT(11) NOT NULL AUTO_INCREMENT,
  `event_id` INT(11) NOT NULL,
 `address_id`  INT(11) NOT NULL,
  start_date   DATE NOT NULL,
  end_date		DATE NOT NULL,
   `schedule_day1` varchar(2000) DEFAULT '8:00-17:00',
  `schedule_day2` varchar(2000) DEFAULT '8:00-17:00',
  `held`       TINYINT(1),
 
  PRIMARY KEY (`event_date_id`),
  CONSTRAINT `fk_event_id`
    FOREIGN KEY (`event_id`)
    REFERENCES `absdb`.`event` (`event_id`),
 CONSTRAINT `fk_event_address`
    FOREIGN KEY (`address_id`)
    REFERENCES `absdb`.`address`( `address_id`)
  
  );


	-- -----------------------------------------------------
-- Table `absdb`.`event_date_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `absdb`.`event_date_user` (
  `event_date_user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `event_date_id` INT(11) NOT NULL,
 `user_id`  INT(11) NOT NULL,
  
  PRIMARY KEY (`event_date_user_id`),
  CONSTRAINT `fk_event_date_user_event_date`
    FOREIGN KEY (`event_date_id`)
    REFERENCES `absdb`.`event_date` (`event_date_id`),
  CONSTRAINT `fk_event_date_user_user`
	FOREIGN KEY (`user_id`)
    REFERENCES `absdb`.`user` (`user_id`)
  );

