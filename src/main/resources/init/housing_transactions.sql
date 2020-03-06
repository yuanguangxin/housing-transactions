/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost
 Source Database       : housing_transactions

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : utf-8

 Date: 05/03/2019 00:11:28 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `house`
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `intro` varchar(100) DEFAULT NULL,
  `size` decimal(20,2) DEFAULT NULL,
  `price` decimal(20,2) DEFAULT NULL,
  `layout` varchar(50) DEFAULT NULL,
  `towards` varchar(50) DEFAULT NULL,
  `estate` varchar(50) DEFAULT NULL,
  `floor` varchar(50) DEFAULT NULL,
  `imgs` varchar(500) DEFAULT NULL,
  `detail` varchar(800) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `house`
-- ----------------------------
BEGIN;
INSERT INTO `house` VALUES ('6', '钓鱼台1号院，南北三居室。户型方正看房方便', '钓鱼台7号院，位于阜成路南，俯瞰钓鱼台国宾馆。安静宜居大宅', '348.55', '4980.00', '一室', '朝东', '钓鱼台7号院', '低楼层', 'http://cdn.hrbust.vip/h1.jpg', '测试', '1', '2019-05-02 15:42:07'), ('9', '钓鱼台4号院，南北三居室。户型方正看房方便', '钓鱼台7号院，位于阜成路南，俯瞰钓鱼台国宾馆。安静宜居大宅', '348.55', '4980.00', '二室', '朝南', '钓鱼台7号院', '低楼层', 'http://cdn.hrbust.vip/h1.jpg', '测试', '1', '2019-05-02 15:42:07'), ('10', '钓鱼台5号院，南北三居室。户型方正看房方便', '钓鱼台7号院，位于阜成路南，俯瞰钓鱼台国宾馆。安静宜居大宅', '348.55', '4980.00', '一室', '朝东', '钓鱼台7号院', '低楼层', 'http://cdn.hrbust.vip/h1.jpg', '测试', '7', '2019-05-02 15:42:07'), ('11', '钓鱼台6号院，南北三居室。户型方正看房方便', '钓鱼台7号院，位于阜成路南，俯瞰钓鱼台国宾馆。安静宜居大宅', '348.55', '4980.00', '一室', '朝东', '钓鱼台7号院', '低楼层', 'http://cdn.hrbust.vip/h1.jpg', '测试', '1', '2019-05-02 15:42:07'), ('12', '钓鱼台7号院，南北三居室。户型方正看房方便', '钓鱼台7号院，位于阜成路南，俯瞰钓鱼台国宾馆。安静宜居大宅', '348.55', '4980.00', '一室', '朝东', '钓鱼台7号院', '低楼层', 'http://cdn.hrbust.vip/h1.jpg', '测试', '7', '2019-05-02 15:42:07'), ('30', '钓鱼台2号院，南北三居室。户型方正看房方便', '钓鱼台7号院，位于阜成路南，俯瞰钓鱼台国宾馆。安静宜居大宅', '348.55', '4980.00', '一室', '朝东', '钓鱼台7号院', '低楼层', 'http://cdn.hrbust.vip/h1.jpg', '测试', '1', '2019-05-02 15:42:07'), ('31', '钓鱼台3号院，南北三居室。户型方正看房方便', '钓鱼台7号院，位于阜成路南，俯瞰钓鱼台国宾馆。安静宜居大宅', '348.55', '4980.00', '一室', '朝东', '钓鱼台7号院', '低楼层', 'http://cdn.hrbust.vip/h1.jpg', '测试', '7', '2019-05-02 15:42:07'), ('32', '钓鱼台4号院，南北三居室。户型方正看房方便', '钓鱼台7号院，位于阜成路南，俯瞰钓鱼台国宾馆。安静宜居大宅', '348.55', '4980.00', '二室', '朝南', '钓鱼台7号院', '低楼层', 'http://cdn.hrbust.vip/h1.jpg', '测试', '1', '2019-05-02 15:42:07'), ('33', '钓鱼台5号院，南北三居室。户型方正看房方便', '钓鱼台7号院，位于阜成路南，俯瞰钓鱼台国宾馆。安静宜居大宅', '348.55', '4980.00', '一室', '朝东', '钓鱼台7号院', '低楼层', 'http://cdn.hrbust.vip/h1.jpg', '测试', '7', '2019-05-02 15:42:07'), ('34', '钓鱼台6号院，南北三居室。户型方正看房方便', '钓鱼台7号院，位于阜成路南，俯瞰钓鱼台国宾馆。安静宜居大宅', '348.55', '4980.00', '一室', '朝东', '钓鱼台7号院', '低楼层', 'http://cdn.hrbust.vip/h1.jpg', '测试', '1', '2019-05-02 15:42:07'), ('35', '钓鱼台7号院，南北三居室。户型方正看房方便', '钓鱼台7号院，位于阜成路南，俯瞰钓鱼台国宾馆。安静宜居大宅', '100.34', '598.00', '一室', '朝东', '钓鱼台7号院', '低楼层', 'http://cdn.hrbust.vip/h1.jpg;http://cdn.hrbust.vip/h1.jpg', '测试', '7', '2019-05-02 15:42:07');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `intro` varchar(200) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', '米艳如', '123456', '经常带人看房，了解房屋特色', '18324601102', '1254841425@qq.com', '男', '123'), ('7', '米艳如2', '123456', '经常带人看房，了解房屋特色', '18324601102', '1254841425@qq.com', '男', '123'), ('12', '1', '111111', null, null, null, null, null), ('13', '2', '222222', null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `watch`
-- ----------------------------
DROP TABLE IF EXISTS `watch`;
CREATE TABLE `watch` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `house_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `watch`
-- ----------------------------
BEGIN;
INSERT INTO `watch` VALUES ('1', '1', '35'), ('3', '13', '35');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
