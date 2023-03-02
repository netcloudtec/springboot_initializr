package com.netcloud.bigdata.info.dao.lineage.entity;

import lombok.*;
import org.neo4j.ogm.annotation.*;

/**
 * @author netcloud
 * @date 2023-03-02 14:32:17
 * @email netcloudtec@163.com
 * @description
 */
@RelationshipEntity(type = "lineage")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
public class HiveTableRelationEntity {

    /**
     * Neo4j会分配的ID（节点唯一标识 当前类中有效）
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 定义关系的名称
     */
    private String name = "lineage";


    /**
     * 定义关系的起始节点 == StartNode
     */

    @StartNode
    private HiveTableEntity startNode;

    /**
     * 定义关系的终止节点 == EndNode
     */

    @EndNode
    private HiveTableEntity endNode;

    /*
     * 起点表名
     * */
    private String startNodeTableName;

    /*
     * 终点表名
     * */
    private String endNodeTableName;

}

