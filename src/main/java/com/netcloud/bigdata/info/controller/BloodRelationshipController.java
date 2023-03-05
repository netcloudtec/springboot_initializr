package com.netcloud.bigdata.info.controller;

import com.netcloud.bigdata.info.dao.lineage.entity.HiveTableEntity;
import com.netcloud.bigdata.info.dao.lineage.entity.HiveTableRelationEntity;
import com.netcloud.bigdata.info.dao.lineage.interfaces.IHiveLineageRelationTableColumnDao;
import com.netcloud.bigdata.info.dao.lineage.interfaces.IHiveLineageRelationTableDao;
import com.netcloud.bigdata.info.pojo.metadata.HiveLineageInfo;
import com.netcloud.bigdata.info.service.lineage.HiveLineageHandleService;
import com.netcloud.bigdata.info.service.lineage.HiveLineageParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.TreeSet;

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

    @Autowired
    private HiveLineageHandleService hiveLineageHandleService;


    @GetMapping(value="/create")
    public void createHiveNodeRelation(){
        HiveTableEntity table1=new HiveTableEntity();
        table1.setType("hive");
        table1.setTableName("zhidao.table1");
        table1.setDbName("zhidao");
        table1.setTimestamp(System.currentTimeMillis());

        HiveTableEntity tmp_table=new HiveTableEntity();
        tmp_table.setType("hive");
        tmp_table.setTableName("zhidao.tmp_table");
        tmp_table.setDbName("zhidao");
        tmp_table.setTimestamp(System.currentTimeMillis());

        HiveTableEntity table2=new HiveTableEntity();
        table2.setType("hive");
        table2.setTableName("zhidao.table2");
        table2.setDbName("zhidao");
        table2.setTimestamp(System.currentTimeMillis());

        HiveTableRelationEntity hiveTableRelationEntity1=new HiveTableRelationEntity();
        hiveTableRelationEntity1.setStartNode(table1);
        hiveTableRelationEntity1.setEndNode(tmp_table);
        hiveTableRelationEntity1.setStartNodeTableName("zhidao.table1");
        hiveTableRelationEntity1.setEndNodeTableName("zhidao.tmp_table");
        iHiveLineageRelationTableDao.save(hiveTableRelationEntity1);

        HiveTableRelationEntity hiveTableRelationEntity2=new HiveTableRelationEntity();
        hiveTableRelationEntity2.setStartNode(tmp_table);
        hiveTableRelationEntity2.setEndNode(table2);
        hiveTableRelationEntity2.setStartNodeTableName("zhidao.tmp_table");
        hiveTableRelationEntity2.setEndNodeTableName("zhidao.table2");
        iHiveLineageRelationTableDao.save(hiveTableRelationEntity2);

    }

    /**
     * 根据表名查询其上下游依赖表
     * @return
     */
    @GetMapping(value="/getTableRelationEntity")
    public List<HiveTableRelationEntity> getTableRelationEntity() {
        List<HiveTableRelationEntity> outRelations = iHiveLineageRelationTableDao.findByStartNodeTableName("zhidao.tmp_table");
        List<HiveTableRelationEntity> inRelations = iHiveLineageRelationTableDao.findByEndNodeTableName("zhidao.table1");
        return outRelations;
    }

    /**
     * 构建依赖关系
     * @return
     */
    @GetMapping(value="/buildRelation")
    public void buildRelation(){
        String query = "insert into t1 select t2.a, t3.b from t2, t3 where t2.id = t3.id";
        hiveLineageHandleService.buildRelation(query);

    }
}
