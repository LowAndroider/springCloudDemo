DROP DATABASE IF EXISTS cloudDB01;
CREATE DATABASE cloudDB01 CHARACTER SET UTF8;
USE cloudDB01;

CREATE TABLE `dept` (
  `dept_no` bigint NOT NULL AUTO_INCREMENT,
  `d_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `db_source` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`dept_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO dept(d_name, db_source) VALUES('开发部', DATABASE());
INSERT INTO dept(d_name, db_source) VALUES('人事部', DATABASE());
INSERT INTO dept(d_name, db_source) VALUES('财务部', DATABASE());
INSERT INTO dept(d_name, db_source) VALUES('市场部', DATABASE());
INSERT INTO dept(d_name, db_source) VALUES('运维部', DATABASE());

SELECT * FROM dept;