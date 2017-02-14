package com.nyshup.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ruslan on 2/14/17.
 */
@FeignClient("ADJECTIVE-SERVICE")
public interface AdjectiveService {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String getWord();
}
