-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema kothawala
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema kothawala
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kothawala` DEFAULT CHARACTER SET latin1 ;
USE `kothawala` ;

-- -----------------------------------------------------
-- Table `kothawala`.`agent_passwords010`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kothawala`.`agent_passwords010` (
  `username010` VARCHAR(255) NOT NULL,
  `password010` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`username010`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `kothawala`.`client_user010`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kothawala`.`client_user010` (
  `client_comp_id010` INT(11) NOT NULL,
  `client_city010` VARCHAR(255) NULL DEFAULT NULL,
  `client_comp_name010` VARCHAR(255) NULL DEFAULT NULL,
  `client_comp_password010` VARCHAR(255) NULL DEFAULT NULL,
  `money_owed010` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`client_comp_id010`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `kothawala`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kothawala`.`hibernate_sequence` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `kothawala`.`parts010`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kothawala`.`parts010` (
  `part_no010` INT(11) NOT NULL,
  `current_price010` FLOAT NULL DEFAULT NULL,
  `part_description010` VARCHAR(255) NULL DEFAULT NULL,
  `part_name010` VARCHAR(255) NULL DEFAULT NULL,
  `qty010` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`part_no010`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `kothawala`.`pos010`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kothawala`.`pos010` (
  `po_no010` INT(11) NOT NULL,
  `datepo010` DATETIME NULL DEFAULT NULL,
  `status010` VARCHAR(255) NULL DEFAULT NULL,
  `client_comp_id010` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`po_no010`),
  INDEX `FKs2udroys7fb9b97jo2dytne8y` (`client_comp_id010` ASC),
  CONSTRAINT `FKs2udroys7fb9b97jo2dytne8y`
    FOREIGN KEY (`client_comp_id010`)
    REFERENCES `kothawala`.`client_user010` (`client_comp_id010`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `kothawala`.`po_lines010`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kothawala`.`po_lines010` (
  `line_no010` INT(11) NOT NULL,
  `line_price010` FLOAT NULL DEFAULT NULL,
  `part_no010` INT(11) NULL DEFAULT NULL,
  `po_no010` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`line_no010`),
  INDEX `FKm4ismg0ptn9j6dtbm3i3duwy` (`part_no010` ASC),
  INDEX `FKo3m5yoqs296f870gg9cjkhecf` (`po_no010` ASC),
  CONSTRAINT `FKm4ismg0ptn9j6dtbm3i3duwy`
    FOREIGN KEY (`part_no010`)
    REFERENCES `kothawala`.`parts010` (`part_no010`),
  CONSTRAINT `FKo3m5yoqs296f870gg9cjkhecf`
    FOREIGN KEY (`po_no010`)
    REFERENCES `kothawala`.`pos010` (`po_no010`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- -----------------------------------------------------
-- Table `kothawala`.`agent010`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `kothawala`.`agent010` (
  `agent_user_name010` VARCHAR(255) NULL DEFAULT NULL,
  `agent_password010` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`agent_user_name010`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
