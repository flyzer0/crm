-- ----------------------------
-- Table structure for select_tags
-- ----------------------------
DROP TABLE IF EXISTS `select_tags`;
CREATE TABLE `select_tags`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tag_type` varchar(1)  DEFAULT '0' COMMENT '标签类型',
  `biz_type` varchar(255)  DEFAULT NULL COMMENT '业务类型',
  `name` varchar(100)  NOT NULL COMMENT '标签名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB  DEFAULT CHARSET=utf8 COMMENT = '标签表';

-- ----------------------------
-- Table structure for select_info
-- ----------------------------
DROP TABLE IF EXISTS `select_info`;
CREATE TABLE `select_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `table` varchar(50)  NOT NULL COMMENT '表名',
  `record_id` varchar(100)  NOT NULL COMMENT '记录id',
  `record_es_id` varchar(100)  NOT NULL COMMENT 'es中对应的id',
  `select_rating` int NOT NULL COMMENT '精选分数',
  `select_datetime` datetime(0)  DEFAULT NULL  COMMENT '精选时间',
  `select_title` varchar(255)  DEFAULT NULL COMMENT '新标题',
  `select_stick` varchar(1)  DEFAULT '0' COMMENT '是否置顶',
  `select_keypoint` text  DEFAULT NULL COMMENT '新摘要',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `table_id`(`table`,`record_id`) USING BTREE
) ENGINE = InnoDB  DEFAULT CHARSET=utf8 COMMENT = '精选文章表';

-- ----------------------------
-- Table structure for info_tags
-- ----------------------------
DROP TABLE IF EXISTS `info_tags`;
CREATE TABLE `info_tags`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `info_id` bigint(20) NOT NULL COMMENT 'select_info中对应的id',
  `tag_id` bigint(20) NOT NULL COMMENT '在select_tags中对应的id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `info_tags_id`(`info_id`,`tag_id`) USING BTREE
) ENGINE = InnoDB  DEFAULT CHARSET=utf8 COMMENT = '精选文章与标签关联表';
