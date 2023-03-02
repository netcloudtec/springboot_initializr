package com.netcloud.bigdata.info.dao.lineage.interfaces;

import com.netcloud.bigdata.info.dao.lineage.entity.HiveTableRelationEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @author netcloud
 * @date 2023-03-02 14:35:07
 * @email netcloudtec@163.com
 * @description Hive表血缘接口
 */
@Repository
public interface IHiveLineageRelationTableDao extends Neo4jRepository<HiveTableRelationEntity, Long> {
}
