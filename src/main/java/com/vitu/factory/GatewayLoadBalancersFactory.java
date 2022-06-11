package com.vitu.factory;

import com.vitu.config.GatewayProperties;
import io.micronaut.context.annotation.Factory;
import io.micronaut.http.client.LoadBalancer;
import io.micronaut.http.client.loadbalance.DiscoveryClientLoadBalancerFactory;
import jakarta.inject.Singleton;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Factory
public class GatewayLoadBalancersFactory {

    @Singleton
    public Map<String, LoadBalancer> serviceLoadBalancer(GatewayProperties gatewayProperties,
                                                         DiscoveryClientLoadBalancerFactory factory) {
        Set<String> services = gatewayProperties.getServices();
        Map<String, LoadBalancer> loadBalancerMap = new HashMap<>();
        services.forEach(service -> loadBalancerMap.put(service, factory.create(service)));
        return Collections.unmodifiableMap(loadBalancerMap);
    }
}
