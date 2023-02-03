ALTER TABLE `user`
	ADD COLUMN `active` BIT(1) NOT NULL DEFAULT b'1' AFTER `birth_date`;