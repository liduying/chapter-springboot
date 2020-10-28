CREATE DATABASE IF NOT EXISTS one_master
			DEFAULT CHARACTER SET utf8mb4
			DEFAULT COLLATE utf8mb4_bin;
CREATE TABLE `one_master`.`alarm_record` (
  `id` varchar(36) COLLATE utf8mb4_bin NOT NULL,
  `name` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  `type` int(11) COLLATE utf8mb4_bin DEFAULT NULL,
  `alarmStartTime` datetime COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

CREATE TABLE `alarm_record` (
  `id` varchar(36) COLLATE utf8mb4_bin NOT NULL,
  `name` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `alarm_start_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

CREATE TABLE `alarm_record_handle` (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `alarm_disposal_type_code` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '报警处置类型编码',
  `alarm_disposal_type_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '报警处置类型名称',
  `handle_measure` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '处理措施',
  `create_time` timestamp NULL DEFAULT NULL,
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;


CREATE TABLE `alarm_record_handle_relat` (
  `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT 'id',
  `alarm_record_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '报警记录id',
  `alarm_record_handle_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '报警处置id',
  `alarm_handle_batch_no` varchar(36) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '报警处置批次号',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='报警处置批量操作表';

CREATE TABLE `app_info` (
  `id` varchar(36) COLLATE utf8mb4_bin NOT NULL,
  `name` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  `url` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `code` varchar(36) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

CREATE TABLE `app_org_tranport_status` (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `code` varchar(64) DEFAULT NULL COMMENT '编码',
  `app_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '系统id',
  `status_code` varchar(64) DEFAULT NULL COMMENT '传输状态',
  `status_msg` varchar(64) DEFAULT NULL COMMENT '状态说明',
  `status_time` timestamp NULL DEFAULT NULL COMMENT '获取状态时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

CREATE TABLE `task_record` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT 'id',
  `task_item_id` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '任务项id',
  `business_key` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '业务key',
  `task_status` int(11) DEFAULT '0' COMMENT '任务状态(0:代办，2:已办)',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='任务记录表';

CREATE TABLE `task_record_target` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT 'id',
  `task_id` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '任务id',
  `target_key` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '对象标识',
  `target_key_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '对象标识名称',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='任务日志表';