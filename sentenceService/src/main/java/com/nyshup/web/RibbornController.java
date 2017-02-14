package com.nyshup.web;

import com.nyshup.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RibbornController {

    @Autowired
    private WordService wordService;


    @RequestMapping("/sentence")
    public @ResponseBody
    String getSentence() {
        return wordService.getSubject() + " "
                + wordService.getVerb() + " "
                + wordService.getArticle() + " "
                + wordService.getAdjective() + " "
                + wordService.getNoun() + ".";
    }
}
