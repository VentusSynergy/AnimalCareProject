-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema vetdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `vetdb` ;

-- -----------------------------------------------------
-- Schema vetdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `vetdb` DEFAULT CHARACTER SET utf8 ;
USE `vetdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL DEFAULT 'patient',
  `phone` VARCHAR(45) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pet` ;

CREATE TABLE IF NOT EXISTS `pet` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `health` VARCHAR(300) NOT NULL DEFAULT 'Healthy',
  `custody` VARCHAR(45) NOT NULL DEFAULT 'Home',
  `user_id` INT NOT NULL,
  `species` VARCHAR(45) NOT NULL,
  `breed` VARCHAR(45) NOT NULL,
  `fixed` TINYINT NULL,
  `gender` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_id_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `appointment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `appointment` ;

CREATE TABLE IF NOT EXISTS `appointment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `time_of_appointment` DATETIME NOT NULL,
  `type` TEXT NOT NULL,
  `urgency` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NULL,
  `pet_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pet_id_idx` (`pet_id` ASC),
  CONSTRAINT `fk_pet_id`
    FOREIGN KEY (`pet_id`)
    REFERENCES `pet` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `vetdb` ;

-- -----------------------------------------------------
-- Placeholder table for view `view1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `view1` (`id` INT);

-- -----------------------------------------------------
-- View `view1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `view1`;
DROP VIEW IF EXISTS `view1` ;
USE `vetdb`;

SET SQL_MODE = '';
DROP USER IF EXISTS doc@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'doc'@'localhost' IDENTIFIED BY 'bugs';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'doc'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `vetdb`;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `address`, `role`, `phone`, `password`, `enabled`) VALUES (1, 'Kullen', 'Kee', 'admin@admin.gmail.com', '555 Railroad way', 'admin', '999-999-9999', '$2a$10$KMIQ9vF8CXH7U2Nqn3wTV.dUq0EzW94gzEvT7yb6rx9fuyFyY6OSS', 1);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `address`, `role`, `phone`, `password`, `enabled`) VALUES (2, 'Nelson', 'Fritt', 'Fritt.Nelson@gmail.com', '784 Founders Dr', 'staff', '999-999-9999', '$2a$10$KMIQ9vF8CXH7U2Nqn3wTV.dUq0EzW94gzEvT7yb6rx9fuyFyY6OSS', 1);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `address`, `role`, `phone`, `password`, `enabled`) VALUES (3, 'Jessica', 'Heilman', 'Heilman.Jessica@gmail.com', '3999 Elmers Ln', 'staff', '999-999-9999', '$2a$10$KMIQ9vF8CXH7U2Nqn3wTV.dUq0EzW94gzEvT7yb6rx9fuyFyY6OSS', 1);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `address`, `role`, `phone`, `password`, `enabled`) VALUES (4, 'Grant', 'Lynn', 'Lynn.Grant@gmail.com', '544 Grant Dr', 'staff', '999-999-9999', '$2a$10$KMIQ9vF8CXH7U2Nqn3wTV.dUq0EzW94gzEvT7yb6rx9fuyFyY6OSS', 1);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `address`, `role`, `phone`, `password`, `enabled`) VALUES (5, 'Max', 'Freeman', 'Freeman.Max@gmail.com', '999 Linter Ln', 'patient', '999-999-9999', '$2a$10$KMIQ9vF8CXH7U2Nqn3wTV.dUq0EzW94gzEvT7yb6rx9fuyFyY6OSS', 1);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `address`, `role`, `phone`, `password`, `enabled`) VALUES (6, 'Henry', 'Strait', 'Strait.Henry@gmail', '4898 Fernwood Pl', 'patient', '999-999-9999', '$2a$10$KMIQ9vF8CXH7U2Nqn3wTV.dUq0EzW94gzEvT7yb6rx9fuyFyY6OSS', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `pet`
-- -----------------------------------------------------
START TRANSACTION;
USE `vetdb`;
INSERT INTO `pet` (`id`, `name`, `health`, `custody`, `user_id`, `species`, `breed`, `fixed`, `gender`) VALUES (1, 'Luna', 'Unwell - Has a hurt foot', 'Home', 5, 'Rabbit', 'Holland Lop', 0, 'F');
INSERT INTO `pet` (`id`, `name`, `health`, `custody`, `user_id`, `species`, `breed`, `fixed`, `gender`) VALUES (2, 'Snow', 'Healthy', 'Home', 5, 'Rabbit', 'Holland Lop', 1, 'M');
INSERT INTO `pet` (`id`, `name`, `health`, `custody`, `user_id`, `species`, `breed`, `fixed`, `gender`) VALUES (3, 'Katana', 'Healthy - Spaying procedure complete, ready to be picked up', 'Clinic', 5, 'Dog', 'Great Dane', 1, 'F');
INSERT INTO `pet` (`id`, `name`, `health`, `custody`, `user_id`, `species`, `breed`, `fixed`, `gender`) VALUES (4, 'George', 'Unwell - Has a tumor on front right leg', 'Clinic', 6, 'Dog', 'Pug', 1, 'M');
INSERT INTO `pet` (`id`, `name`, `health`, `custody`, `user_id`, `species`, `breed`, `fixed`, `gender`) VALUES (5, 'Nea', 'Healthy', 'Home', 6, 'Cat', 'Sphynx', 0, 'F');

COMMIT;


-- -----------------------------------------------------
-- Data for table `appointment`
-- -----------------------------------------------------
START TRANSACTION;
USE `vetdb`;
INSERT INTO `appointment` (`id`, `time_of_appointment`, `type`, `urgency`, `status`, `pet_id`) VALUES (1, '2019-04-03', 'Exam - Has hurt foot', 'Moderate', 'Awaiting', 1);
INSERT INTO `appointment` (`id`, `time_of_appointment`, `type`, `urgency`, `status`, `pet_id`) VALUES (2, '2019-03-29', 'Spay/Neuter', 'Low', 'Complete', 3);
INSERT INTO `appointment` (`id`, `time_of_appointment`, `type`, `urgency`, `status`, `pet_id`) VALUES (3, '2019-03-16', 'Exam', 'Moderate', 'Complete', 4);
INSERT INTO `appointment` (`id`, `time_of_appointment`, `type`, `urgency`, `status`, `pet_id`) VALUES (4, '2019-01-03', 'Surgery - Leg amputation', 'Severe', 'Complete', 5);

COMMIT;

