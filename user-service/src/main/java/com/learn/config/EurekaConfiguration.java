package com.learn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EurekaConfiguration {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private int serverPort;

    @Bean
    public EurekaInstanceConfigBean eurekaInstanceConfigBean(InetUtils inetUtils) {
        EurekaInstanceConfigBean bean = new EurekaInstanceConfigBean(inetUtils);

        // 1. Force registration on localhost
        bean.setPreferIpAddress(true);
        bean.setIpAddress("127.0.0.1");
        bean.setHostname("localhost");

        // 2. Set the application name that Eureka will display
        bean.setAppname(appName.toUpperCase());      // e.g. COMMENT-SERVICE
        bean.setVirtualHostName(appName);            // for ribbon/load-balancer
        bean.setSecureVirtualHostName(appName);

        // 3. Define the port (non-secure)
        bean.setNonSecurePort(serverPort);

        // 4. Create an explicit instanceId so Eureka shows ip:app:port
        String instanceId = bean.getIpAddress() + ":" + appName + ":" + serverPort;
        bean.setInstanceId(instanceId);

        // 5. Short leases for faster dev feedback
        bean.setLeaseRenewalIntervalInSeconds(5);
        bean.setLeaseExpirationDurationInSeconds(10);

        return bean;
    }
}
