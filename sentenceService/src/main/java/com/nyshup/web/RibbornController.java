package com.nyshup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class RibbornController {

    @Autowired
    LoadBalancerClient client;

    @RequestMapping("/sentence")
    public @ResponseBody
    String getSentence() {
        return getWord("subject-service") + " "
                + getWord("verb-service") + " "
                + getWord("article-service") + " "
                + getWord("adjective-service") + " "
                + getWord("noun-service") + ".";
    }

    public String getWord(String service) {
        ServiceInstance instance = client.choose(service);
        if (instance != null) {
            URI uri = instance.getUri();
            if (uri !=null ) {
                return (new RestTemplate()).getForObject(uri,String.class);
            }
        }
        return null;
    }
}
