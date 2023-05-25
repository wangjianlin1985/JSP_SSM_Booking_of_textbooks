/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.23-log : Database - teachingmaterial
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`teachingmaterial` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `teachingmaterial`;

/*Table structure for table `t_admin` */

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_admin` */

insert  into `t_admin`(`id`,`username`,`password`) values (1,'admin','admin');

/*Table structure for table `t_book` */

DROP TABLE IF EXISTS `t_book`;

CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book` varchar(100) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `num` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_book` */

insert  into `t_book`(`id`,`book`,`type_id`,`content`,`num`) values (7,'java基础语言',3,'java是一门编程语言','0'),(8,'数据库基础语言',3,'Mysql数据库','177');

/*Table structure for table `t_class` */

DROP TABLE IF EXISTS `t_class`;

CREATE TABLE `t_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `class_name` varchar(255) DEFAULT NULL COMMENT '班级名称',
  `serie_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_class` */

insert  into `t_class`(`id`,`class_name`,`serie_id`) values (9,'159000215班',6),(10,'123',6);

/*Table structure for table `t_course` */

DROP TABLE IF EXISTS `t_course`;

CREATE TABLE `t_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `course_name` varchar(255) DEFAULT NULL COMMENT '课程名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_course` */

insert  into `t_course`(`id`,`course_name`) values (4,'java基础');

/*Table structure for table `t_inventory` */

DROP TABLE IF EXISTS `t_inventory`;

CREATE TABLE `t_inventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `num` varchar(100) DEFAULT NULL,
  `user_id` int(100) DEFAULT NULL,
  `rol_id` varchar(100) DEFAULT NULL,
  `create_time` varchar(100) DEFAULT NULL,
  `invent` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_inventory` */

insert  into `t_inventory`(`id`,`book_id`,`status`,`num`,`user_id`,`rol_id`,`create_time`,`invent`) values (3,4,'出库','34',4,'1','2019-03-07 01:03:26',NULL),(4,6,'出库','1',4,'1','2019-03-08 11:36:15',NULL),(5,8,'出库','20',9,'1','2019-03-08 14:48:03',NULL),(6,7,'出库','123',9,'1','2019-03-08 22:42:57',NULL),(7,7,'出库','7',9,'1','2019-03-08 23:03:02','60'),(8,7,'出库','1',9,'1','2019-03-09 18:55:52','59'),(9,7,'出库','2',9,'1','2019-03-09 19:01:18','57'),(10,7,'出库','57',9,'1','2019-03-09 21:46:21','0');

/*Table structure for table `t_menus` */

DROP TABLE IF EXISTS `t_menus`;

CREATE TABLE `t_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(100) DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `close` varchar(100) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_menus` */

insert  into `t_menus`(`id`,`text`,`icon`,`url`,`close`,`pid`) values (1,'首页',NULL,NULL,'false',0),(2,'菜单1',NULL,NULL,'false',0),(3,'菜单二',NULL,NULL,'false',0),(4,'菜单11',NULL,NULL,'false',2),(5,'菜单21',NULL,NULL,'false',3);

/*Table structure for table `t_notice` */

DROP TABLE IF EXISTS `t_notice`;

CREATE TABLE `t_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '通知标题',
  `content` varchar(255) DEFAULT NULL COMMENT '通知内容',
  `create_date` datetime DEFAULT NULL COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_notice` */

insert  into `t_notice`(`id`,`title`,`content`,`create_date`) values (3,'好消息','60周年庆','2018-11-09 21:01:31'),(4,'ad','asdasd','2018-11-09 21:04:47');

/*Table structure for table `t_profession` */

DROP TABLE IF EXISTS `t_profession`;

CREATE TABLE `t_profession` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `profession_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_profession` */

insert  into `t_profession`(`id`,`profession_name`) values (4,'软件工程');

/*Table structure for table `t_receive` */

DROP TABLE IF EXISTS `t_receive`;

CREATE TABLE `t_receive` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `rol_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `amount` varchar(100) DEFAULT NULL,
  `create_time` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `t_receive` */

insert  into `t_receive`(`id`,`user_id`,`rol_id`,`book_id`,`amount`,`create_time`,`status`,`content`) values (4,4,1,4,'34','2019-03-07 01:02:08','2','234'),(5,4,1,5,'23','2019-03-07 01:02:32','3','eeee'),(6,4,1,6,'1','2019-03-08 11:35:35','2','11'),(7,4,2,7,'1','2019-03-08 15:00:16','3','java是一门编程语言'),(8,9,1,8,'20','2019-03-08 14:47:17','2','我是1590002班班长，我代表我们班领取我们班上数据库基础语言这本书'),(9,9,1,7,'123','2019-03-08 22:40:41','2','java是一门编程语言'),(10,9,1,8,'23','2019-03-08 22:41:27','3','Mysql数据库'),(11,10,1,7,'7','2019-03-08 22:42:08','3','java是一门编程语言'),(12,9,1,7,'7','2019-03-08 23:02:21','2','java是一门编程语言'),(13,9,1,7,'1','2019-03-09 18:52:15','2','java是一门编程语言'),(14,9,1,7,'2','2019-03-09 18:58:49','2','java是一门编程语言'),(15,9,1,7,'57','2019-03-09 21:45:53','2','java是一门编程语言');

/*Table structure for table `t_room` */

DROP TABLE IF EXISTS `t_room`;

CREATE TABLE `t_room` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `room_name` varchar(255) DEFAULT NULL COMMENT '教室名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_room` */

insert  into `t_room`(`id`,`room_name`) values (8,'第六教215');

/*Table structure for table `t_score` */

DROP TABLE IF EXISTS `t_score`;

CREATE TABLE `t_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `score_title` varchar(255) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `stu_id` int(11) DEFAULT NULL,
  `tea_id` int(11) DEFAULT NULL,
  `score` varchar(255) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_score` */

insert  into `t_score`(`id`,`score_title`,`course_id`,`stu_id`,`tea_id`,`score`,`create_date`) values (1,'123',2,NULL,NULL,'123','2018-11-10 18:41:32'),(2,'123',2,NULL,NULL,'123','2018-11-10 18:42:19'),(3,'2018年第二学期实训',4,9,4,'80','2019-03-08 14:59:24');

/*Table structure for table `t_serie` */

DROP TABLE IF EXISTS `t_serie`;

CREATE TABLE `t_serie` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `serie_name` varchar(255) DEFAULT NULL COMMENT '系名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_serie` */

insert  into `t_serie`(`id`,`serie_name`) values (6,'软件与计算机学院');

/*Table structure for table `t_student` */

DROP TABLE IF EXISTS `t_student`;

CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_no` varchar(255) DEFAULT NULL,
  `stu_name` varchar(255) DEFAULT NULL,
  `stu_age` varchar(255) DEFAULT NULL,
  `stu_sex` varchar(255) DEFAULT NULL,
  `serie_id` int(11) DEFAULT NULL,
  `profession_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `enter_school` date DEFAULT NULL,
  `term_id` int(11) DEFAULT NULL,
  `stu_pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_student` */

insert  into `t_student`(`id`,`stu_no`,`stu_name`,`stu_age`,`stu_sex`,`serie_id`,`profession_id`,`class_id`,`phone`,`enter_school`,`term_id`,`stu_pwd`) values (9,'159000215','谭军','23','1',6,4,9,'15736511470','2019-03-08',20,'123456'),(10,'159000216','汪茂胜','23','1',6,4,9,'15736511463','2019-03-08',20,'123456');

/*Table structure for table `t_teacher` */

DROP TABLE IF EXISTS `t_teacher`;

CREATE TABLE `t_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_no` varchar(255) DEFAULT NULL,
  `tea_name` varchar(255) DEFAULT NULL,
  `tea_age` varchar(255) DEFAULT NULL,
  `tea_sex` varchar(255) DEFAULT NULL,
  `tea_phone` varchar(255) DEFAULT NULL,
  `profession_id` int(11) DEFAULT NULL,
  `tea_pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_teacher` */

insert  into `t_teacher`(`id`,`tea_no`,`tea_name`,`tea_age`,`tea_sex`,`tea_phone`,`profession_id`,`tea_pwd`) values (4,'159000115','王义峰','36','1','15736511471',4,'123456'),(5,'159000116','火明刚','36','1','18166334692',4,'123456');

/*Table structure for table `t_term` */

DROP TABLE IF EXISTS `t_term`;

CREATE TABLE `t_term` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `term_name` varchar(255) DEFAULT NULL COMMENT '学期名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `t_term` */

insert  into `t_term`(`id`,`term_name`) values (20,'2019年第二学期');

/*Table structure for table `t_type` */

DROP TABLE IF EXISTS `t_type`;

CREATE TABLE `t_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_type` */

insert  into `t_type`(`id`,`type_name`) values (3,'计算机'),(4,'音乐');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
