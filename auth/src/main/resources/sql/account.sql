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

 Date: 14/03/2021 19:38:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `account_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'UUID',
  `tenant_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '租户ID',
  `account_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户ID',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '描述',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户密码',
  `privilege` int(32) NULL DEFAULT NULL COMMENT '权限',
  `security_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '秘钥',
  `update_date` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`account_id`) USING BTREE,
  UNIQUE INDEX `UK_m6p4a30gkdokavjyjeoffud3t`(`account_name`) USING BTREE,
  UNIQUE INDEX `check_for_tenant_password`(`tenant_id`, `account_name`, `password`) USING BTREE,
  INDEX `check_for_account_password`(`account_name`, `password`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
