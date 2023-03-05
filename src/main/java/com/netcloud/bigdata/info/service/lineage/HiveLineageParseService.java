package com.netcloud.bigdata.info.service.lineage;

import com.netcloud.bigdata.info.pojo.metadata.HiveLineageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author netcloud
 * @date 2023-03-03 11:50:08
 * @email netcloudtec@163.com
 * @description
 */
public class HiveLineageParseService {
    private final static Logger logger = LoggerFactory.getLogger(HiveLineageParseService.class);

    public static HiveLineageInfo parseLineage(String sql){

        try {
            HiveLineageInfo hiveLineageInfo = new HiveLineageInfo();
            hiveLineageInfo.getLineageInfo(sql);
            return hiveLineageInfo;
        } catch (Exception e) {
            logger.info("HiveLineageService.parseLineage not parse error sql = > {}" ,sql);
        }
        return null;
    }
}
