/*
Navicat MySQL Data Transfer

Source Server         : 94.191.60.104
Source Server Version : 50644
Source Host           : 94.191.60.104:3306
Source Database       : education

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2019-08-05 21:29:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_app_version
-- ----------------------------
DROP TABLE IF EXISTS `t_app_version`;
CREATE TABLE `t_app_version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `app_name` varchar(50) NOT NULL COMMENT 'app的名字',
  `download_url` varchar(255) NOT NULL,
  `version_code` int(11) NOT NULL,
  `version_name` varchar(80) NOT NULL,
  `release_note` text NOT NULL,
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_app_version
-- ----------------------------
INSERT INTO `t_app_version` VALUES ('1', 'app_pad', 'dsfdfdsfdsf', '1', '111', '111', null, null, '2019-07-20 20:10:30', '2019-07-22 12:47:51', '1');

-- ----------------------------
-- Table structure for t_class_mate
-- ----------------------------
DROP TABLE IF EXISTS `t_class_mate`;
CREATE TABLE `t_class_mate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sn` varchar(50) NOT NULL COMMENT '班级编号',
  `name` varchar(50) NOT NULL COMMENT '班级名称',
  `description` text COMMENT '班级描述',
  `is_deleted` tinyint(4) NOT NULL COMMENT '是否已经删除',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='班级信息';

-- ----------------------------
-- Records of t_class_mate
-- ----------------------------
INSERT INTO `t_class_mate` VALUES ('1', '111', '实验一班1', '112222', '0', null, '1', '2019-07-11 13:44:54', '2019-07-25 16:13:49', '1');
INSERT INTO `t_class_mate` VALUES ('2', '1', '实验二班', '1', '0', null, null, '2019-07-11 13:45:28', '2019-07-11 13:46:14', '1');
INSERT INTO `t_class_mate` VALUES ('3', '2', '实验三班', '1', '0', null, null, '2019-07-11 13:45:55', '2019-07-11 13:45:55', '1');
INSERT INTO `t_class_mate` VALUES ('4', '111', '111', '111', '0', '1', '1', '2019-07-23 11:17:27', '2019-07-23 11:17:27', '1');
INSERT INTO `t_class_mate` VALUES ('5', '111', '111', '111222', '0', '1', '1', '2019-07-23 11:17:43', '2019-07-25 16:14:23', '1');

-- ----------------------------
-- Table structure for t_class_room_info
-- ----------------------------
DROP TABLE IF EXISTS `t_class_room_info`;
CREATE TABLE `t_class_room_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '班级名称',
  `description` text COMMENT '描述',
  `address` varchar(255) NOT NULL COMMENT '教室位置的具体信息',
  `sn` varchar(50) NOT NULL COMMENT '班级编号',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  `is_deleted` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sn` (`sn`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='教室内容信息';

-- ----------------------------
-- Records of t_class_room_info
-- ----------------------------
INSERT INTO `t_class_room_info` VALUES ('1', '实验三班', '浙江省杭州市江干区实验中学三班', '浙江省杭州市江干区实验中学三班', '123hi', null, '1', '2019-07-08 15:14:42', '2019-07-27 23:09:46', '1', '0');
INSERT INTO `t_class_room_info` VALUES ('2', '111', '213213', '2132132123', '111', '1', '1', '2019-07-27 23:10:59', '2019-07-27 23:10:59', '1', '0');

-- ----------------------------
-- Table structure for t_command_info
-- ----------------------------
DROP TABLE IF EXISTS `t_command_info`;
CREATE TABLE `t_command_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `course_id` bigint(20) NOT NULL COMMENT '课程ID',
  `direction` tinyint(4) NOT NULL COMMENT '方向0：表示老师发给学生，1：学生发给老师',
  `operation_name` varchar(80) NOT NULL COMMENT '命令发送者的名字',
  `operation_id` bigint(20) NOT NULL COMMENT '命令的发送方ID',
  `command_type` tinyint(4) NOT NULL COMMENT '命令类型0：广播，1：交互，2：请假',
  `content` text COMMENT '命令内容',
  `sn` varchar(45) NOT NULL COMMENT '命令编号，如老师发送命令，学生接收命令那么这个编码是一样的',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='信息交互表主要用于各种命令的信息交互';

-- ----------------------------
-- Records of t_command_info
-- ----------------------------
INSERT INTO `t_command_info` VALUES ('1', '1', '1', '1', '1', '6', '{\"machineId\":1,\"teacherId\":1}', '15508F1F152843159B9F5BBAB403856A', '1', '1', '2019-07-14 20:32:38', '2019-07-14 20:32:38', '1');
INSERT INTO `t_command_info` VALUES ('2', '1', '1', '1', '1', '6', '{\"machineId\":1,\"teacherId\":1}', '87A688A4BD4C4C8BB706CDDF5396ADFA', '1', '1', '2019-07-14 20:41:58', '2019-07-14 20:41:58', '1');
INSERT INTO `t_command_info` VALUES ('3', '1', '1', '1', '1', '6', '{\"machineId\":1,\"teacherId\":1}', 'EE6D18DDF271488F88C7DC5A86FB6A67', '1', '1', '2019-07-14 20:50:59', '2019-07-14 20:50:59', '1');
INSERT INTO `t_command_info` VALUES ('4', '1', '1', '1', '1', '6', '{\"machineId\":1,\"teacherId\":1}', '1B236DE49EA04FE284AEA8687A70912D', '1', '1', '2019-07-14 20:57:19', '2019-07-14 20:57:19', '1');
INSERT INTO `t_command_info` VALUES ('5', '1', '1', '1', '1', '6', '{\"machineId\":1,\"teacherId\":1}', 'B982B86EC2D4499D839B38D9A8B79439', '1', '1', '2019-07-14 20:58:20', '2019-07-14 20:58:20', '1');
INSERT INTO `t_command_info` VALUES ('6', '1', '1', '1', '1', '6', '{\"machineId\":1,\"teacherId\":1}', '1955B612A5B84280A8BB5662453B921B', '1', '1', '2019-07-14 21:00:32', '2019-07-14 21:00:32', '1');
INSERT INTO `t_command_info` VALUES ('7', '1', '1', '1', '1', '6', '{\"machineId\":1,\"teacherId\":1}', 'B2CCC16E5CC14EE18AB21E6C881F1C6D', '1', '1', '2019-07-14 21:09:25', '2019-07-14 21:09:25', '1');
INSERT INTO `t_command_info` VALUES ('8', '1', '0', 'login', '3', '5', null, '8FC6DA12943D48E38C902C84C1EFB295', '3', '3', '2019-07-16 11:00:44', '2019-07-16 11:00:44', '1');
INSERT INTO `t_command_info` VALUES ('9', '1', '0', 'login', '3', '5', null, '1319CCEA5D4A494691B69015B7AEC172', '3', '3', '2019-07-16 11:04:15', '2019-07-16 11:04:15', '1');
INSERT INTO `t_command_info` VALUES ('10', '2', '0', 'login', '3', '1', null, '0C433C04BDCE421E9610B50E54B0DD55', '3', '3', '2019-07-26 15:33:52', '2019-07-26 15:33:52', '1');
INSERT INTO `t_command_info` VALUES ('11', '2', '0', 'login', '3', '1', null, '0ED79DAD93744C14AB5FF4DF686B68E5', '3', '3', '2019-07-26 15:39:24', '2019-07-26 15:39:24', '1');
INSERT INTO `t_command_info` VALUES ('12', '2', '0', 'login', '3', '1', null, 'B5135B5C75FC446DB33C58D31F890620', '3', '3', '2019-07-26 15:40:20', '2019-07-26 15:40:20', '1');
INSERT INTO `t_command_info` VALUES ('13', '2', '0', 'login', '3', '1', null, 'B174A234511D4D309AE179D873816DDA', '3', '3', '2019-07-26 16:13:07', '2019-07-26 16:13:07', '1');
INSERT INTO `t_command_info` VALUES ('14', '2', '0', 'login', '3', '1', null, 'AB790908E6F4410C85C5A4C79D54A55C', '3', '3', '2019-08-01 18:12:42', '2019-08-01 18:12:42', '1');
INSERT INTO `t_command_info` VALUES ('15', '2', '0', 'login', '3', '1', null, '2D5EB1E20FF3434C81BB32B6B74C3C29', '3', '3', '2019-08-01 18:14:31', '2019-08-01 18:14:31', '1');
INSERT INTO `t_command_info` VALUES ('16', '2', '0', 'login', '3', '1', null, '182B067CD6784BCBA8EC3C07406B06C1', '3', '3', '2019-08-02 11:32:39', '2019-08-02 11:32:39', '1');
INSERT INTO `t_command_info` VALUES ('17', '1', '0', 'login', '3', '1', null, 'A2529791924E49D99AD3DABBC34CC71D', '3', '3', '2019-08-04 17:41:47', '2019-08-04 17:41:47', '1');
INSERT INTO `t_command_info` VALUES ('18', '1', '0', 'login', '3', '1', null, 'BA88C0D537B74AB497B395EE533DBE4D', '3', '3', '2019-08-04 17:43:58', '2019-08-04 17:43:58', '1');
INSERT INTO `t_command_info` VALUES ('19', '1', '0', 'login', '3', '1', null, '81AAB7289B6D41168B7D8AC708A66817', '3', '3', '2019-08-04 17:59:16', '2019-08-04 17:59:16', '1');
INSERT INTO `t_command_info` VALUES ('20', '1', '0', 'login', '3', '1', null, '788545C6EB9D4568B30A02EE2FC7D56E', '3', '3', '2019-08-04 18:27:32', '2019-08-04 18:27:32', '1');
INSERT INTO `t_command_info` VALUES ('21', '1', '0', 'login', '3', '1', null, 'FE0C88DDE01347269444AD3A911CFCEE', '3', '3', '2019-08-04 18:36:07', '2019-08-04 18:36:07', '1');
INSERT INTO `t_command_info` VALUES ('22', '1', '0', 'login', '3', '1', null, 'A0DB5D609C864E1A9DD4BCEC4CB41206', '3', '3', '2019-08-04 18:43:44', '2019-08-04 18:43:44', '1');
INSERT INTO `t_command_info` VALUES ('23', '1', '0', 'login', '3', '1', null, 'FEE6A95EDFF5490A9F5033B0B9B73AC5', '3', '3', '2019-08-04 19:11:11', '2019-08-04 19:11:11', '1');
INSERT INTO `t_command_info` VALUES ('24', '1', '0', 'login', '3', '1', null, '4AF3B509439D460C8D62572D7B3740CE', '3', '3', '2019-08-04 19:14:23', '2019-08-04 19:14:23', '1');
INSERT INTO `t_command_info` VALUES ('25', '1', '0', 'login', '3', '1', null, 'DCBDCD7C5FB0478E90396DD82C553775', '3', '3', '2019-08-04 19:18:38', '2019-08-04 19:18:38', '1');
INSERT INTO `t_command_info` VALUES ('26', '1', '0', 'login', '3', '1', null, '6FF9FCC7DC154A56A044A012C1B7C90A', '3', '3', '2019-08-04 19:24:01', '2019-08-04 19:24:01', '1');
INSERT INTO `t_command_info` VALUES ('27', '1', '0', 'login', '3', '1', null, 'E2D07C6E663D4152AE9E81AF5D036B7F', '3', '3', '2019-08-04 21:04:54', '2019-08-04 21:04:54', '1');
INSERT INTO `t_command_info` VALUES ('28', '1', '0', 'login', '3', '1', null, '930BB38E040A4CE18CB3A12029B955A8', '3', '3', '2019-08-05 14:17:42', '2019-08-05 14:17:42', '1');

-- ----------------------------
-- Table structure for t_course_answer
-- ----------------------------
DROP TABLE IF EXISTS `t_course_answer`;
CREATE TABLE `t_course_answer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `course_id` bigint(20) NOT NULL COMMENT '课程ID',
  `machine_id` bigint(20) NOT NULL COMMENT '机床ID',
  `courseware_id` bigint(20) NOT NULL COMMENT '课件ID',
  `courseware_item_id` bigint(20) NOT NULL COMMENT '课件详细ID',
  `student_result` text COMMENT '学生回答',
  `teacher_result` text COMMENT '老师回答',
  `fraction` decimal(10,2) DEFAULT NULL COMMENT '总的分数',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生具体分数信息结果表';

-- ----------------------------
-- Records of t_course_answer
-- ----------------------------

-- ----------------------------
-- Table structure for t_course_info
-- ----------------------------
DROP TABLE IF EXISTS `t_course_info`;
CREATE TABLE `t_course_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '课程名称',
  `description` text COMMENT '描述',
  `start_time` datetime NOT NULL COMMENT '课程开始时间',
  `time_long` int(11) NOT NULL COMMENT '课程的时间长度',
  `room_id` bigint(20) NOT NULL COMMENT '课程教室',
  `teacher_id` bigint(20) DEFAULT NULL COMMENT '创建课程的老师ID',
  `used_teacher_id` bigint(20) DEFAULT NULL COMMENT '使用课程的老师ID',
  `used_status` tinyint(4) DEFAULT NULL COMMENT '使用状态',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='课程基本信息表';

-- ----------------------------
-- Records of t_course_info
-- ----------------------------
INSERT INTO `t_course_info` VALUES ('1', '小课件', '小课件', '2019-07-12 15:59:53', '180', '1', '3', '3', '1', null, '3', '2019-07-12 16:00:26', '2019-08-05 14:17:24', '1');
INSERT INTO `t_course_info` VALUES ('2', 'string', 'string', '2019-07-16 13:47:24', '10', '1', '3', '3', '2', '3', '3', '2019-07-16 13:49:26', '2019-08-04 17:03:00', '1');
INSERT INTO `t_course_info` VALUES ('3', '测试', 'vv几个国家咕叽咕叽图许西估计才挂机过', '2019-08-05 18:29:56', '30', '1', '3', null, '0', '3', '3', '2019-08-05 17:30:16', '2019-08-05 17:30:16', '1');

-- ----------------------------
-- Table structure for t_course_link
-- ----------------------------
DROP TABLE IF EXISTS `t_course_link`;
CREATE TABLE `t_course_link` (
  `course_id` bigint(20) NOT NULL COMMENT '课程ID',
  `courseware_id` bigint(20) NOT NULL COMMENT '课件ID',
  PRIMARY KEY (`course_id`,`courseware_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课件与课程关系表';

-- ----------------------------
-- Records of t_course_link
-- ----------------------------
INSERT INTO `t_course_link` VALUES ('1', '1');
INSERT INTO `t_course_link` VALUES ('1', '2');

-- ----------------------------
-- Table structure for t_course_student
-- ----------------------------
DROP TABLE IF EXISTS `t_course_student`;
CREATE TABLE `t_course_student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `course_id` bigint(20) NOT NULL COMMENT '课程ID',
  `machine_id` bigint(20) NOT NULL COMMENT '机床ID',
  `courseware_id` bigint(20) DEFAULT NULL COMMENT '正在使用的课件',
  `student_id` bigint(20) NOT NULL COMMENT '学生ID',
  `status` tinyint(4) NOT NULL COMMENT '状态0：课程机器分布完成，1:课程完成',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `course_id` (`course_id`,`machine_id`,`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_course_student
-- ----------------------------
INSERT INTO `t_course_student` VALUES ('15', '2', '1', '1', '1', '2', '3', '3', '2019-07-15 22:04:28', '2019-08-03 17:02:56', '1');
INSERT INTO `t_course_student` VALUES ('16', '2', '1', '1', '3', '2', '3', '3', '2019-07-15 22:04:28', '2019-07-31 13:32:02', '1');
INSERT INTO `t_course_student` VALUES ('17', '2', '1', '1', '4', '0', '3', '3', '2019-07-15 22:04:29', '2019-07-31 13:32:05', '1');

-- ----------------------------
-- Table structure for t_course_student_process
-- ----------------------------
DROP TABLE IF EXISTS `t_course_student_process`;
CREATE TABLE `t_course_student_process` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `course_id` bigint(20) NOT NULL COMMENT '课程ID',
  `machine_id` bigint(20) NOT NULL COMMENT '机床ID',
  `courseware_id` bigint(20) NOT NULL COMMENT '课件ID',
  `courseware_item_id` bigint(20) DEFAULT NULL COMMENT '当前的课件正在进行中',
  `courseware_item_name` varchar(80) DEFAULT NULL COMMENT '课件详细的名字',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `step_num` int(11) DEFAULT NULL COMMENT '第几步',
  `is_end` tinyint(4) NOT NULL COMMENT '是否已经结束',
  `student_id` bigint(20) NOT NULL,
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_course_student_process
-- ----------------------------
INSERT INTO `t_course_student_process` VALUES ('1', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:04:59', '2019-08-03 17:05:46', '2', '0', '1', '1');
INSERT INTO `t_course_student_process` VALUES ('2', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:05:04', '2019-08-03 17:05:46', '2', '0', '3', '1');
INSERT INTO `t_course_student_process` VALUES ('3', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:47', '2019-08-03 17:05:09', '2019-08-03 17:05:47', '2', '0', '4', '1');
INSERT INTO `t_course_student_process` VALUES ('4', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:04:59', '2019-08-03 17:05:46', '2', '0', '1', '1');
INSERT INTO `t_course_student_process` VALUES ('5', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:05:04', '2019-08-03 17:05:46', '2', '0', '3', '1');
INSERT INTO `t_course_student_process` VALUES ('6', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:47', '2019-08-03 17:05:09', '2019-08-03 17:05:47', '2', '0', '4', '1');
INSERT INTO `t_course_student_process` VALUES ('7', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:04:59', '2019-08-03 17:05:46', '2', '0', '1', '1');
INSERT INTO `t_course_student_process` VALUES ('8', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:05:04', '2019-08-03 17:05:46', '2', '0', '3', '1');
INSERT INTO `t_course_student_process` VALUES ('9', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:47', '2019-08-03 17:05:09', '2019-08-03 17:05:47', '2', '0', '4', '1');
INSERT INTO `t_course_student_process` VALUES ('10', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:04:59', '2019-08-03 17:05:46', '2', '0', '1', '1');
INSERT INTO `t_course_student_process` VALUES ('11', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:05:04', '2019-08-03 17:05:46', '2', '0', '3', '1');
INSERT INTO `t_course_student_process` VALUES ('12', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:47', '2019-08-03 17:05:09', '2019-08-03 17:05:47', '2', '0', '4', '1');
INSERT INTO `t_course_student_process` VALUES ('13', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:04:59', '2019-08-03 17:05:46', '2', '0', '1', '1');
INSERT INTO `t_course_student_process` VALUES ('14', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:05:04', '2019-08-03 17:05:46', '2', '0', '3', '1');
INSERT INTO `t_course_student_process` VALUES ('15', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:47', '2019-08-03 17:05:09', '2019-08-03 17:05:47', '2', '0', '4', '1');
INSERT INTO `t_course_student_process` VALUES ('16', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:04:59', '2019-08-03 17:05:46', '2', '0', '1', '1');
INSERT INTO `t_course_student_process` VALUES ('17', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:05:04', '2019-08-03 17:05:46', '2', '0', '3', '1');
INSERT INTO `t_course_student_process` VALUES ('18', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:47', '2019-08-03 17:05:09', '2019-08-03 17:05:47', '2', '0', '4', '1');
INSERT INTO `t_course_student_process` VALUES ('19', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:04:59', '2019-08-03 17:05:46', '2', '0', '1', '1');
INSERT INTO `t_course_student_process` VALUES ('20', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:05:04', '2019-08-03 17:05:46', '2', '0', '3', '1');
INSERT INTO `t_course_student_process` VALUES ('21', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:47', '2019-08-03 17:05:09', '2019-08-03 17:05:47', '2', '0', '4', '1');
INSERT INTO `t_course_student_process` VALUES ('22', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:04:59', '2019-08-03 17:05:46', '2', '0', '1', '1');
INSERT INTO `t_course_student_process` VALUES ('23', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:05:04', '2019-08-03 17:05:46', '2', '0', '3', '1');
INSERT INTO `t_course_student_process` VALUES ('24', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:47', '2019-08-03 17:05:09', '2019-08-03 17:05:47', '2', '0', '4', '1');
INSERT INTO `t_course_student_process` VALUES ('25', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:04:59', '2019-08-03 17:05:46', '2', '0', '1', '1');
INSERT INTO `t_course_student_process` VALUES ('26', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:05:04', '2019-08-03 17:05:46', '2', '0', '3', '1');
INSERT INTO `t_course_student_process` VALUES ('27', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:47', '2019-08-03 17:05:09', '2019-08-03 17:05:47', '2', '0', '4', '1');
INSERT INTO `t_course_student_process` VALUES ('28', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:04:59', '2019-08-03 17:05:46', '2', '0', '1', '1');
INSERT INTO `t_course_student_process` VALUES ('29', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:46', '2019-08-03 17:05:04', '2019-08-03 17:05:46', '2', '0', '3', '1');
INSERT INTO `t_course_student_process` VALUES ('30', '1', '1', '2', '1', '1', '2', '1111111', '2019-08-03 17:05:47', '2019-08-03 17:05:09', '2019-08-03 17:05:47', '2', '0', '4', '1');

-- ----------------------------
-- Table structure for t_course_student_register
-- ----------------------------
DROP TABLE IF EXISTS `t_course_student_register`;
CREATE TABLE `t_course_student_register` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `course_student_id` bigint(20) DEFAULT NULL,
  `command_id` bigint(20) NOT NULL COMMENT '命令ID',
  `is_register` tinyint(4) NOT NULL COMMENT '是否已经签到',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_course_student_register
-- ----------------------------
INSERT INTO `t_course_student_register` VALUES ('2', '15', '1', '1', '3', '3', '2019-07-15 22:20:54', '2019-07-15 22:20:54', '1');

-- ----------------------------
-- Table structure for t_courseware
-- ----------------------------
DROP TABLE IF EXISTS `t_courseware`;
CREATE TABLE `t_courseware` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '课件名称',
  `description` text COMMENT '描述',
  `is_used` tinyint(4) NOT NULL COMMENT '课件是否已经使用，一旦使用就无法修改课件',
  `level_num` tinyint(4) DEFAULT NULL COMMENT '等级',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='课件信息表';

-- ----------------------------
-- Records of t_courseware
-- ----------------------------
INSERT INTO `t_courseware` VALUES ('1', '课课长', '1', '1', null, null, null, '2019-07-14 18:45:33', '2019-07-14 18:45:33', '1');
INSERT INTO `t_courseware` VALUES ('2', 'string', 'string', '0', null, '3', '3', '2019-07-16 13:56:30', '2019-07-16 13:56:30', '1');

-- ----------------------------
-- Table structure for t_courseware_item
-- ----------------------------
DROP TABLE IF EXISTS `t_courseware_item`;
CREATE TABLE `t_courseware_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `type` tinyint(4) NOT NULL COMMENT '课件类型，0:资源，1:题库',
  `content_type` tinyint(4) NOT NULL COMMENT '0：图片，1：视频，2:文字；3：图纸',
  `content` text COMMENT '为具体内容的一个JSON对象',
  `order_num` int(11) DEFAULT NULL COMMENT '序列',
  `courseware_id` bigint(20) DEFAULT NULL COMMENT 'courseware的ID',
  `resource_id` bigint(20) DEFAULT NULL COMMENT '如果type为0则为资源ID,为1则为题库ID',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='课件详细内容';

-- ----------------------------
-- Records of t_courseware_item
-- ----------------------------
INSERT INTO `t_courseware_item` VALUES ('1', '0', '0', '{title:\"dsfdsf\",\"content\":\"/api/upload//resource/20190726//8e7fb249864c49bfa7aaf3d2b26069dc.png\"}', '0', '1', null, null, null, '2019-07-14 18:47:51', '2019-08-05 11:00:08', '1');
INSERT INTO `t_courseware_item` VALUES ('2', '0', '3', '{\"blueprintDTO\":{url:\"/api/upload//resource/20190726//8e7fb249864c49bfa7aaf3d2b26069dc.png\",\"pointList\":[\"A\"]},\"blueprintAnswerDTOList\":[{\"pointName\":\"A\",\"answer\":\"12\",\"error\":\"12\",\"unit\":\"12\"}]}', '2', '2', '1', '3', '3', '2019-07-16 13:56:30', '2019-08-04 15:25:02', '1');
INSERT INTO `t_courseware_item` VALUES ('3', '0', '0', '{title:\"dsfdsf\",\"content\":\"/api/upload//resource/20190726//8e7fb249864c49bfa7aaf3d2b26069dc.png\"}', '1', '2', '2', '3', '3', '2019-07-16 13:56:30', '2019-08-04 15:29:12', '1');

-- ----------------------------
-- Table structure for t_couseware_student_answer
-- ----------------------------
DROP TABLE IF EXISTS `t_couseware_student_answer`;
CREATE TABLE `t_couseware_student_answer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `courseware_id` bigint(20) NOT NULL COMMENT '课件ID',
  `courseware_item_id` bigint(20) NOT NULL COMMENT '课件详细内容的ID',
  `student_id` bigint(20) NOT NULL COMMENT '课件ID',
  `result` text COMMENT '是json对象根据不同item_id中的类型得到结果',
  `tearch_result` text COMMENT '老师输入的结果',
  `fraction` int(11) DEFAULT NULL COMMENT '总的分数',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生课件回答表';

-- ----------------------------
-- Records of t_couseware_student_answer
-- ----------------------------

-- ----------------------------
-- Table structure for t_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `t_dictionary`;
CREATE TABLE `t_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(80) DEFAULT NULL COMMENT '字典描述',
  `description` text COMMENT '班级描述',
  `sn` varchar(80) NOT NULL COMMENT '编码',
  `is_deleted` tinyint(4) NOT NULL COMMENT '是否已经删除',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='字典信息表';

-- ----------------------------
-- Records of t_dictionary
-- ----------------------------
INSERT INTO `t_dictionary` VALUES ('12', 'sadsad', 'asdsa', '1', '0', null, null, '2019-07-16 10:17:27', '2019-07-16 10:17:27', '1');

-- ----------------------------
-- Table structure for t_dictionary_item
-- ----------------------------
DROP TABLE IF EXISTS `t_dictionary_item`;
CREATE TABLE `t_dictionary_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `dictionary_id` bigint(20) NOT NULL COMMENT '字典ID',
  `content` varchar(80) DEFAULT NULL COMMENT '字典的具体内容',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`,`dictionary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dictionary_item
-- ----------------------------
INSERT INTO `t_dictionary_item` VALUES ('1', '12', '干净', null, null, '2019-07-16 10:17:42', '2019-07-16 10:17:42', '1');
INSERT INTO `t_dictionary_item` VALUES ('2', '12', '漂亮', null, null, '2019-07-16 10:17:42', '2019-07-16 10:17:42', '1');

-- ----------------------------
-- Table structure for t_machine_info
-- ----------------------------
DROP TABLE IF EXISTS `t_machine_info`;
CREATE TABLE `t_machine_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `room_id` bigint(20) NOT NULL COMMENT '教室的ID',
  `sn` varchar(30) NOT NULL COMMENT '机床的编码',
  `row_num` int(11) NOT NULL COMMENT '位于第几行从1开始',
  `column_num` int(11) NOT NULL COMMENT '位于第几列从1开始',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='机床位置信息表';

-- ----------------------------
-- Records of t_machine_info
-- ----------------------------
INSERT INTO `t_machine_info` VALUES ('1', '1', '1', '0', '0', '1', '1', '2019-07-27 23:09:46', '2019-08-03 17:01:42', '1');
INSERT INTO `t_machine_info` VALUES ('6', '1', '3', '0', '1', '1', '1', '2019-07-27 23:09:46', '2019-07-27 23:09:46', '1');
INSERT INTO `t_machine_info` VALUES ('7', '2', 'ewrwer', '0', '0', '1', '1', '2019-07-27 23:10:59', '2019-07-27 23:10:59', '1');
INSERT INTO `t_machine_info` VALUES ('8', '2', 'www', '0', '1', '1', '1', '2019-07-27 23:10:59', '2019-07-27 23:10:59', '1');
INSERT INTO `t_machine_info` VALUES ('9', '2', 'www', '0', '2', '1', '1', '2019-07-27 23:11:00', '2019-07-27 23:11:00', '1');
INSERT INTO `t_machine_info` VALUES ('10', '2', 'erewr', '1', '0', '1', '1', '2019-07-27 23:11:00', '2019-07-27 23:11:00', '1');
INSERT INTO `t_machine_info` VALUES ('11', '2', 'www', '1', '1', '1', '1', '2019-07-27 23:11:00', '2019-07-27 23:11:00', '1');
INSERT INTO `t_machine_info` VALUES ('12', '2', 'ewrewr', '1', '2', '1', '1', '2019-07-27 23:11:00', '2019-07-27 23:11:00', '1');

-- ----------------------------
-- Table structure for t_menu_info
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_info`;
CREATE TABLE `t_menu_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `url_path` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '相对路径url',
  `code` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '权限代码',
  `menu_type` tinyint(4) DEFAULT NULL COMMENT '权限类型,0:模块菜单,1:菜单，2：连接，3：按钮级别,4:子权限，表示没有单独的按钮或者链接，5：登陆权限：表示只要登陆用户既可以访问',
  `parent_menu_id` smallint(6) DEFAULT NULL COMMENT '上级权限',
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单名字',
  `menu_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单路径',
  `menu_level` tinyint(4) DEFAULT '0',
  `order_num` smallint(6) DEFAULT NULL COMMENT '菜单序列',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '删除标志',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `modify_id` int(20) DEFAULT NULL COMMENT '修改人',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=240 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='菜单表';

-- ----------------------------
-- Records of t_menu_info
-- ----------------------------
INSERT INTO `t_menu_info` VALUES ('1', '', 'sys_manage', '0', null, '系统管理', '', '0', '20', '0', '2019-06-30 12:56:19', '2019-06-30 12:56:19', null, null, '1');
INSERT INTO `t_menu_info` VALUES ('2', null, 'teacher_manage', '0', null, '教师管理', null, '0', '1', '0', '2019-06-30 12:57:31', '2019-06-30 12:57:31', null, null, '1');
INSERT INTO `t_menu_info` VALUES ('228', '/admin/teacher/list', 'teacher_manage_list', '1', '2', '教师列表', '/admin/teacher/list.html', '0', '1', '0', '2019-06-30 12:57:31', '2019-06-30 13:02:55', null, null, '1');
INSERT INTO `t_menu_info` VALUES ('229', '/admin/sys/log/list', 'sys_manage_log_list', '1', '1', '日志列表', '/admin/sys/log_list.html', '0', '1', '0', '2019-06-30 13:02:44', '2019-06-30 13:02:44', null, null, '1');
INSERT INTO `t_menu_info` VALUES ('230', '', 'class_manage', '0', null, '班级管理', '', '0', '20', '0', '2019-06-30 12:56:19', '2019-07-23 10:34:41', null, null, '1');
INSERT INTO `t_menu_info` VALUES ('231', '/admin/class/list', 'class_manage_list', '1', '230', '班级列表', '/admin/class/list.html', '0', '1', '0', '2019-06-30 12:57:31', '2019-07-23 10:34:45', null, null, '1');
INSERT INTO `t_menu_info` VALUES ('232', '', 'room_manage', '0', null, '教室管理', '', '0', '20', '0', '2019-06-30 12:56:19', '2019-07-23 10:34:41', null, null, '1');
INSERT INTO `t_menu_info` VALUES ('233', '/admin/room/list', 'room_manage_list', '1', '232', '教室管理列表', '/admin/room/list.html', '0', '1', '0', '2019-06-30 12:57:31', '2019-07-23 10:34:45', null, null, '1');
INSERT INTO `t_menu_info` VALUES ('234', '', 'student_manage', '0', null, '学生管理', '', '0', '20', '0', '2019-06-30 12:56:19', '2019-07-23 10:34:41', null, null, '1');
INSERT INTO `t_menu_info` VALUES ('235', '/admin/student/list', 'student_manage_list', '1', '234', '学生管理列表', '/admin/student/list.html', '0', '1', '0', '2019-06-30 12:57:31', '2019-07-23 10:34:45', null, null, '1');
INSERT INTO `t_menu_info` VALUES ('236', '', 'report_manage', '0', null, '题库管理', '', '0', '20', '0', '2019-06-30 12:56:19', '2019-07-23 10:34:41', null, null, '1');
INSERT INTO `t_menu_info` VALUES ('237', '/admin/question/list', 'report_manage_list', '1', '236', '题库信息列表', '/admin/resource/list.html', '0', '1', '0', '2019-06-30 12:57:31', '2019-08-03 14:19:40', null, null, '1');
INSERT INTO `t_menu_info` VALUES ('238', '', 'member_manage', '0', null, '资源管理', '', '0', '20', '0', '2019-06-30 12:56:19', '2019-08-03 14:20:53', null, null, '1');
INSERT INTO `t_menu_info` VALUES ('239', '/admin/question/list', 'member_manage_list', '1', '238', '资源信息列表', '/admin/question/list.html', '0', '1', '0', '2019-06-30 12:57:31', '2019-08-03 14:22:03', null, null, '1');

-- ----------------------------
-- Table structure for t_question
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `question` varchar(1024) NOT NULL COMMENT '题目',
  `type` tinyint(4) NOT NULL COMMENT '类型0：问答题，1:单选题，2.多选题',
  `result` varchar(255) DEFAULT NULL COMMENT '如果是非选择题则直接显示内容',
  `is_deleted` tinyint(4) NOT NULL COMMENT '是否已经删除',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='题库信息表\r\n';

-- ----------------------------
-- Records of t_question
-- ----------------------------
INSERT INTO `t_question` VALUES ('1', '中国cee', '0', 'dsfdsfdsf', '0', null, null, '2019-07-14 21:39:01', '2019-07-14 21:39:01', '1');
INSERT INTO `t_question` VALUES ('2', 'list', '1', '', '0', null, null, '2019-07-14 21:41:40', '2019-07-14 21:41:40', '1');
INSERT INTO `t_question` VALUES ('3', 'sadsadsad', '0', 'sadsad', '0', '1', '1', '2019-07-24 22:18:06', '2019-07-24 22:18:06', '1');
INSERT INTO `t_question` VALUES ('4', 'sadsadsad', '1', null, '0', '1', '1', '2019-07-24 22:18:17', '2019-07-24 22:18:17', '1');
INSERT INTO `t_question` VALUES ('7', 'sadsadsad', '1', null, '0', '1', '1', '2019-07-24 22:26:41', '2019-07-24 22:28:49', '1');

-- ----------------------------
-- Table structure for t_question_item
-- ----------------------------
DROP TABLE IF EXISTS `t_question_item`;
CREATE TABLE `t_question_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `content` varchar(255) NOT NULL COMMENT '单选或者多选的的选择项',
  `is_result` tinyint(4) NOT NULL COMMENT '是为答案',
  `question_id` bigint(20) NOT NULL COMMENT '问题ID',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_question_item
-- ----------------------------
INSERT INTO `t_question_item` VALUES ('1', 'sadsad', '1', '2', null, null, '2019-07-14 21:43:18', '2019-07-14 21:43:18', '1');
INSERT INTO `t_question_item` VALUES ('3', 'asaSAs', '1', '7', '1', '1', '2019-07-24 22:28:50', '2019-07-24 22:28:50', '1');
INSERT INTO `t_question_item` VALUES ('4', 'sadsadsad', '0', '7', '1', '1', '2019-07-24 22:28:50', '2019-07-24 22:28:50', '1');

-- ----------------------------
-- Table structure for t_resource_info
-- ----------------------------
DROP TABLE IF EXISTS `t_resource_info`;
CREATE TABLE `t_resource_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(80) DEFAULT NULL COMMENT '资源标题',
  `type` tinyint(4) NOT NULL COMMENT '资源类型，0：图片，1：视频，2:文字；3：图纸,4:图纸的答案',
  `content` text COMMENT '资源的具体内容，如果是图片和视频表示URL,如果是文字则是实际的文字，如果是，图纸则是一个JSON对象里面包含测量点',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `is_deleted` tinyint(4) NOT NULL COMMENT '是否已经删除',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='资源信息表';

-- ----------------------------
-- Records of t_resource_info
-- ----------------------------
INSERT INTO `t_resource_info` VALUES ('1', '撒旦撒旦', '4', '{\"answer\":\"12\",\"error\":\"12\",\"unit\":\"12\"}', null, '0', '1', '2019-07-14 21:26:08', '2019-07-26 22:18:50', '1');
INSERT INTO `t_resource_info` VALUES ('2', '撒旦撒旦', '3', '{\"url\":\"/api/upload//resource/20190803//5134ae0dc2ad49eb8d3d891572d031e1.png\",\"pointList\":[\"sdfdsf\",\"dsfdsfdsf\",\"dsfdsf\",\"dsfdsfdsf\"]}', '3', '0', '1', '2019-07-14 21:28:10', '2019-08-03 23:46:06', '1');
INSERT INTO `t_resource_info` VALUES ('3', 'SADSADSD', '0', '/api/upload//resource/20190726//8e7fb249864c49bfa7aaf3d2b26069dc.png', '1', '0', '1', '2019-07-26 22:23:09', '2019-07-26 22:23:09', '1');
INSERT INTO `t_resource_info` VALUES ('4', 'SADSADSD', '5', '/api/upload//resource/20190803//ac11bc5d110d45918dada3027e2966ef.docx', '1', '0', '1', '2019-08-03 14:59:53', '2019-08-03 14:59:53', '1');

-- ----------------------------
-- Table structure for t_role_info
-- ----------------------------
DROP TABLE IF EXISTS `t_role_info`;
CREATE TABLE `t_role_info` (
  `id` bigint(6) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '角色描述',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '删除标志',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色表';

-- ----------------------------
-- Records of t_role_info
-- ----------------------------
INSERT INTO `t_role_info` VALUES ('41', 'dsad', 'sadsad', '0', '2019-07-03 22:14:50', '2019-07-03 22:14:50', null, null, '1');

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
  `role_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for t_site_info
-- ----------------------------
DROP TABLE IF EXISTS `t_site_info`;
CREATE TABLE `t_site_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `domain` varchar(150) COLLATE utf8_bin DEFAULT NULL COMMENT '站点名称',
  `site_id` int(11) NOT NULL COMMENT '站点的ID',
  `parent_site_id` int(11) DEFAULT NULL COMMENT '上级站点',
  `parent_site_tree` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '站点树',
  `child_enabled` tinyint(4) DEFAULT NULL COMMENT '是否可以查看下级',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '删除标志',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='站点信息';

-- ----------------------------
-- Records of t_site_info
-- ----------------------------
INSERT INTO `t_site_info` VALUES ('1', 'http://localhost:8501/', '1', '1', ',1,', '1', '0', '2019-06-25 15:16:16', '2019-07-07 17:23:32', null, null);
INSERT INTO `t_site_info` VALUES ('17', 'http://localhost:8503/', '1', '1', ',1,', '1', '0', '2019-06-25 15:16:16', '2019-07-12 12:54:02', null, null);
INSERT INTO `t_site_info` VALUES ('18', 'http://39.106.205.200:8501/', '1', '1', ',1,', '1', '0', '2019-07-03 21:46:37', '2019-07-07 17:23:48', null, null);
INSERT INTO `t_site_info` VALUES ('19', 'http://39.106.205.200:8052/', '1', '1', ',1,', '1', '0', '2019-07-03 21:47:00', '2019-07-08 20:59:18', null, null);
INSERT INTO `t_site_info` VALUES ('20', 'http://localhost:8052/', '1', '1', ',1,', '1', '0', '2019-07-04 21:03:11', '2019-07-11 13:12:36', null, null);
INSERT INTO `t_site_info` VALUES ('21', 'http://39.106.205.200:8503/', '1', '1', ',1,', '1', '0', '2019-07-07 16:32:51', '2019-07-07 17:24:06', null, null);
INSERT INTO `t_site_info` VALUES ('22', 'http://localhost:8083/', '1', '1', ',1,', '1', '0', '2019-06-25 15:16:16', '2019-07-12 12:54:02', null, null);
INSERT INTO `t_site_info` VALUES ('23', 'http://39.106.205.200:8083/', '1', '1', ',1,', '1', '0', '2019-07-17 15:39:05', '2019-07-17 15:39:05', null, null);
INSERT INTO `t_site_info` VALUES ('24', 'http://10.1.80.16:8083/', '1', '1', ',1,', '1', '0', '2019-07-17 16:11:07', '2019-07-17 16:11:35', null, null);
INSERT INTO `t_site_info` VALUES ('25', 'http://127.0.0.1:8083/', '1', '1', ',1,', '1', '0', '2019-07-17 16:11:07', '2019-07-17 16:11:35', null, null);
INSERT INTO `t_site_info` VALUES ('26', 'http://106.15.75.20:8501/', '1', '1', ',1,', '1', '0', '2019-08-05 20:19:00', '2019-08-05 20:19:05', null, null);
INSERT INTO `t_site_info` VALUES ('27', 'http://106.15.75.20:8503/', '1', '1', ',1,', '1', '0', '2019-08-05 20:19:18', '2019-08-05 20:19:27', null, null);
INSERT INTO `t_site_info` VALUES ('28', 'http://106.15.75.20:8052/', '1', '1', ',1,', '1', '0', '2019-08-05 20:19:37', '2019-08-05 20:19:44', null, null);
INSERT INTO `t_site_info` VALUES ('29', 'http://106.15.75.20:8083/', '1', '1', ',1,', '1', '0', '2019-08-05 20:19:55', '2019-08-05 20:20:00', null, null);

-- ----------------------------
-- Table structure for t_student_fraction
-- ----------------------------
DROP TABLE IF EXISTS `t_student_fraction`;
CREATE TABLE `t_student_fraction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程ID',
  `student_id` bigint(20) DEFAULT NULL COMMENT '学生ID',
  `fraction` decimal(10,2) DEFAULT NULL COMMENT '分数',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student_fraction
-- ----------------------------
INSERT INTO `t_student_fraction` VALUES ('3', '1', '2', null, '3', '3', '2019-07-16 10:37:42', '2019-07-16 10:37:42', '1');
INSERT INTO `t_student_fraction` VALUES ('4', '1', '3', null, '3', '3', '2019-07-16 10:37:43', '2019-07-16 10:37:43', '1');
INSERT INTO `t_student_fraction` VALUES ('5', '1', '4', null, '3', '3', '2019-07-16 10:37:44', '2019-07-16 10:37:44', '1');

-- ----------------------------
-- Table structure for t_student_fraction_item
-- ----------------------------
DROP TABLE IF EXISTS `t_student_fraction_item`;
CREATE TABLE `t_student_fraction_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fraction_id` bigint(20) DEFAULT NULL COMMENT '分数对象的ID',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型0：表示资源的ID,1:表示对应的字典表',
  `dictionary_item_id` bigint(20) DEFAULT NULL COMMENT '对应的ID',
  `fraction` decimal(10,2) DEFAULT NULL COMMENT '分数',
  `name` varchar(80) DEFAULT NULL COMMENT '项目的名字',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student_fraction_item
-- ----------------------------
INSERT INTO `t_student_fraction_item` VALUES ('1', '3', '0', '1', '10.00', 'string', '3', '3', '2019-07-16 10:37:43', '2019-07-16 10:37:43', '1');
INSERT INTO `t_student_fraction_item` VALUES ('2', '3', '0', '2', '10.00', 'string', '3', '3', '2019-07-16 10:37:43', '2019-07-16 10:37:43', '1');
INSERT INTO `t_student_fraction_item` VALUES ('3', '4', '0', '1', '10.00', 'string', '3', '3', '2019-07-16 10:37:44', '2019-07-16 10:37:44', '1');
INSERT INTO `t_student_fraction_item` VALUES ('4', '4', '0', '2', '10.00', 'string', '3', '3', '2019-07-16 10:37:44', '2019-07-16 10:37:44', '1');
INSERT INTO `t_student_fraction_item` VALUES ('5', '5', '0', '1', '10.00', 'string', '3', '3', '2019-07-16 10:37:45', '2019-07-16 10:37:45', '1');
INSERT INTO `t_student_fraction_item` VALUES ('6', '5', '0', '2', '10.00', 'string', '3', '3', '2019-07-16 10:37:45', '2019-07-16 10:37:45', '1');

-- ----------------------------
-- Table structure for t_student_info
-- ----------------------------
DROP TABLE IF EXISTS `t_student_info`;
CREATE TABLE `t_student_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `id_card` varchar(80) DEFAULT NULL COMMENT 'ID卡',
  `classmate_id` bigint(20) NOT NULL COMMENT '所在的班级',
  `name` varchar(50) NOT NULL COMMENT '班级的名字',
  `sex` tinyint(4) NOT NULL COMMENT '0:表示男，1:表示女',
  `email` varchar(255) NOT NULL COMMENT '邮件',
  `is_enabled` bit(1) NOT NULL COMMENT '是否可用',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `real_name` varchar(100) NOT NULL COMMENT '真实的姓名',
  `header_url` longtext COMMENT '头像图片',
  `header_info` longtext COMMENT '头像特征信息',
  `birth_time` timestamp NULL DEFAULT NULL COMMENT '生日',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `telephone` varchar(20) DEFAULT NULL COMMENT '电话好吗',
  `app_token` varchar(80) DEFAULT NULL COMMENT '登录的TOKEN',
  `machine_id` bigint(20) DEFAULT NULL COMMENT '学生所处的机器ID',
  `is_deleted` tinyint(4) NOT NULL COMMENT '是否已经删除',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  `face_version` int(10) DEFAULT NULL COMMENT '头部特征版本号',
  PRIMARY KEY (`id`,`name`,`sex`),
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8 COMMENT='学生信息表';

-- ----------------------------
-- Records of t_student_info
-- ----------------------------
INSERT INTO `t_student_info` VALUES ('1', '12345678', '1', 'login', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员', 'http://39.106.205.200:8503/api/upload//base/20190721//7300fd4101d644bd8fe1ae7a72eff2da..jpg', '0gsAb1pnxmsRRyhnO4MbHu+7Mv+BEUUEUaSl9jRapnMjHIlPlZZRtCoYULgwlxW8vLgO30BUcyQB\nIxWo0trdLPz6bK/SjYtU3mC1J0mQBVy+MexBNCH4O/2N4rcLgTJMU8zNj4qBGAu1e9IHR2bHAyco\nKuBKk4hkjGBW6KImVpOK4YJv88Xm6+9c9OcTkt6cT8DMg5qxRfv5Gkd32iikjFz80M9SrAg0yzIf\nx48JLUPXXRygAJ4l27JzfFcnZQFTTPPvUDGTaqvzSTvZOFKy3Efkjb+b0CzE0t3zN726sUw4612P\nvGYtdBtdAAcPXvIDWwV9n7Z8NptGFRaXgcxIE44jXBBAIIaUTDUAGY5uZ2PbV/gAywdYBDByCnfk\ngoNz/hnmMC4iwrTg0UFHK4cmvKszHqIctTykLOa6V+i+61Mi6XEvJEdbVFc0hyeEbVNcMcdyP75g\nebvDxgjIC1njM+YYJvCNbocLRxBDeBXAmYOm1kCfV6j1G88qWGjv24GT3Uu37+3vwRSuUAYZcW0y\nY71/vH/5gL57nG42dlf6vgyfTaYw8xqTNFWb0zgW8OS80wDwX7qePFvWUKhXqZ6kU+0PTVE6A5/U\nmPhEp5ty9F1t2STASPlyRbaJ+bfrlmMzXx/9j4IqOguF6z8HVxYXAytWGB+Q39+b0aOg6FkNSBM=\n', '2019-07-11 14:02:14', '13656640475', '13656640475', '8f2510a1dab949caabe144244f42a5fa', null, '0', null, '1', '2019-07-11 14:02:16', '2019-08-03 17:03:00', '1', '2');
INSERT INTO `t_student_info` VALUES ('2', '12345678', '2', 'login0', '1', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员', null, null, null, '13656640476', '13656640475', null, null, '0', null, '1', '2019-07-11 14:03:28', '2019-07-23 21:20:00', '1', null);
INSERT INTO `t_student_info` VALUES ('3', '12345678', '1', 'login1', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员1', null, null, '2019-07-11 14:03:26', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:28', '2019-07-11 14:03:28', '1', null);
INSERT INTO `t_student_info` VALUES ('4', '12345678', '1', 'login2', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员2', null, null, '2019-07-11 14:03:27', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:28', '2019-07-11 14:03:28', '1', null);
INSERT INTO `t_student_info` VALUES ('5', '12345678', '1', 'login3', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员3', null, null, '2019-07-11 14:03:27', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:29', '2019-07-11 14:03:29', '1', null);
INSERT INTO `t_student_info` VALUES ('6', '12345678', '1', 'login4', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员4', null, null, '2019-07-11 14:03:27', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:29', '2019-07-11 14:03:29', '1', null);
INSERT INTO `t_student_info` VALUES ('7', '12345678', '1', 'login5', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员5', null, null, '2019-07-11 14:03:28', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:29', '2019-07-11 14:03:29', '1', null);
INSERT INTO `t_student_info` VALUES ('8', '12345678', '1', 'login6', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员6', null, null, '2019-07-11 14:03:28', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:29', '2019-07-11 14:03:29', '1', null);
INSERT INTO `t_student_info` VALUES ('9', '12345678', '1', 'login7', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员7', null, null, '2019-07-11 14:03:28', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:30', '2019-07-11 14:03:30', '1', null);
INSERT INTO `t_student_info` VALUES ('10', '12345678', '1', 'login8', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员8', null, null, '2019-07-11 14:03:29', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:30', '2019-07-11 14:03:30', '1', null);
INSERT INTO `t_student_info` VALUES ('11', '12345678', '1', 'login9', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员9', null, null, '2019-07-11 14:03:29', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:30', '2019-07-11 14:03:30', '1', null);
INSERT INTO `t_student_info` VALUES ('12', '12345678', '1', 'login10', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员10', null, null, '2019-07-11 14:03:29', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:31', '2019-07-11 14:03:31', '1', null);
INSERT INTO `t_student_info` VALUES ('13', '12345678', '1', 'login11', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员11', null, null, '2019-07-11 14:03:29', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:31', '2019-07-11 14:03:31', '1', null);
INSERT INTO `t_student_info` VALUES ('14', '12345678', '1', 'login12', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员12', null, null, '2019-07-11 14:03:30', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:31', '2019-07-11 14:03:31', '1', null);
INSERT INTO `t_student_info` VALUES ('15', '12345678', '1', 'login13', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员13', null, null, '2019-07-11 14:03:30', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:32', '2019-07-11 14:03:32', '1', null);
INSERT INTO `t_student_info` VALUES ('16', '12345678', '1', 'login14', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员14', null, null, '2019-07-11 14:03:30', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:32', '2019-07-11 14:03:32', '1', null);
INSERT INTO `t_student_info` VALUES ('17', '12345678', '1', 'login15', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员15', null, null, '2019-07-11 14:03:31', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:32', '2019-07-11 14:03:32', '1', null);
INSERT INTO `t_student_info` VALUES ('18', '12345678', '1', 'login16', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员16', null, null, '2019-07-11 14:03:31', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:32', '2019-07-11 14:03:32', '1', null);
INSERT INTO `t_student_info` VALUES ('19', '12345678', '1', 'login17', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员17', null, null, '2019-07-11 14:03:31', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:33', '2019-07-11 14:03:33', '1', null);
INSERT INTO `t_student_info` VALUES ('20', '12345678', '1', 'login18', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员18', null, null, '2019-07-11 14:03:32', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:33', '2019-07-11 14:03:33', '1', null);
INSERT INTO `t_student_info` VALUES ('21', '12345678', '1', 'login19', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员19', null, null, '2019-07-11 14:03:32', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:33', '2019-07-11 14:03:33', '1', null);
INSERT INTO `t_student_info` VALUES ('22', '12345678', '1', 'login20', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员20', null, null, '2019-07-11 14:03:32', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:34', '2019-07-11 14:03:34', '1', null);
INSERT INTO `t_student_info` VALUES ('23', '12345678', '1', 'login21', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员21', null, null, '2019-07-11 14:03:32', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:34', '2019-07-11 14:03:34', '1', null);
INSERT INTO `t_student_info` VALUES ('24', '12345678', '1', 'login22', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员22', null, null, '2019-07-11 14:03:33', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:34', '2019-07-11 14:03:34', '1', null);
INSERT INTO `t_student_info` VALUES ('25', '12345678', '1', 'login23', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员23', null, null, '2019-07-11 14:03:33', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:35', '2019-07-11 14:03:35', '1', null);
INSERT INTO `t_student_info` VALUES ('26', '12345678', '1', 'login24', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员24', null, null, '2019-07-11 14:03:33', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:35', '2019-07-11 14:03:35', '1', null);
INSERT INTO `t_student_info` VALUES ('27', '12345678', '1', 'login25', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员25', null, null, '2019-07-11 14:03:34', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:35', '2019-07-11 14:03:35', '1', null);
INSERT INTO `t_student_info` VALUES ('28', '12345678', '1', 'login26', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员26', null, null, '2019-07-11 14:03:34', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:35', '2019-07-11 14:03:35', '1', null);
INSERT INTO `t_student_info` VALUES ('29', '12345678', '1', 'login27', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员27', null, null, '2019-07-11 14:03:34', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:36', '2019-07-11 14:03:36', '1', null);
INSERT INTO `t_student_info` VALUES ('30', '12345678', '1', 'login28', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员28', null, null, '2019-07-11 14:03:35', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:36', '2019-07-11 14:03:36', '1', null);
INSERT INTO `t_student_info` VALUES ('31', '12345678', '1', 'login29', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员29', null, null, '2019-07-11 14:03:35', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:36', '2019-07-11 14:03:36', '1', null);
INSERT INTO `t_student_info` VALUES ('32', '12345678', '1', 'login30', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员30', null, null, '2019-07-11 14:03:35', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:37', '2019-07-11 14:03:37', '1', null);
INSERT INTO `t_student_info` VALUES ('33', '12345678', '1', 'login31', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员31', null, null, '2019-07-11 14:03:35', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:37', '2019-07-11 14:03:37', '1', null);
INSERT INTO `t_student_info` VALUES ('34', '12345678', '1', 'login32', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员32', null, null, '2019-07-11 14:03:36', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:37', '2019-07-11 14:03:37', '1', null);
INSERT INTO `t_student_info` VALUES ('35', '12345678', '1', 'login33', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员33', null, null, '2019-07-11 14:03:36', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:38', '2019-07-11 14:03:38', '1', null);
INSERT INTO `t_student_info` VALUES ('36', '12345678', '1', 'login34', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员34', null, null, '2019-07-11 14:03:36', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:38', '2019-07-11 14:03:38', '1', null);
INSERT INTO `t_student_info` VALUES ('37', '12345678', '1', 'login35', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员35', null, null, '2019-07-11 14:03:37', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:38', '2019-07-11 14:03:38', '1', null);
INSERT INTO `t_student_info` VALUES ('38', '12345678', '1', 'login36', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员36', null, null, '2019-07-11 14:03:37', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:38', '2019-07-11 14:03:38', '1', null);
INSERT INTO `t_student_info` VALUES ('39', '12345678', '1', 'login37', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员37', null, null, '2019-07-11 14:03:37', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:39', '2019-07-11 14:03:39', '1', null);
INSERT INTO `t_student_info` VALUES ('40', '12345678', '1', 'login38', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员38', null, null, '2019-07-11 14:03:37', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:39', '2019-07-11 14:03:39', '1', null);
INSERT INTO `t_student_info` VALUES ('41', '12345678', '1', 'login39', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员39', null, null, '2019-07-11 14:03:38', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:39', '2019-07-11 14:03:39', '1', null);
INSERT INTO `t_student_info` VALUES ('42', '12345678', '1', 'login40', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员40', null, null, '2019-07-11 14:03:38', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:40', '2019-07-11 14:03:40', '1', null);
INSERT INTO `t_student_info` VALUES ('43', '12345678', '1', 'login41', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员41', null, null, '2019-07-11 14:03:38', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:40', '2019-07-11 14:03:40', '1', null);
INSERT INTO `t_student_info` VALUES ('44', '12345678', '1', 'login42', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员42', null, null, '2019-07-11 14:03:39', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:40', '2019-07-11 14:03:40', '1', null);
INSERT INTO `t_student_info` VALUES ('45', '12345678', '1', 'login43', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员43', null, null, '2019-07-11 14:03:39', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:41', '2019-07-11 14:03:41', '1', null);
INSERT INTO `t_student_info` VALUES ('46', '12345678', '1', 'login44', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员44', null, null, '2019-07-11 14:03:39', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:41', '2019-07-11 14:03:41', '1', null);
INSERT INTO `t_student_info` VALUES ('47', '12345678', '1', 'login45', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员45', null, null, '2019-07-11 14:03:40', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:41', '2019-07-11 14:03:41', '1', null);
INSERT INTO `t_student_info` VALUES ('48', '12345678', '1', 'login46', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员46', null, null, '2019-07-11 14:03:40', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:41', '2019-07-11 14:03:41', '1', null);
INSERT INTO `t_student_info` VALUES ('49', '12345678', '1', 'login47', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员47', null, null, '2019-07-11 14:03:40', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:42', '2019-07-11 14:03:42', '1', null);
INSERT INTO `t_student_info` VALUES ('50', '12345678', '1', 'login48', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员48', null, null, '2019-07-11 14:03:40', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:42', '2019-07-11 14:03:42', '1', null);
INSERT INTO `t_student_info` VALUES ('51', '12345678', '1', 'login49', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员49', null, null, '2019-07-11 14:03:41', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:03:42', '2019-07-11 14:03:42', '1', null);
INSERT INTO `t_student_info` VALUES ('52', '12345678', '2', 'login50', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员50', null, null, '2019-07-11 14:04:15', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:18', '2019-07-11 14:04:18', '1', null);
INSERT INTO `t_student_info` VALUES ('53', '12345678', '2', 'login51', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员51', null, null, '2019-07-11 14:04:16', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:18', '2019-07-11 14:04:18', '1', null);
INSERT INTO `t_student_info` VALUES ('54', '12345678', '2', 'login52', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员52', null, null, '2019-07-11 14:04:17', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:18', '2019-07-11 14:04:18', '1', null);
INSERT INTO `t_student_info` VALUES ('55', '12345678', '2', 'login53', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员53', null, null, '2019-07-11 14:04:17', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:18', '2019-07-11 14:04:18', '1', null);
INSERT INTO `t_student_info` VALUES ('56', '12345678', '2', 'login54', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员54', null, null, '2019-07-11 14:04:17', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:19', '2019-07-11 14:04:19', '1', null);
INSERT INTO `t_student_info` VALUES ('57', '12345678', '2', 'login55', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员55', null, null, '2019-07-11 14:04:18', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:19', '2019-07-11 14:04:19', '1', null);
INSERT INTO `t_student_info` VALUES ('58', '12345678', '2', 'login56', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员56', null, null, '2019-07-11 14:04:18', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:19', '2019-07-11 14:04:19', '1', null);
INSERT INTO `t_student_info` VALUES ('59', '12345678', '2', 'login57', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员57', null, null, '2019-07-11 14:04:18', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:20', '2019-07-11 14:04:20', '1', null);
INSERT INTO `t_student_info` VALUES ('60', '12345678', '2', 'login58', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员58', null, null, '2019-07-11 14:04:18', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:20', '2019-07-11 14:04:20', '1', null);
INSERT INTO `t_student_info` VALUES ('61', '12345678', '2', 'login59', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员59', null, null, '2019-07-11 14:04:19', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:20', '2019-07-11 14:04:20', '1', null);
INSERT INTO `t_student_info` VALUES ('62', '12345678', '2', 'login60', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员60', null, null, '2019-07-11 14:04:19', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:21', '2019-07-11 14:04:21', '1', null);
INSERT INTO `t_student_info` VALUES ('63', '12345678', '2', 'login61', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员61', null, null, '2019-07-11 14:04:19', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:21', '2019-07-11 14:04:21', '1', null);
INSERT INTO `t_student_info` VALUES ('64', '12345678', '2', 'login62', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员62', null, null, '2019-07-11 14:04:20', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:21', '2019-07-11 14:04:21', '1', null);
INSERT INTO `t_student_info` VALUES ('65', '12345678', '2', 'login63', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员63', null, null, '2019-07-11 14:04:20', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:21', '2019-07-11 14:04:21', '1', null);
INSERT INTO `t_student_info` VALUES ('66', '12345678', '2', 'login64', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员64', null, null, '2019-07-11 14:04:20', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:22', '2019-07-11 14:04:22', '1', null);
INSERT INTO `t_student_info` VALUES ('67', '12345678', '2', 'login65', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员65', null, null, '2019-07-11 14:04:21', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:22', '2019-07-11 14:04:22', '1', null);
INSERT INTO `t_student_info` VALUES ('68', '12345678', '2', 'login66', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员66', null, null, '2019-07-11 14:04:21', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:22', '2019-07-11 14:04:22', '1', null);
INSERT INTO `t_student_info` VALUES ('69', '12345678', '2', 'login67', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员67', null, null, '2019-07-11 14:04:21', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:23', '2019-07-11 14:04:23', '1', null);
INSERT INTO `t_student_info` VALUES ('70', '12345678', '2', 'login68', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员68', null, null, '2019-07-11 14:04:21', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:23', '2019-07-11 14:04:23', '1', null);
INSERT INTO `t_student_info` VALUES ('71', '12345678', '2', 'login69', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员69', null, null, '2019-07-11 14:04:22', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:23', '2019-07-11 14:04:23', '1', null);
INSERT INTO `t_student_info` VALUES ('72', '12345678', '2', 'login70', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员70', null, null, '2019-07-11 14:04:22', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:24', '2019-07-11 14:04:24', '1', null);
INSERT INTO `t_student_info` VALUES ('73', '12345678', '2', 'login71', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员71', null, null, '2019-07-11 14:04:22', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:24', '2019-07-11 14:04:24', '1', null);
INSERT INTO `t_student_info` VALUES ('74', '12345678', '2', 'login72', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员72', null, null, '2019-07-11 14:04:23', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:24', '2019-07-11 14:04:24', '1', null);
INSERT INTO `t_student_info` VALUES ('75', '12345678', '2', 'login73', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员73', null, null, '2019-07-11 14:04:23', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:24', '2019-07-11 14:04:24', '1', null);
INSERT INTO `t_student_info` VALUES ('76', '12345678', '2', 'login74', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员74', null, null, '2019-07-11 14:04:23', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:25', '2019-07-11 14:04:25', '1', null);
INSERT INTO `t_student_info` VALUES ('77', '12345678', '2', 'login75', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员75', null, null, '2019-07-11 14:04:24', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:25', '2019-07-11 14:04:25', '1', null);
INSERT INTO `t_student_info` VALUES ('78', '12345678', '2', 'login76', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员76', null, null, '2019-07-11 14:04:24', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:25', '2019-07-11 14:04:25', '1', null);
INSERT INTO `t_student_info` VALUES ('79', '12345678', '2', 'login77', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员77', null, null, '2019-07-11 14:04:24', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:26', '2019-07-11 14:04:26', '1', null);
INSERT INTO `t_student_info` VALUES ('80', '12345678', '2', 'login78', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员78', null, null, '2019-07-11 14:04:24', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:26', '2019-07-11 14:04:26', '1', null);
INSERT INTO `t_student_info` VALUES ('81', '12345678', '2', 'login79', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员79', null, null, '2019-07-11 14:04:25', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:26', '2019-07-11 14:04:26', '1', null);
INSERT INTO `t_student_info` VALUES ('82', '12345678', '2', 'login80', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员80', null, null, '2019-07-11 14:04:25', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:27', '2019-07-11 14:04:27', '1', null);
INSERT INTO `t_student_info` VALUES ('83', '12345678', '2', 'login81', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员81', null, null, '2019-07-11 14:04:25', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:27', '2019-07-11 14:04:27', '1', null);
INSERT INTO `t_student_info` VALUES ('84', '12345678', '2', 'login82', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员82', null, null, '2019-07-11 14:04:26', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:27', '2019-07-11 14:04:27', '1', null);
INSERT INTO `t_student_info` VALUES ('85', '12345678', '2', 'login83', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员83', null, null, '2019-07-11 14:04:26', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:28', '2019-07-11 14:04:28', '1', null);
INSERT INTO `t_student_info` VALUES ('86', '12345678', '2', 'login84', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员84', null, null, '2019-07-11 14:04:26', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:28', '2019-07-11 14:04:28', '1', null);
INSERT INTO `t_student_info` VALUES ('87', '12345678', '2', 'login85', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员85', null, null, '2019-07-11 14:04:27', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:28', '2019-07-11 14:04:28', '1', null);
INSERT INTO `t_student_info` VALUES ('88', '12345678', '2', 'login86', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员86', null, null, '2019-07-11 14:04:27', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:28', '2019-07-11 14:04:28', '1', null);
INSERT INTO `t_student_info` VALUES ('89', '12345678', '2', 'login87', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员87', null, null, '2019-07-11 14:04:27', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:29', '2019-07-11 14:04:29', '1', null);
INSERT INTO `t_student_info` VALUES ('90', '12345678', '2', 'login88', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员88', null, null, '2019-07-11 14:04:27', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:29', '2019-07-11 14:04:29', '1', null);
INSERT INTO `t_student_info` VALUES ('91', '12345678', '2', 'login89', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员89', null, null, '2019-07-11 14:04:28', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:29', '2019-07-11 14:04:29', '1', null);
INSERT INTO `t_student_info` VALUES ('92', '12345678', '2', 'login90', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员90', null, null, '2019-07-11 14:04:28', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:30', '2019-07-11 14:04:30', '1', null);
INSERT INTO `t_student_info` VALUES ('93', '12345678', '2', 'login91', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员91', null, null, '2019-07-11 14:04:28', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:30', '2019-07-11 14:04:30', '1', null);
INSERT INTO `t_student_info` VALUES ('94', '12345678', '2', 'login92', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员92', null, null, '2019-07-11 14:04:29', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:30', '2019-07-11 14:04:30', '1', null);
INSERT INTO `t_student_info` VALUES ('95', '12345678', '2', 'login93', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员93', null, null, '2019-07-11 14:04:29', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:31', '2019-07-11 14:04:31', '1', null);
INSERT INTO `t_student_info` VALUES ('96', '12345678', '2', 'login94', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员94', null, null, '2019-07-11 14:04:29', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:31', '2019-07-11 14:04:31', '1', null);
INSERT INTO `t_student_info` VALUES ('97', '12345678', '2', 'login95', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员95', null, null, '2019-07-11 14:04:30', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:31', '2019-07-11 14:04:31', '1', null);
INSERT INTO `t_student_info` VALUES ('98', '12345678', '2', 'login96', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员96', null, null, '2019-07-11 14:04:30', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:32', '2019-07-11 14:04:32', '1', null);
INSERT INTO `t_student_info` VALUES ('99', '12345678', '2', 'login97', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员97', null, null, '2019-07-11 14:04:30', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:32', '2019-07-11 14:04:32', '1', null);
INSERT INTO `t_student_info` VALUES ('100', '12345678', '2', 'login98', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员98', null, null, '2019-07-11 14:04:31', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:32', '2019-07-11 14:04:32', '1', null);
INSERT INTO `t_student_info` VALUES ('101', '12345678', '2', 'login99', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员99', null, null, '2019-07-11 14:04:31', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:04:32', '2019-07-11 14:04:32', '1', null);
INSERT INTO `t_student_info` VALUES ('102', '12345678', '3', 'login100', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员100', null, null, '2019-07-11 14:05:02', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:04', '2019-07-11 14:05:04', '1', null);
INSERT INTO `t_student_info` VALUES ('103', '12345678', '3', 'login101', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员101', null, null, '2019-07-11 14:05:03', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:04', '2019-07-11 14:05:04', '1', null);
INSERT INTO `t_student_info` VALUES ('104', '12345678', '3', 'login102', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员102', null, null, '2019-07-11 14:05:03', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:05', '2019-07-11 14:05:05', '1', null);
INSERT INTO `t_student_info` VALUES ('105', '12345678', '3', 'login103', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员103', null, null, '2019-07-11 14:05:03', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:05', '2019-07-11 14:05:05', '1', null);
INSERT INTO `t_student_info` VALUES ('106', '12345678', '3', 'login104', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员104', null, null, '2019-07-11 14:05:04', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:05', '2019-07-11 14:05:05', '1', null);
INSERT INTO `t_student_info` VALUES ('107', '12345678', '3', 'login105', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员105', null, null, '2019-07-11 14:05:04', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:06', '2019-07-11 14:05:06', '1', null);
INSERT INTO `t_student_info` VALUES ('108', '12345678', '3', 'login106', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员106', null, null, '2019-07-11 14:05:04', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:06', '2019-07-11 14:05:06', '1', null);
INSERT INTO `t_student_info` VALUES ('109', '12345678', '3', 'login107', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员107', null, null, '2019-07-11 14:05:05', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:06', '2019-07-11 14:05:06', '1', null);
INSERT INTO `t_student_info` VALUES ('110', '12345678', '3', 'login108', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员108', null, null, '2019-07-11 14:05:05', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:06', '2019-07-11 14:05:06', '1', null);
INSERT INTO `t_student_info` VALUES ('111', '12345678', '3', 'login109', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员109', null, null, '2019-07-11 14:05:05', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:07', '2019-07-11 14:05:07', '1', null);
INSERT INTO `t_student_info` VALUES ('112', '12345678', '3', 'login110', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员110', null, null, '2019-07-11 14:05:05', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:07', '2019-07-11 14:05:07', '1', null);
INSERT INTO `t_student_info` VALUES ('113', '12345678', '3', 'login111', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员111', null, null, '2019-07-11 14:05:06', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:07', '2019-07-11 14:05:07', '1', null);
INSERT INTO `t_student_info` VALUES ('114', '12345678', '3', 'login112', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员112', null, null, '2019-07-11 14:05:06', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:08', '2019-07-11 14:05:08', '1', null);
INSERT INTO `t_student_info` VALUES ('115', '12345678', '3', 'login113', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员113', null, null, '2019-07-11 14:05:06', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:08', '2019-07-11 14:05:08', '1', null);
INSERT INTO `t_student_info` VALUES ('116', '12345678', '3', 'login114', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员114', null, null, '2019-07-11 14:05:07', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:08', '2019-07-11 14:05:08', '1', null);
INSERT INTO `t_student_info` VALUES ('117', '12345678', '3', 'login115', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员115', null, null, '2019-07-11 14:05:07', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:08', '2019-07-11 14:05:08', '1', null);
INSERT INTO `t_student_info` VALUES ('118', '12345678', '3', 'login116', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员116', null, null, '2019-07-11 14:05:07', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:09', '2019-07-11 14:05:09', '1', null);
INSERT INTO `t_student_info` VALUES ('119', '12345678', '3', 'login117', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员117', null, null, '2019-07-11 14:05:07', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:09', '2019-07-11 14:05:09', '1', null);
INSERT INTO `t_student_info` VALUES ('120', '12345678', '3', 'login118', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员118', null, null, '2019-07-11 14:05:08', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:09', '2019-07-11 14:05:09', '1', null);
INSERT INTO `t_student_info` VALUES ('121', '12345678', '3', 'login119', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员119', null, null, '2019-07-11 14:05:08', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:10', '2019-07-11 14:05:10', '1', null);
INSERT INTO `t_student_info` VALUES ('122', '12345678', '3', 'login120', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员120', null, null, '2019-07-11 14:05:08', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:10', '2019-07-11 14:05:10', '1', null);
INSERT INTO `t_student_info` VALUES ('123', '12345678', '3', 'login121', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员121', null, null, '2019-07-11 14:05:09', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:10', '2019-07-11 14:05:10', '1', null);
INSERT INTO `t_student_info` VALUES ('124', '12345678', '3', 'login122', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员122', null, null, '2019-07-11 14:05:09', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:11', '2019-07-11 14:05:11', '1', null);
INSERT INTO `t_student_info` VALUES ('125', '12345678', '3', 'login123', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员123', null, null, '2019-07-11 14:05:09', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:11', '2019-07-11 14:05:11', '1', null);
INSERT INTO `t_student_info` VALUES ('126', '12345678', '3', 'login124', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员124', null, null, '2019-07-11 14:05:10', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:11', '2019-07-11 14:05:11', '1', null);
INSERT INTO `t_student_info` VALUES ('127', '12345678', '3', 'login125', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员125', null, null, '2019-07-11 14:05:10', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:12', '2019-07-11 14:05:12', '1', null);
INSERT INTO `t_student_info` VALUES ('128', '12345678', '3', 'login126', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员126', null, null, '2019-07-11 14:05:10', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:12', '2019-07-11 14:05:12', '1', null);
INSERT INTO `t_student_info` VALUES ('129', '12345678', '3', 'login127', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员127', null, null, '2019-07-11 14:05:11', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:12', '2019-07-11 14:05:12', '1', null);
INSERT INTO `t_student_info` VALUES ('130', '12345678', '3', 'login128', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员128', null, null, '2019-07-11 14:05:11', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:12', '2019-07-11 14:05:12', '1', null);
INSERT INTO `t_student_info` VALUES ('131', '12345678', '3', 'login129', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员129', null, null, '2019-07-11 14:05:11', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:13', '2019-07-11 14:05:13', '1', null);
INSERT INTO `t_student_info` VALUES ('132', '12345678', '3', 'login130', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员130', null, null, '2019-07-11 14:05:11', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:13', '2019-07-11 14:05:13', '1', null);
INSERT INTO `t_student_info` VALUES ('133', '12345678', '3', 'login131', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员131', null, null, '2019-07-11 14:05:12', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:13', '2019-07-11 14:05:13', '1', null);
INSERT INTO `t_student_info` VALUES ('134', '12345678', '3', 'login132', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员132', null, null, '2019-07-11 14:05:12', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:14', '2019-07-11 14:05:14', '1', null);
INSERT INTO `t_student_info` VALUES ('135', '12345678', '3', 'login133', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员133', null, null, '2019-07-11 14:05:12', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:14', '2019-07-11 14:05:14', '1', null);
INSERT INTO `t_student_info` VALUES ('136', '12345678', '3', 'login134', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员134', null, null, '2019-07-11 14:05:13', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:14', '2019-07-11 14:05:14', '1', null);
INSERT INTO `t_student_info` VALUES ('137', '12345678', '3', 'login135', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员135', null, null, '2019-07-11 14:05:13', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:14', '2019-07-11 14:05:14', '1', null);
INSERT INTO `t_student_info` VALUES ('138', '12345678', '3', 'login136', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员136', null, null, '2019-07-11 14:05:13', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:15', '2019-07-11 14:05:15', '1', null);
INSERT INTO `t_student_info` VALUES ('139', '12345678', '3', 'login137', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员137', null, null, '2019-07-11 14:05:13', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:15', '2019-07-11 14:05:15', '1', null);
INSERT INTO `t_student_info` VALUES ('140', '12345678', '3', 'login138', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员138', null, null, '2019-07-11 14:05:14', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:15', '2019-07-11 14:05:15', '1', null);
INSERT INTO `t_student_info` VALUES ('141', '12345678', '3', 'login139', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员139', null, null, '2019-07-11 14:05:14', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:16', '2019-07-11 14:05:16', '1', null);
INSERT INTO `t_student_info` VALUES ('142', '12345678', '3', 'login140', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员140', null, null, '2019-07-11 14:05:14', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:16', '2019-07-11 14:05:16', '1', null);
INSERT INTO `t_student_info` VALUES ('143', '12345678', '3', 'login141', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员141', null, null, '2019-07-11 14:05:15', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:16', '2019-07-11 14:05:16', '1', null);
INSERT INTO `t_student_info` VALUES ('144', '12345678', '3', 'login142', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员142', null, null, '2019-07-11 14:05:15', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:16', '2019-07-11 14:05:16', '1', null);
INSERT INTO `t_student_info` VALUES ('145', '12345678', '3', 'login143', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员143', null, null, '2019-07-11 14:05:15', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:17', '2019-07-11 14:05:17', '1', null);
INSERT INTO `t_student_info` VALUES ('146', '12345678', '3', 'login144', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员144', null, null, '2019-07-11 14:05:15', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:17', '2019-07-11 14:05:17', '1', null);
INSERT INTO `t_student_info` VALUES ('147', '12345678', '3', 'login145', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员145', null, null, '2019-07-11 14:05:16', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:17', '2019-07-11 14:05:17', '1', null);
INSERT INTO `t_student_info` VALUES ('148', '12345678', '3', 'login146', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员146', null, null, '2019-07-11 14:05:16', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:18', '2019-07-11 14:05:18', '1', null);
INSERT INTO `t_student_info` VALUES ('149', '12345678', '3', 'login147', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员147', null, null, '2019-07-11 14:05:16', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:18', '2019-07-11 14:05:18', '1', null);
INSERT INTO `t_student_info` VALUES ('150', '12345678', '3', 'login148', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员148', null, null, '2019-07-11 14:05:17', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:18', '2019-07-11 14:05:18', '1', null);
INSERT INTO `t_student_info` VALUES ('151', '12345678', '3', 'login149', '0', 'test@126.com', '', 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员149', null, null, '2019-07-11 14:05:17', '13656640475', '13656640475', null, null, '0', null, null, '2019-07-11 14:05:18', '2019-07-11 14:05:18', '1', null);
INSERT INTO `t_student_info` VALUES ('153', '111', '1', 'login011', '0', 'yanyifei@126.com', '\0', '123456', '测试人员', null, null, null, '13656640476', '13656640475', null, null, '0', '1', '1', '2019-07-23 21:37:29', '2019-07-23 21:37:29', '1', null);

-- ----------------------------
-- Table structure for t_student_star_info
-- ----------------------------
DROP TABLE IF EXISTS `t_student_star_info`;
CREATE TABLE `t_student_star_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `student_id` bigint(20) NOT NULL COMMENT '学生ID',
  `tearcher_id` bigint(20) NOT NULL COMMENT '老师ID',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  `name` varchar(80) NOT NULL COMMENT '什么之星的名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student_star_info
-- ----------------------------
INSERT INTO `t_student_star_info` VALUES ('2', '1', '1', '1', '1', '2019-08-03 22:47:58', '2019-08-03 22:47:58', '1', 'ssadsad');
INSERT INTO `t_student_star_info` VALUES ('3', '1', '1', '1', '1', '2019-08-03 22:48:32', '2019-08-03 22:48:32', '1', 'sdasd');

-- ----------------------------
-- Table structure for t_sys_info
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_info`;
CREATE TABLE `t_sys_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sys_key` varchar(80) NOT NULL COMMENT '系统设置信息的关键字',
  `sys_value` text COMMENT '系统信息的内容',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统信息表';

-- ----------------------------
-- Records of t_sys_info
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_log_info
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_log_info`;
CREATE TABLE `t_sys_log_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `operation_sys` tinyint(4) NOT NULL COMMENT '操作系统0:web系统，1：老师系统，2：学生系统',
  `operation_id` bigint(20) DEFAULT NULL COMMENT '操作人ID',
  `operation_uuid` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '操作链路的UUID',
  `operation_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人的名称',
  `operation_content` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '操作内容',
  `operation_code` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '操作code',
  `operation_result` longtext COLLATE utf8_bin COMMENT '返回结果',
  `operation_detail` longtext COLLATE utf8_bin COMMENT '参数内容',
  `operation_ip` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '操作地址',
  `log_type` tinyint(4) DEFAULT NULL COMMENT '日志类型',
  `obj_id` varbinary(80) DEFAULT NULL COMMENT '唯一表示',
  `sign` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '方法签名',
  `obj_type` int(11) DEFAULT NULL COMMENT '方法类型',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_id` int(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` int(11) DEFAULT NULL COMMENT '修改人',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=792668 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='日志信息表';

-- ----------------------------
-- Records of t_sys_log_info
-- ----------------------------

-- ----------------------------
-- Table structure for t_teacher_role
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher_role`;
CREATE TABLE `t_teacher_role` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `staff_id` bigint(20) NOT NULL COMMENT '账号ID',
  PRIMARY KEY (`role_id`,`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='账号角色信息关联表';

-- ----------------------------
-- Records of t_teacher_role
-- ----------------------------
INSERT INTO `t_teacher_role` VALUES ('41', '3');
INSERT INTO `t_teacher_role` VALUES ('41', '4');
INSERT INTO `t_teacher_role` VALUES ('41', '5');

-- ----------------------------
-- Table structure for t_teacher_staff_info
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher_staff_info`;
CREATE TABLE `t_teacher_staff_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `id_card` varchar(80) DEFAULT NULL COMMENT '身份ID',
  `name` varchar(50) NOT NULL COMMENT '教职工的登录名字',
  `sex` tinyint(4) NOT NULL COMMENT '0:表示男，1:表示女',
  `staff_type` tinyint(4) NOT NULL COMMENT '职位类型，0:校长，1:老师',
  `staff_name` varchar(255) NOT NULL COMMENT '职位名称',
  `email` varchar(255) NOT NULL COMMENT '邮件',
  `is_enabled` bit(1) NOT NULL COMMENT '是否可用',
  `is_locked` bit(1) DEFAULT NULL,
  `locked_date` datetime DEFAULT NULL,
  `login_date` datetime DEFAULT NULL,
  `login_failure_count` int(11) DEFAULT NULL COMMENT '失败次数',
  `login_ip` varchar(255) DEFAULT NULL COMMENT '登录IP',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `real_name` varchar(100) NOT NULL COMMENT '真实的姓名',
  `header_url` longtext COMMENT '头像图片',
  `header_info` longtext COMMENT '头像特征信息',
  `birth_time` timestamp NULL DEFAULT NULL COMMENT '生日',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `app_room_id` bigint(20) DEFAULT NULL COMMENT 'app对应的教室',
  `telephone` varchar(20) DEFAULT NULL COMMENT '电话好吗',
  `is_deleted` tinyint(4) NOT NULL COMMENT '是否已经删除',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  `web_token` varchar(80) DEFAULT NULL COMMENT '登录的TOKEN',
  `pad_app_token` varchar(80) DEFAULT NULL COMMENT '登录的TOKEN',
  `app_token` varchar(80) DEFAULT NULL COMMENT '登录的TOKEN',
  `face_version` int(10) DEFAULT NULL COMMENT '头部特征版本号',
  PRIMARY KEY (`id`,`name`,`sex`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='教职工表';

-- ----------------------------
-- Records of t_teacher_staff_info
-- ----------------------------
INSERT INTO `t_teacher_staff_info` VALUES ('1', '3330682198709163019', 'yanyifei', '0', '0', '校长', 'yanyifei6@126.com', '', '\0', null, null, '0', null, 'c6ee490b15875cf54964b6d7b0f38f88', '严逸飞', null, null, null, null, null, null, '0', null, null, '2019-06-30 13:09:06', '2019-07-22 14:33:57', '1', null, null, null, null);
INSERT INTO `t_teacher_staff_info` VALUES ('3', '12345678', 'login', '0', '1', '老师', 'test@126.com', '', '\0', null, null, '0', null, 'c6ee490b15875cf54964b6d7b0f38f88', '测试人员', null, 'OmplbwkgNxUYTAxnkqXMnEANIP+3gVEEsVqw9uR723O3j4NPedSYyw3q48cpDg68tE8W36ZOViUo\nzrUokl/JLcKZpa8DAAxWScmaJx4RlF6E1EfAe8pIRHuZLkkeFsMzXLmE8EoBYQuUBEN48vNXfPcL\nn+B6XBhlduMs6f1WspNXTVJv9y78623jWOcs0izjEJNIgM3TPftQPWx36jM5jGzfuc+6uqs1m15C\nxwnJbUOR1QGgEDWS2xK1ZldUUQGsiM/LUHj2fauFn6/YQMzC3DMWfL40FHy7kcweNwMzhky7ecmP\nQr1xdPYFpXipHOYD39xzn/NQeZtjqQCXbeRGE/SVjm/swjsUNNC9GKXmB2OmTBGBbB4RBGeVTXfT\nP6NzNI87smtSFbXD8hVHwFq2wwuOCqBsu1OkzHDFV+AV+FOhz3ovULPmK6vDjyeXSlFccJYtP4hB\ndbvLtSzImWRMTl5ogfBnel0LMJI5+2YUioPifU2fJs30G9U2zRdWPIOTHXsH7wT3YBTCLMkZyWQl\nY3UjQX9KuoB7LPTYd8MIbw5YbqcwjHcNNCZWCkePi/G9f7m7Xwc3LlttkSVXeOCzU6VQ+tCriYDV\nvLxlpysmjV2cWENAIO+kxGrG1LdqrdJN9SXUj13ikXRvLxsHc+vfA/rDKh9oQj2b4ULU6kD48mw=\n', null, '13656640476', '1', '13656640475', '0', null, '3', '2019-07-08 15:25:00', '2019-08-05 18:35:44', '1', null, '8e51d54d26da4e06a649507123c272fa', '9d07f216c6224c599c15f5220dc33325', '2');
INSERT INTO `t_teacher_staff_info` VALUES ('4', null, '2222', '1', '1', '老师', 'yanyifei@zcckj.com', '', null, null, null, null, null, '123456', '姓名', null, null, null, '13656640475', null, '13656640475', '0', '1', '1', '2019-07-25 17:12:00', '2019-07-25 17:12:31', '1', null, null, null, null);
INSERT INTO `t_teacher_staff_info` VALUES ('5', null, 'ytx', '1', '1', '老师', '380267314@qq.com', '', null, null, null, null, null, '123456', '虞廷秀', null, null, null, '15397188687', null, '15397188687', '0', '1', '1', '2019-07-26 10:10:44', '2019-07-26 10:10:44', '1', null, null, null, null);

-- ----------------------------
-- Table structure for t_temporary_class_mate
-- ----------------------------
DROP TABLE IF EXISTS `t_temporary_class_mate`;
CREATE TABLE `t_temporary_class_mate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '班级名称',
  `course_id` bigint(20) NOT NULL COMMENT '所属的课程',
  `description` text COMMENT '班级描述',
  `is_deleted` tinyint(4) NOT NULL COMMENT '是否已经删除',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='课程临时班级';

-- ----------------------------
-- Records of t_temporary_class_mate
-- ----------------------------
INSERT INTO `t_temporary_class_mate` VALUES ('1', '临时班级的名称', '1', null, '0', '3', '3', '2019-07-15 21:49:46', '2019-07-15 21:49:46', '1');
INSERT INTO `t_temporary_class_mate` VALUES ('2', '实验一班1', '2', null, '0', '3', '3', '2019-07-31 12:54:05', '2019-07-31 12:54:05', '1');

-- ----------------------------
-- Table structure for t_temporary_student_class_mate
-- ----------------------------
DROP TABLE IF EXISTS `t_temporary_student_class_mate`;
CREATE TABLE `t_temporary_student_class_mate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `temporary_class_id` bigint(20) NOT NULL COMMENT '临时班级的ID',
  `classmate_id` bigint(20) NOT NULL COMMENT '所在的班级',
  `student_id` bigint(20) NOT NULL COMMENT '学生ID',
  `is_register` tinyint(4) DEFAULT NULL COMMENT '是否签到',
  `is_ask_level` tinyint(4) DEFAULT NULL COMMENT '是否请假',
  `register_command_id` bigint(20) DEFAULT NULL COMMENT '签到命令的ID',
  `machine_id` bigint(20) DEFAULT NULL COMMENT '分配的机床的ID',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8 COMMENT='临时班级与学员信息';

-- ----------------------------
-- Records of t_temporary_student_class_mate
-- ----------------------------
INSERT INTO `t_temporary_student_class_mate` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '3', '3', '2019-07-15 21:49:46', '2019-07-31 20:43:15', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('2', '1', '1', '2', null, null, null, null, '3', '3', '2019-07-15 21:49:46', '2019-07-15 21:49:46', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('3', '1', '1', '3', null, null, null, null, '3', '3', '2019-07-15 21:49:47', '2019-07-15 21:49:47', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('4', '1', '1', '4', null, null, null, null, '3', '3', '2019-07-15 21:49:47', '2019-07-15 21:49:47', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('5', '1', '1', '5', null, null, null, null, '3', '3', '2019-07-15 21:49:47', '2019-07-15 21:49:47', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('6', '1', '1', '6', null, null, null, null, '3', '3', '2019-07-15 21:49:47', '2019-07-15 21:49:47', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('7', '1', '1', '7', null, null, null, null, '3', '3', '2019-07-15 21:49:48', '2019-07-15 21:49:48', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('8', '1', '1', '8', null, null, null, null, '3', '3', '2019-07-15 21:49:48', '2019-07-15 21:49:48', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('9', '1', '1', '9', null, null, null, null, '3', '3', '2019-07-15 21:49:48', '2019-07-15 21:49:48', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('10', '1', '1', '10', null, null, null, null, '3', '3', '2019-07-15 21:49:48', '2019-07-15 21:49:48', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('11', '1', '1', '11', null, null, null, null, '3', '3', '2019-07-15 21:49:49', '2019-07-15 21:49:49', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('12', '1', '1', '12', null, null, null, null, '3', '3', '2019-07-15 21:49:49', '2019-07-15 21:49:49', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('13', '1', '1', '13', null, null, null, null, '3', '3', '2019-07-15 21:49:49', '2019-07-15 21:49:49', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('14', '1', '1', '14', null, null, null, null, '3', '3', '2019-07-15 21:49:49', '2019-07-15 21:49:49', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('15', '1', '1', '15', null, null, null, null, '3', '3', '2019-07-15 21:49:49', '2019-07-15 21:49:49', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('16', '1', '1', '16', null, null, null, null, '3', '3', '2019-07-15 21:49:50', '2019-07-15 21:49:50', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('17', '1', '1', '17', null, null, null, null, '3', '3', '2019-07-15 21:49:50', '2019-07-15 21:49:50', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('18', '1', '1', '18', null, null, null, null, '3', '3', '2019-07-15 21:49:50', '2019-07-15 21:49:50', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('19', '1', '1', '19', null, null, null, null, '3', '3', '2019-07-15 21:49:50', '2019-07-15 21:49:50', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('20', '1', '1', '20', null, null, null, null, '3', '3', '2019-07-15 21:49:50', '2019-07-15 21:49:50', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('21', '1', '1', '21', null, null, null, null, '3', '3', '2019-07-15 21:49:51', '2019-07-15 21:49:51', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('22', '1', '1', '22', null, null, null, null, '3', '3', '2019-07-15 21:49:51', '2019-07-15 21:49:51', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('23', '1', '1', '23', null, null, null, null, '3', '3', '2019-07-15 21:49:51', '2019-07-15 21:49:51', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('24', '1', '1', '24', null, null, null, null, '3', '3', '2019-07-15 21:49:51', '2019-07-15 21:49:51', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('25', '1', '1', '25', null, null, null, null, '3', '3', '2019-07-15 21:49:51', '2019-07-15 21:49:51', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('26', '1', '1', '26', null, null, null, null, '3', '3', '2019-07-15 21:49:52', '2019-07-15 21:49:52', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('27', '1', '1', '27', null, null, null, null, '3', '3', '2019-07-15 21:49:52', '2019-07-15 21:49:52', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('28', '1', '1', '28', null, null, null, null, '3', '3', '2019-07-15 21:49:53', '2019-07-15 21:49:53', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('29', '1', '1', '29', null, null, null, null, '3', '3', '2019-07-15 21:49:53', '2019-07-15 21:49:53', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('30', '1', '1', '30', null, null, null, null, '3', '3', '2019-07-15 21:49:53', '2019-07-15 21:49:53', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('31', '1', '1', '31', null, null, null, null, '3', '3', '2019-07-15 21:49:54', '2019-07-15 21:49:54', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('32', '1', '1', '32', null, null, null, null, '3', '3', '2019-07-15 21:49:54', '2019-07-15 21:49:54', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('33', '1', '1', '33', null, null, null, null, '3', '3', '2019-07-15 21:49:54', '2019-07-15 21:49:54', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('34', '1', '1', '34', null, null, null, null, '3', '3', '2019-07-15 21:49:55', '2019-07-15 21:49:55', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('35', '1', '1', '35', null, null, null, null, '3', '3', '2019-07-15 21:49:55', '2019-07-15 21:49:55', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('36', '1', '1', '36', null, null, null, null, '3', '3', '2019-07-15 21:49:56', '2019-07-15 21:49:56', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('37', '1', '1', '37', null, null, null, null, '3', '3', '2019-07-15 21:49:56', '2019-07-15 21:49:56', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('38', '1', '1', '38', null, null, null, null, '3', '3', '2019-07-15 21:49:56', '2019-07-15 21:49:56', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('39', '1', '1', '39', null, null, null, null, '3', '3', '2019-07-15 21:49:56', '2019-07-15 21:49:56', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('40', '1', '1', '40', null, null, null, null, '3', '3', '2019-07-15 21:49:57', '2019-07-15 21:49:57', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('41', '1', '1', '41', null, null, null, null, '3', '3', '2019-07-15 21:49:57', '2019-07-15 21:49:57', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('42', '1', '1', '42', null, null, null, null, '3', '3', '2019-07-15 21:49:58', '2019-07-15 21:49:58', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('43', '1', '1', '43', null, null, null, null, '3', '3', '2019-07-15 21:49:58', '2019-07-15 21:49:58', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('44', '1', '1', '44', null, null, null, null, '3', '3', '2019-07-15 21:49:58', '2019-07-15 21:49:58', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('45', '1', '1', '45', null, null, null, null, '3', '3', '2019-07-15 21:49:59', '2019-07-15 21:49:59', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('46', '1', '1', '46', null, null, null, null, '3', '3', '2019-07-15 21:49:59', '2019-07-15 21:49:59', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('47', '1', '1', '47', null, null, null, null, '3', '3', '2019-07-15 21:50:00', '2019-07-15 21:50:00', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('48', '1', '1', '48', null, null, null, null, '3', '3', '2019-07-15 21:50:00', '2019-07-15 21:50:00', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('49', '1', '1', '49', null, null, null, null, '3', '3', '2019-07-15 21:50:00', '2019-07-15 21:50:00', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('50', '1', '1', '50', null, null, null, null, '3', '3', '2019-07-15 21:50:01', '2019-07-15 21:50:01', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('51', '1', '1', '51', null, null, null, null, '3', '3', '2019-07-15 21:50:01', '2019-07-15 21:50:01', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('52', '1', '2', '52', null, null, null, null, '3', '3', '2019-07-15 21:50:01', '2019-07-15 21:50:01', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('53', '1', '2', '53', null, null, null, null, '3', '3', '2019-07-15 21:50:02', '2019-07-15 21:50:02', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('54', '1', '2', '54', null, null, null, null, '3', '3', '2019-07-15 21:50:02', '2019-07-15 21:50:02', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('55', '1', '2', '55', null, null, null, null, '3', '3', '2019-07-15 21:50:02', '2019-07-15 21:50:02', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('56', '1', '2', '56', null, null, null, null, '3', '3', '2019-07-15 21:50:03', '2019-07-15 21:50:03', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('57', '1', '2', '57', null, null, null, null, '3', '3', '2019-07-15 21:50:03', '2019-07-15 21:50:03', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('58', '1', '2', '58', null, null, null, null, '3', '3', '2019-07-15 21:50:03', '2019-07-15 21:50:03', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('59', '1', '2', '59', null, null, null, null, '3', '3', '2019-07-15 21:50:03', '2019-07-15 21:50:03', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('60', '1', '2', '60', null, null, null, null, '3', '3', '2019-07-15 21:50:04', '2019-07-15 21:50:04', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('61', '1', '2', '61', null, null, null, null, '3', '3', '2019-07-15 21:50:04', '2019-07-15 21:50:04', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('62', '1', '2', '62', null, null, null, null, '3', '3', '2019-07-15 21:50:05', '2019-07-15 21:50:05', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('63', '1', '2', '63', null, null, null, null, '3', '3', '2019-07-15 21:50:05', '2019-07-15 21:50:05', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('64', '1', '2', '64', null, null, null, null, '3', '3', '2019-07-15 21:50:05', '2019-07-15 21:50:05', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('65', '1', '2', '65', null, null, null, null, '3', '3', '2019-07-15 21:50:05', '2019-07-15 21:50:05', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('66', '1', '2', '66', null, null, null, null, '3', '3', '2019-07-15 21:50:06', '2019-07-15 21:50:06', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('67', '1', '2', '67', null, null, null, null, '3', '3', '2019-07-15 21:50:06', '2019-07-15 21:50:06', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('68', '1', '2', '68', null, null, null, null, '3', '3', '2019-07-15 21:50:06', '2019-07-15 21:50:06', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('69', '1', '2', '69', null, null, null, null, '3', '3', '2019-07-15 21:50:06', '2019-07-15 21:50:06', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('70', '1', '2', '70', null, null, null, null, '3', '3', '2019-07-15 21:50:07', '2019-07-15 21:50:07', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('71', '1', '2', '71', null, null, null, null, '3', '3', '2019-07-15 21:50:07', '2019-07-15 21:50:07', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('72', '1', '2', '72', null, null, null, null, '3', '3', '2019-07-15 21:50:07', '2019-07-15 21:50:07', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('73', '1', '2', '73', null, null, null, null, '3', '3', '2019-07-15 21:50:08', '2019-07-15 21:50:08', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('74', '1', '2', '74', null, null, null, null, '3', '3', '2019-07-15 21:50:08', '2019-07-15 21:50:08', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('75', '1', '2', '75', null, null, null, null, '3', '3', '2019-07-15 21:50:08', '2019-07-15 21:50:08', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('76', '1', '2', '76', null, null, null, null, '3', '3', '2019-07-15 21:50:09', '2019-07-15 21:50:09', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('77', '1', '2', '77', null, null, null, null, '3', '3', '2019-07-15 21:50:09', '2019-07-15 21:50:09', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('78', '1', '2', '78', null, null, null, null, '3', '3', '2019-07-15 21:50:09', '2019-07-15 21:50:09', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('79', '1', '2', '79', null, null, null, null, '3', '3', '2019-07-15 21:50:09', '2019-07-15 21:50:09', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('80', '1', '2', '80', null, null, null, null, '3', '3', '2019-07-15 21:50:10', '2019-07-15 21:50:10', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('81', '1', '2', '81', null, null, null, null, '3', '3', '2019-07-15 21:50:10', '2019-07-15 21:50:10', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('82', '1', '2', '82', null, null, null, null, '3', '3', '2019-07-15 21:50:10', '2019-07-15 21:50:10', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('83', '1', '2', '83', null, null, null, null, '3', '3', '2019-07-15 21:50:10', '2019-07-15 21:50:10', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('84', '1', '2', '84', null, null, null, null, '3', '3', '2019-07-15 21:50:11', '2019-07-15 21:50:11', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('85', '1', '2', '85', null, null, null, null, '3', '3', '2019-07-15 21:50:11', '2019-07-15 21:50:11', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('86', '1', '2', '86', null, null, null, null, '3', '3', '2019-07-15 21:50:12', '2019-07-15 21:50:12', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('87', '1', '2', '87', null, null, null, null, '3', '3', '2019-07-15 21:50:12', '2019-07-15 21:50:12', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('88', '1', '2', '88', null, null, null, null, '3', '3', '2019-07-15 21:50:12', '2019-07-15 21:50:12', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('89', '1', '2', '89', null, null, null, null, '3', '3', '2019-07-15 21:50:12', '2019-07-15 21:50:12', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('90', '1', '2', '90', null, null, null, null, '3', '3', '2019-07-15 21:50:12', '2019-07-15 21:50:12', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('91', '1', '2', '91', null, null, null, null, '3', '3', '2019-07-15 21:50:13', '2019-07-15 21:50:13', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('92', '1', '2', '92', null, null, null, null, '3', '3', '2019-07-15 21:50:13', '2019-07-15 21:50:13', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('93', '1', '2', '93', null, null, null, null, '3', '3', '2019-07-15 21:50:13', '2019-07-15 21:50:13', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('94', '1', '2', '94', null, null, null, null, '3', '3', '2019-07-15 21:50:13', '2019-07-15 21:50:13', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('95', '1', '2', '95', null, null, null, null, '3', '3', '2019-07-15 21:50:14', '2019-07-15 21:50:14', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('96', '1', '2', '96', null, null, null, null, '3', '3', '2019-07-15 21:50:14', '2019-07-15 21:50:14', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('97', '1', '2', '97', null, null, null, null, '3', '3', '2019-07-15 21:50:14', '2019-07-15 21:50:14', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('98', '1', '2', '98', null, null, null, null, '3', '3', '2019-07-15 21:50:14', '2019-07-15 21:50:14', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('99', '1', '2', '99', null, null, null, null, '3', '3', '2019-07-15 21:50:15', '2019-07-15 21:50:15', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('100', '1', '2', '100', null, null, null, null, '3', '3', '2019-07-15 21:50:15', '2019-07-15 21:50:15', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('101', '1', '2', '101', null, null, null, null, '3', '3', '2019-07-15 21:50:15', '2019-07-15 21:50:15', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('102', '2', '1', '1', '1', '1', '1', '1', '3', '3', '2019-07-31 12:54:05', '2019-07-31 20:43:22', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('103', '2', '1', '3', null, null, null, null, '3', '3', '2019-07-31 12:54:05', '2019-07-31 12:54:05', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('104', '2', '1', '4', null, null, null, null, '3', '3', '2019-07-31 12:54:05', '2019-07-31 12:54:05', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('105', '2', '1', '5', null, null, null, null, '3', '3', '2019-07-31 12:54:05', '2019-07-31 12:54:05', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('106', '2', '1', '6', null, null, null, null, '3', '3', '2019-07-31 12:54:06', '2019-07-31 12:54:06', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('107', '2', '1', '7', null, null, null, null, '3', '3', '2019-07-31 12:54:06', '2019-07-31 12:54:06', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('108', '2', '1', '8', null, null, null, null, '3', '3', '2019-07-31 12:54:06', '2019-07-31 12:54:06', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('109', '2', '1', '9', null, null, null, null, '3', '3', '2019-07-31 12:54:06', '2019-07-31 12:54:06', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('110', '2', '1', '10', null, null, null, null, '3', '3', '2019-07-31 12:54:06', '2019-07-31 12:54:06', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('111', '2', '1', '11', null, null, null, null, '3', '3', '2019-07-31 12:54:06', '2019-07-31 12:54:06', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('112', '2', '1', '12', null, null, null, null, '3', '3', '2019-07-31 12:54:06', '2019-07-31 12:54:06', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('113', '2', '1', '13', null, null, null, null, '3', '3', '2019-07-31 12:54:06', '2019-07-31 12:54:06', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('114', '2', '1', '14', null, null, null, null, '3', '3', '2019-07-31 12:54:07', '2019-07-31 12:54:07', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('115', '2', '1', '15', null, null, null, null, '3', '3', '2019-07-31 12:54:07', '2019-07-31 12:54:07', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('116', '2', '1', '16', null, null, null, null, '3', '3', '2019-07-31 12:54:07', '2019-07-31 12:54:07', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('117', '2', '1', '17', null, null, null, null, '3', '3', '2019-07-31 12:54:07', '2019-07-31 12:54:07', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('118', '2', '1', '18', null, null, null, null, '3', '3', '2019-07-31 12:54:07', '2019-07-31 12:54:07', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('119', '2', '1', '19', null, null, null, null, '3', '3', '2019-07-31 12:54:07', '2019-07-31 12:54:07', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('120', '2', '1', '20', null, null, null, null, '3', '3', '2019-07-31 12:54:07', '2019-07-31 12:54:07', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('121', '2', '1', '21', null, null, null, null, '3', '3', '2019-07-31 12:54:07', '2019-07-31 12:54:07', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('122', '2', '1', '22', null, null, null, null, '3', '3', '2019-07-31 12:54:07', '2019-07-31 12:54:07', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('123', '2', '1', '23', null, null, null, null, '3', '3', '2019-07-31 12:54:08', '2019-07-31 12:54:08', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('124', '2', '1', '24', null, null, null, null, '3', '3', '2019-07-31 12:54:08', '2019-07-31 12:54:08', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('125', '2', '1', '25', null, null, null, null, '3', '3', '2019-07-31 12:54:08', '2019-07-31 12:54:08', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('126', '2', '1', '26', null, null, null, null, '3', '3', '2019-07-31 12:54:08', '2019-07-31 12:54:08', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('127', '2', '1', '27', null, null, null, null, '3', '3', '2019-07-31 12:54:08', '2019-07-31 12:54:08', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('128', '2', '1', '28', null, null, null, null, '3', '3', '2019-07-31 12:54:08', '2019-07-31 12:54:08', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('129', '2', '1', '29', null, null, null, null, '3', '3', '2019-07-31 12:54:08', '2019-07-31 12:54:08', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('130', '2', '1', '30', null, null, null, null, '3', '3', '2019-07-31 12:54:08', '2019-07-31 12:54:08', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('131', '2', '1', '31', null, null, null, null, '3', '3', '2019-07-31 12:54:09', '2019-07-31 12:54:09', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('132', '2', '1', '32', null, null, null, null, '3', '3', '2019-07-31 12:54:09', '2019-07-31 12:54:09', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('133', '2', '1', '33', null, null, null, null, '3', '3', '2019-07-31 12:54:09', '2019-07-31 12:54:09', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('134', '2', '1', '34', null, null, null, null, '3', '3', '2019-07-31 12:54:09', '2019-07-31 12:54:09', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('135', '2', '1', '35', null, null, null, null, '3', '3', '2019-07-31 12:54:09', '2019-07-31 12:54:09', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('136', '2', '1', '36', null, null, null, null, '3', '3', '2019-07-31 12:54:09', '2019-07-31 12:54:09', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('137', '2', '1', '37', null, null, null, null, '3', '3', '2019-07-31 12:54:09', '2019-07-31 12:54:09', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('138', '2', '1', '38', null, null, null, null, '3', '3', '2019-07-31 12:54:09', '2019-07-31 12:54:09', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('139', '2', '1', '39', null, null, null, null, '3', '3', '2019-07-31 12:54:09', '2019-07-31 12:54:09', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('140', '2', '1', '40', null, null, null, null, '3', '3', '2019-07-31 12:54:10', '2019-07-31 12:54:10', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('141', '2', '1', '41', null, null, null, null, '3', '3', '2019-07-31 12:54:10', '2019-07-31 12:54:10', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('142', '2', '1', '42', null, null, null, null, '3', '3', '2019-07-31 12:54:10', '2019-07-31 12:54:10', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('143', '2', '1', '43', null, null, null, null, '3', '3', '2019-07-31 12:54:10', '2019-07-31 12:54:10', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('144', '2', '1', '44', null, null, null, null, '3', '3', '2019-07-31 12:54:10', '2019-07-31 12:54:10', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('145', '2', '1', '45', null, null, null, null, '3', '3', '2019-07-31 12:54:10', '2019-07-31 12:54:10', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('146', '2', '1', '46', null, null, null, null, '3', '3', '2019-07-31 12:54:10', '2019-07-31 12:54:10', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('147', '2', '1', '47', null, null, null, null, '3', '3', '2019-07-31 12:54:10', '2019-07-31 12:54:10', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('148', '2', '1', '48', null, null, null, null, '3', '3', '2019-07-31 12:54:10', '2019-07-31 12:54:10', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('149', '2', '1', '49', null, null, null, null, '3', '3', '2019-07-31 12:54:11', '2019-07-31 12:54:11', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('150', '2', '1', '50', null, null, null, null, '3', '3', '2019-07-31 12:54:11', '2019-07-31 12:54:11', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('151', '2', '1', '51', null, null, null, null, '3', '3', '2019-07-31 12:54:11', '2019-07-31 12:54:11', '1');
INSERT INTO `t_temporary_student_class_mate` VALUES ('152', '2', '1', '153', null, null, null, null, '3', '3', '2019-07-31 12:54:11', '2019-07-31 12:54:11', '1');
