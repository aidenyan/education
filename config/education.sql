/*
Navicat MySQL Data Transfer

Source Server         : 94.191.60.104
Source Server Version : 50644
Source Host           : 94.191.60.104:3306
Source Database       : education

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2019-07-22 12:52:11
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='班级信息';

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='教室内容信息';

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='信息交互表主要用于各种命令的信息交互';

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='课程基本信息表';

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
-- Table structure for t_course_student
-- ----------------------------
DROP TABLE IF EXISTS `t_course_student`;
CREATE TABLE `t_course_student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `course_id` bigint(20) NOT NULL COMMENT '课程ID',
  `machine_id` bigint(20) NOT NULL COMMENT '机床ID',
  `courseware_id` bigint(20) NOT NULL COMMENT '课件ID',
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
-- Table structure for t_courseware
-- ----------------------------
DROP TABLE IF EXISTS `t_courseware`;
CREATE TABLE `t_courseware` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '课件名称',
  `description` text COMMENT '描述',
  `is_used` tinyint(4) NOT NULL COMMENT '课件是否已经使用，一旦使用就无法修改课件',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='课件信息表';

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='机床位置信息表';

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
) ENGINE=InnoDB AUTO_INCREMENT=230 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='菜单表';

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='题库信息表\r\n';

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_resource_info
-- ----------------------------
DROP TABLE IF EXISTS `t_resource_info`;
CREATE TABLE `t_resource_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `type` tinyint(4) NOT NULL COMMENT '资源类型，0：图片，1：视频，2:文字；3：图纸,4:图纸的答案',
  `content` text COMMENT '资源的具体内容，如果是图片和视频表示URL,如果是文字则是实际的文字，如果是，图纸则是一个JSON对象里面包含测量点',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `is_deleted` tinyint(4) NOT NULL COMMENT '是否已经删除',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='资源信息表';

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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='站点信息';

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
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8 COMMENT='学生信息表';

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
-- Table structure for t_teacher_role
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher_role`;
CREATE TABLE `t_teacher_role` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `staff_id` bigint(20) NOT NULL COMMENT '账号ID',
  PRIMARY KEY (`role_id`,`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='账号角色信息关联表';

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
  `is_locked` bit(1) NOT NULL,
  `locked_date` datetime DEFAULT NULL,
  `login_date` datetime DEFAULT NULL,
  `login_failure_count` int(11) NOT NULL COMMENT '失败次数',
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='教职工表';

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='课程临时班级';

-- ----------------------------
-- Table structure for t_temporary_student_class_mate
-- ----------------------------
DROP TABLE IF EXISTS `t_temporary_student_class_mate`;
CREATE TABLE `t_temporary_student_class_mate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `temporary_class_id` bigint(20) NOT NULL COMMENT '临时班级的ID',
  `classmate_id` bigint(20) NOT NULL COMMENT '所在的班级',
  `student_id` bigint(20) NOT NULL COMMENT '学生ID',
  `create_id` bigint(11) DEFAULT NULL COMMENT '创建人',
  `modify_id` bigint(11) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `site_id` bigint(20) NOT NULL COMMENT '站点信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8 COMMENT='临时班级与学员信息';
