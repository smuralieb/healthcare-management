
CREATE TABLE `user_registration`(
  `user_id` BIGINT AUTO_INCREMENT PRIMARY KEY ,
  `name` VARCHAR(255) NOT NULL,
  `activation_tatus` TINYINT(1) DEFAULT 'INACTIVE',
  `date_of_birth` DATE NOT NULL,
  `phone_number` VARCHAR (20),
  `last_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `enrolle_dependent_registration`(
  `dep_id` BIGINT AUTO_INCREMENT PRIMARY KEY ,
  `name` VARCHAR(255) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `user_id` BIGINT NOT NULL,
  `last_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT `frn_dep_user_id` FOREIGN KEY(`user_id`) REFERENCES `user_registration`(`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
