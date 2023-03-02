# 工程简介

# 编译打包
mvn clean install

# Neo4j 维护
1. 清除 hive 表血缘关系数据

   ```
   清除结点关系
   MATCH (n:HiveTabel)-[r]-() DELETE n,r;

   清除结点
   MATCH (n:HiveTabel)  DELETE n;
   ```

2. 删除某个表的上游及关系
```
Match data=(nb:HiveTable)-[*1..1]->(na:HiveTable) WHERE na.tableName = '{}' detach delete data
```

3. 清除 hive 列血缘关系数据

   ```
   清除结点关系
   MATCH (n:HiveColumn)-[r]-() DELETE n,r;

   清除结点
   MATCH (n:HiveColumn)  DELETE n;
   ```


