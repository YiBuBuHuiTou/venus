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

 Date: 10/03/2021 21:14:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tenant
-- ----------------------------
DROP TABLE IF EXISTS `tenant`;
CREATE TABLE `tenant`  (
  `tenant_id` int(32) NOT NULL COMMENT 'UUID',
  `tenant_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '租户ID',
  `owner` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '所属对象',
  `update_date` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`tenant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
