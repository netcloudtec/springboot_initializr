package com.netcloud.bigdata.info.dao.lineage.entity;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author netcloud
 * @date 2023-03-02 14:31:31
 * @email netcloudtec@163.com
 * @description Hive列实体类
 */
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@NodeEntity(label = "HiveColumn")
public  class HiveColumnEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String uuid;

    //类型
    private String type;

    //字段名称
    private String columnName;

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
