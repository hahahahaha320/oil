/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.25-log : Database - book_store
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book_store` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `book_store`;

/*Table structure for table `author` */

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `author` */

insert  into `author`(`id`,`name`,`birthday`,`create_time`) values (1,'John','1985-11-08','2019-11-08 18:31:39'),(2,'Mike','1985-11-10','2019-11-08 18:31:47');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `book_detail_id` int(11) DEFAULT NULL,
  `press_id` int(11) DEFAULT NULL COMMENT '出版社id',
  `state` varchar(10) NOT NULL DEFAULT 'ok' COMMENT '状态:ok,no',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`name`,`book_detail_id`,`press_id`,`state`,`create_time`) values (1,'java编程思想',1,1,'ok','2019-11-07 18:30:47'),(2,'C++ prime',2,1,'ok','2019-11-12 17:29:06'),(5,'计算机原理11111',8,1,'ok','2019-11-12 18:01:36');

/*Table structure for table `book_author` */

DROP TABLE IF EXISTS `book_author`;

CREATE TABLE `book_author` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `book_id` int(11) DEFAULT NULL COMMENT '书本id',
  `author_id` int(11) DEFAULT NULL COMMENT '作者id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `book_author` */

insert  into `book_author`(`id`,`book_id`,`author_id`,`create_time`) values (1,1,1,'2019-11-08 18:14:07'),(2,1,2,'2019-11-08 18:14:08');

/*Table structure for table `book_detail` */

DROP TABLE IF EXISTS `book_detail`;

CREATE TABLE `book_detail` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `descr` varchar(5000) DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `book_detail` */

insert  into `book_detail`(`id`,`descr`,`create_time`) values (1,'java编程是想是一本好书','2019-11-08 17:06:53'),(2,'java编程是想是一本好书222','2019-11-08 17:36:14'),(8,'计算机原理计算机原理计算机原理计算机原理111','2019-11-12 18:01:36');

/*Table structure for table `chapter` */

DROP TABLE IF EXISTS `chapter`;

CREATE TABLE `chapter` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `book_id` int(11) DEFAULT NULL COMMENT '书本id',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `chapter` */

insert  into `chapter`(`id`,`book_id`,`title`,`create_time`) values (1,1,'环境安装','2019-11-08 17:48:12'),(2,1,'jdk模块详解','2019-11-08 17:48:13');

/*Table structure for table `press` */

DROP TABLE IF EXISTS `press`;

CREATE TABLE `press` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(20) DEFAULT NULL COMMENT '名字',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `press` */

insert  into `press`(`id`,`name`,`create_time`) values (1,'长江出版社','2019-11-08 17:47:43'),(2,'清华大学出版社','2019-11-12 18:01:17');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
