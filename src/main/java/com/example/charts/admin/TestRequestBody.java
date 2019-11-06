package com.example.charts.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/requestBody")
public class TestRequestBody {
    @GetMapping("/home")
    private String getRequestBody(){
        return "requestBody";
    }
    @PostMapping(value = "/home", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String post(@RequestBody User user){
        System.out.println("OK");
        System.out.println(user);
        String a="";
        try {
            a = new ObjectMapper().writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return a;
    }

    @GetMapping(value = "/home/get",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String get(@RequestParam("value") String value){
        List<String> list = new ArrayList<>();
        for(int i=0;i<Integer.parseInt(value);i++){
            list.add("K"+i+1);
        }
        String a="";
        try {
            a = new ObjectMapper().writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(a);
        return a;
    }
    @GetMapping("/image")
    public void getImg(@RequestParam("ID") String id, HttpServletResponse httpServletResponse){
        final String UploadFile = "D:\\LTWeb\\product";
        File file = new File(UploadFile+File.separator+id+".jpg");
        if(file.exists()){
            try {
                Files.copy(file.toPath(),httpServletResponse.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @GetMapping(value = "/change/image",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String changeImg(@RequestParam("ID") String id){
        System.out.println(id);
        String a = null;
        try {
            a = new ObjectMapper().writeValueAsString("1569657392104");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(a);
        return a;
    }
}
