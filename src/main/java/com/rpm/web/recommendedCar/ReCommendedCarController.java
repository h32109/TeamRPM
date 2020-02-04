package com.rpm.web.recommendedCar;

import com.rpm.web.contents.Cars;
import com.rpm.web.contents.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/recommendedCar")
@CrossOrigin(origins = "http://localhost:8081")
public class ReCommendedCarController {
    @Autowired RecommendedCarRepository recommendedCarRepository;
    @Autowired CarsRepository carsRepository;
    @PostMapping("/recommendedCar")
    public void recommendedCar(@RequestBody Map<String,Object> send){
        List<String> list=(List<String>) send.get("carcodeList");
        list.forEach(el->{
            RecommendedCar recommendedCar= new RecommendedCar();
            recommendedCar.setCars(carsRepository.findByCarcd(el));
            recommendedCar.setUserid(String.valueOf(send.get("userid")));
            recommendedCar.setCenterCode(String.valueOf(send.get("centercode")));
            System.out.println(recommendedCar.toString());
            recommendedCarRepository.save(recommendedCar);
        });



    }
    @GetMapping("/getRecommendedCar/{userid}")
    public List<RecommendedCar> getRecommendedCar(@PathVariable String userid){
        List<RecommendedCar> list =recommendedCarRepository.findByUserid(userid);
        list.sort((a,b) -> b.getRecoCarSeq().compareTo(a.getRecoCarSeq()));
        return list;
    }
}
