package com.netcloud.bigdata.info.service.lineage;

import com.google.common.base.Preconditions;
import com.netcloud.bigdata.info.pojo.metadata.HiveLineageInfo;
import org.springframework.stereotype.Service;

import java.util.TreeSet;

/**
 * @author netcloud
 * @date 2023-03-03 11:47:41
 * @email netcloudtec@163.com
 * @description
 */
@Service
public class HiveLineageHandleService {
    public  void buildRelation(String sql) {
        Preconditions.checkNotNull(sql);
        HiveLineageInfo hiveLineageInfo = HiveLineageParseService.parseLineage(sql);
        TreeSet inputTableList = hiveLineageInfo.getInputTableList();
        TreeSet outputTableList = hiveLineageInfo.getOutputTableList();
    }
}
