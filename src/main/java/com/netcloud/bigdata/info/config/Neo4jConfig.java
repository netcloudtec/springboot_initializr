package com.netcloud.bigdata.info.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author netcloud
 * @date 2023-03-02 15:57:29
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "com.netcloud.bigdata.info.dao.lineage.interfaces")
@EnableTransactionManagement
public class Neo4jConfig {
    @Value("${spring.data.neo4j.uri}")
    private String databaseUrl;

    @Value("${spring.data.neo4j.username}")
    private String userName;

    @Value("${spring.data.neo4j.password}")
    private String password;

    @Bean
    public SessionFactory sessionFactory() {
        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
                .uri(databaseUrl)
                .credentials(userName, password)
                .build();
        return new SessionFactory(configuration, "com.netcloud.bigdata.info.dao.lineage.entity");
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }
}
