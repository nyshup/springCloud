package com.nyshup.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nyshup.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private AdjectiveService adjectiveService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private NounService nounService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private VerbService verbService;

    @Override
    @HystrixCommand(fallbackMethod = "getDefaultAdjective")
    public String getAdjective() {
        return adjectiveService.getWord();
    }

    private String getDefaultAdjective() {
        return "";
    }

    @Override
    public String getArticle() {
        return articleService.getWord();
    }

    @Override
    public String getNoun() {
        return nounService.getWord();
    }

    @Override
    public String getSubject() {
        return subjectService.getWord();
    }

    @Override
    public String getVerb() {
        return verbService.getWord();
    }

}
