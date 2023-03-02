package com.netcloud.bigdata.info.controller;

import com.netcloud.bigdata.info.dao.lineage.entity.HiveTableEntity;
import com.netcloud.bigdata.info.dao.lineage.entity.HiveTableRelationEntity;
import com.netcloud.bigdata.info.dao.lineage.interfaces.IHiveLineageRelationTableColumnDao;
import com.netcloud.bigdata.info.dao.lineage.interfaces.IHiveLineageRelationTableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author netcloud
 * @date 2023-03-02 14:39:10
 * @email netcloudtec@163.com
 * @description
 */
@RestController
@RequestMapping("/node")
public class BloodRelationshipController {

    @Autowired
    private IHiveLineageRelationTableDao iHiveLineageRelationTableDao;

    @Autowired
    private IHiveLineageRelationTableColumnDao iHiveLineageRelationTableColumnDao;


    @GetMapping(value="/create")
    public void createHiveNodeRelation(){
        HiveTableEntity table1=new HiveTableEntity();
        table1.setType("hive");
        table1.setTableName("zhidao.table1");
        table1.setDbName("zhidao");
        table1.setTimestamp(System.currentTimeMillis());

        HiveTableEntity table2=new HiveTableEntity();
        table2.setType("hive");
        table2.setTableName("zhidao.table2");
        table2.setDbName("zhidao");
        table2.setTimestamp(System.currentTimeMillis());

        HiveTableRelationEntity hiveTableRelationEntity=new HiveTableRelationEntity();
        hiveTableRelationEntity.setStartNode(table1);
        hiveTableRelationEntity.setEndNode(table2);
        hiveTableRelationEntity.setStartNodeTableName("zhidao.table1");
        hiveTableRelationEntity.setEndNodeTableName("zhidao.table2");
        iHiveLineageRelationTableDao.save(hiveTableRelationEntity);
    }
}
