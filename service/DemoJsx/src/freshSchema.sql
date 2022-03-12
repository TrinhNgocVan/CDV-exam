CREATE SCHEMA `csw_exam_cb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;
CREATE TABLE `csw_exam_cb`.`employees` (
                                           `id` INT NOT NULL AUTO_INCREMENT,
                                           `name` VARCHAR(45) NOT NULL,
                                           `salary` DOUBLE NOT NULL,
                                           PRIMARY KEY (`id`));


/* add data */
INSERT INTO `csw_exam_cb`.`employees` (`id`, `name`, `salary`) VALUES ('', 'Trinh Ngoc Van', '10000');
INSERT INTO `csw_exam_cb`.`employees` (`name`, `salary`) VALUES ('Nguyen Ngoc Tien', '10000');
INSERT INTO `csw_exam_cb`.`employees` (`name`, `salary`) VALUES ('Nguyen Trong Tuan', '10000');
INSERT INTO `csw_exam_cb`.`employees` (`name`, `salary`) VALUES ('Mai Thanh Vinh', '10000');
INSERT INTO `csw_exam_cb`.`employees` (`name`, `salary`) VALUES ('Cao vuong Bach', '10000');
