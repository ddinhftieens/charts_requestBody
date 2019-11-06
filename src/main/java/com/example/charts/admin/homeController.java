package com.example.charts.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/home")
public class homeController {
    @GetMapping("/admin")
    public String home(){
        System.out.println("OK");
        return "home";
    }

    @GetMapping(value = "/admin/statistic",consumes = "application/json",produces = "application/json")
    @ResponseBody
    public String getStatistic(@RequestParam("id") String id){
        System.out.println("OKKK");
        System.out.println(id);
        Map<String, List<Integer>> mapData = new HashMap<>();
        for(int i=0;i<20;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<4;j++){

                list.add((j+8+i)%6);
            }
//            System.out.println(list);
//            System.out.println(i+1);
            mapData.put("K"+i,list);
        }
        String a = null;
        try {
            a = new ObjectMapper().writeValueAsString(mapData);
            System.out.println(a);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return a;
    }
}
