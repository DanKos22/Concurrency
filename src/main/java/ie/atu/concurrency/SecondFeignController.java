package ie.atu.concurrency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SecondFeignController {

    @Autowired
    private final FeignService feignService;

    public SecondFeignController(FeignService feignService){
        this.feignService = feignService;
    }

    @GetMapping("/feign")
    public TodoResponse getTodosData() {


        for(int i = 0; i < 200; i++){
            // Get a list of todos
            feignService.fetchData();
        }
        return feignService.fetchData();
    }
}
