-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema SchoolDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SchoolDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SchoolDB` DEFAULT CHARACTER SET utf8 ;
USE `SchoolDB` ;

-- -----------------------------------------------------
-- Table `SchoolDB`.`Tbl_Ogretmen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SchoolDB`.`Tbl_Ogretmen` (
  `Ogretmen_id` INT NOT NULL AUTO_INCREMENT,
  `Ogretmen_Adi` VARCHAR(45) NULL,
  `Ogretmen_Soyadi` VARCHAR(45) NULL,
  `Verdigi_Ders` VARCHAR(45) NULL,
  `Verdigi_Sinif` NVARCHAR(10) NULL,
  `Gun` VARCHAR(20) NULL,
  `Baslama_Saati` TIME NULL,
  `Bitis_Saati` TIME NULL,
  PRIMARY KEY (`Ogretmen_id`),
  UNIQUE INDEX `Ogretmen_id_UNIQUE` (`Ogretmen_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SchoolDB`.`Tbl_Ogrenci`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SchoolDB`.`Tbl_Ogrenci` (
  `Ogrenci_id` INT NOT NULL AUTO_INCREMENT,
  `Ogrenci_Adi` VARCHAR(45) NULL,
  `Ogrenci_Soyadi` VARCHAR(45) NULL,
  `Sinif` NVARCHAR(10) NULL,
  `Aldigi_Ders` VARCHAR(45) NULL,
  `Gun` VARCHAR(20) NULL,
  `Baslama_Saati` TIME NULL,
  `Bitis_Saati` TIME NULL,
  `Ogretmen_Adi` VARCHAR(45) NULL,
  PRIMARY KEY (`Ogrenci_id`),
  UNIQUE INDEX `Ogrenci_id_UNIQUE` (`Ogrenci_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SchoolDB`.`Tbl_Ders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SchoolDB`.`Tbl_Ders` (
  `Ders_id` INT NOT NULL AUTO_INCREMENT,
  `Ders_Ad` VARCHAR(45) NULL,
  `Gun` VARCHAR(20) NULL,
  `Baslama_Saati` TIME NULL,
  `Bitis_Saati` TIME NULL,
  `Ogretmen_Adi` VARCHAR(45) NULL,
  `Sinif` NVARCHAR(10) NULL,
  `FK_Ogrenci_id` INT NULL,
  `FK_Ogretmen_id` INT NULL,
  PRIMARY KEY (`Ders_id`),
  UNIQUE INDEX `Ders_id_UNIQUE` (`Ders_id` ASC) VISIBLE,
  INDEX `fk_Tbl_Ders_Tbl_Ogrenci_idx` (`FK_Ogrenci_id` ASC) VISIBLE,
  INDEX `fk_Tbl_Ders_Tbl_Ogretmen1_idx` (`FK_Ogretmen_id` ASC) VISIBLE,
  CONSTRAINT `fk_Tbl_Ders_Tbl_Ogrenci`
    FOREIGN KEY (`FK_Ogrenci_id`)
    REFERENCES `SchoolDB`.`Tbl_Ogrenci` (`Ogrenci_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tbl_Ders_Tbl_Ogretmen1`
    FOREIGN KEY (`FK_Ogretmen_id`)
    REFERENCES `SchoolDB`.`Tbl_Ogretmen` (`Ogretmen_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
