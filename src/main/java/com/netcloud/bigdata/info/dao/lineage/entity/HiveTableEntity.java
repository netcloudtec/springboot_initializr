package com.netcloud.bigdata.info.dao.lineage.entity;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author netcloud
 * @date 2023-03-02 14:30:21
 * @email netcloudtec@163.com
 * @description Hive表实体类
 */
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@NodeEntity(label = "HiveTable")
public class HiveTableEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String uuid;

    //类型
    private String type;
    //表名
    private String tableName;
    //库名
    private String dbName;
    //入neo4j 时间戳
    private Long timestamp;
    //数据分区
    // private String partation;

    //未来可加入 表字段以及其他属性
}

