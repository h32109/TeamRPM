package com.rpm.web.recommend;

import com.rpm.web.company.CompanyRepository;
import com.rpm.web.contents.Cars;
import com.rpm.web.contents.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/recommend")
@CrossOrigin(origins = "http://localhost:8081")
public class RecommendController {
    @Autowired
    CarsRepository carsRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    RecommendRepository recommendRepository;

    @GetMapping("/centerName/{region}")
    public List<String> centerRigion(@PathVariable String region){
        if(region.equals("경기")){
            region="경기/인천";
        }
        System.out.println(region);
        List<String> centerName =  companyRepository.findByCenterRegion(region);
        return centerName;

    }
    @GetMapping("/centerRigion")
    public List<String> centerName(){
        List<String> region =  companyRepository.findAllRigion();
        return region;

    }
    @PostMapping("/inputRecommend")
    public void inputRecommend(@RequestBody Recommend recommend){
        recommendRepository.save(recommend);
        Recommend recommendCenter =new Recommend();
        recommendCenter.setFuleTypedName(recommend.getFuleTypedName());
        recommendCenter.setMaxBeginYear(recommend.getMaxBeginYear());
        recommendCenter.setMinBeginYear(recommend.getMinBeginYear());
        recommendCenter.setMaxMilage(recommend.getMaxMilage());
        recommendCenter.setMinMilage(recommend.getMinMilage());
        recommendCenter.setMaxPrice(recommend.getMaxPrice());
        recommendCenter.setMinPrice(recommend.getMinPrice());
        recommendCenter.setModelGrpNm(recommend.getModelGrpNm());
        recommendCenter.setModelNm(recommend.getModelNm());
        recommendCenter.setMakeNm(recommend.getMakeNm());
        recommendCenter.setTransmissioncdName(recommend.getTransmissioncdName());
        recommendCenter.setUserId(companyRepository.findByCenterName(recommend.getCenterName()));
        recommendRepository.save(recommendCenter);

    }
}