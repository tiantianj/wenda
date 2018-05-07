/*
Navicat MySQL Data Transfer

Source Server         : mypc
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : wenda

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-05-07 09:28:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '回答id',
  `content` varchar(10000) DEFAULT NULL COMMENT '回答内容',
  `userid` int(11) DEFAULT NULL COMMENT '回答人id',
  `questionid` int(11) DEFAULT NULL COMMENT '对应问题id',
  `time` datetime DEFAULT NULL COMMENT '回答时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回答表';

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `name` varchar(20) DEFAULT NULL COMMENT '分类名称',
  `pid` int(11) DEFAULT NULL COMMENT '父分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类表';

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL COMMENT '主键',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `userid` int(11) DEFAULT NULL COMMENT '评论用户id',
  `answerid` int(11) DEFAULT NULL COMMENT '对应回答id',
  `time` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Table structure for like
-- ----------------------------
DROP TABLE IF EXISTS `like`;
CREATE TABLE `like` (
  `id` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL COMMENT '点赞用户id',
  `islike` tinyint(1) DEFAULT NULL COMMENT '标志位，0点赞，1踩',
  `answerid` int(11) DEFAULT NULL COMMENT '回答/评论的id',
  `isanswer` tinyint(1) DEFAULT NULL COMMENT '标志位 0是回答点赞  1是评论点赞',
  `time` datetime DEFAULT NULL COMMENT '设置时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='点赞表';

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问题主键',
  `title` varchar(50) DEFAULT NULL COMMENT '问题标题，不超过45字',
  `description` varchar(500) DEFAULT NULL COMMENT '问题描述，不超过500字',
  `userid` int(11) DEFAULT NULL COMMENT '发表问题的用户',
  `picture` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `categoryid` int(11) DEFAULT NULL COMMENT '分类id',
  `time` datetime DEFAULT NULL COMMENT '提问发表时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问题表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，用户Id',
  `loginname` varchar(30) DEFAULT NULL COMMENT '用户登录名',
  `nickname` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `icon` varchar(255) DEFAULT NULL COMMENT '头像',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `introduction` varchar(255) DEFAULT NULL COMMENT '个人介绍',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
