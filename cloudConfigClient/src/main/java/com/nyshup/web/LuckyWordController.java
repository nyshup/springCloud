package com.nyshup.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ruslan on 2/13/17.
 */
@RestController
public class LuckyWordController {

    @Value("${lucky-word}")
    private String word;

    @RequestMapping("/luckyword")
    public String luckyWord() {
        return word;
    }

}
