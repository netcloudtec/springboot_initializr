package com.netcloud.bigdata.info.dao.lineage.interfaces;

import com.netcloud.bigdata.info.dao.lineage.entity.HiveColumnRelationEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @author netcloud
 * @date 2023-03-02 14:36:22
 * @email netcloudtec@163.com
 * @description Hive列血缘接口
 */
@Repository
public interface IHiveLineageRelationTableColumnDao extends Neo4jRepository<HiveColumnRelationEntity, Long> {
}
