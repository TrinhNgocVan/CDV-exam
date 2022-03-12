CREATE SCHEMA `csw_exam_cb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;
CREATE TABLE `csw_exam_cb`.`employees` (
                                           `id` INT NOT NULL AUTO_INCREMENT,
                                           `name` VARCHAR(45) NOT NULL,
                                           `salary` DOUBLE NOT NULL,
                                           PRIMARY KEY (`id`));