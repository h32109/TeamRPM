package com.rpm.web.magazine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rpm.web.contents.Cars;
import com.rpm.web.util.MakeCarDummyList;
import org.snu.ids.kkma.index.Keyword;
import org.snu.ids.kkma.index.KeywordExtractor;
import org.snu.ids.kkma.index.KeywordList;
import org.snu.ids.kkma.ma.MorphemeAnalyzer;
import org.snu.ids.kkma.ma.Sentence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MagazineInit implements ApplicationRunner {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ExtractedWordRepository extractedWordRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

       MakeCarDummyList http = new MakeCarDummyList();
        Map<String, Map<String, Object>> map = new HashMap<>();
        ArticleCrawler crawler = new ArticleCrawler( articleRepository , extractedWordRepository );
        if (articleRepository.count() == 0 ) crawler.motorgraphComtroller();
        if (extractedWordRepository.count() == 0 ) crawler.extractor();
        //morphemeAnalyzer();
    }


}