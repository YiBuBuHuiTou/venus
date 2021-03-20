/*
 Navicat Premium Data Transfer

 Source Server         : venus
 Source Server Type    : MySQL
 Source Server Version : 50568
 Source Host           : 192.168.1.4:3306
 Source Schema         : auth

 Target Server Type    : MySQL
 Target Server Version : 50568
 File Encoding         : 65001

 Date: 20/03/2021 21:50:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for password
-- ----------------------------
DROP TABLE IF EXISTS `password`;
CREATE TABLE `password`  (
  `id` bigint(64) NOT NULL COMMENT 'id',
  `account_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户id',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `create_date` datetime NULL DEFAULT NULL COMMENT '密码创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `check_password_enable`(`account_id`, `password`, `create_date`) USING BTREE COMMENT '检查用户密码是否有效'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
