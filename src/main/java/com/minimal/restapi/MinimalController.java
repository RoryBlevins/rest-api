package com.minimal.restapi;

import com.minimal.restapi.model.Film;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class MinimalController {

    @RequestMapping(value= "/status", method = GET)
    public String minimalGetEndpoint(){
        return "up";
    }


    @RequestMapping(value = "/hello", method = POST)
    public String minimalPostEndpoint(@RequestBody String name  ){
        return "Hello "+ name;
    }

    @RequestMapping(value = "/films", method = POST)
    @ResponseBody
    public Film minimalPostEndpoint(@RequestBody Film input  ){
        return input;
    }
}
