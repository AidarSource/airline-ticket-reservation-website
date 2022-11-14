package org.example.airline;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="", required = false, defaultValue = "world") String name, Map<String, Object> model
    ) {
        model.put( "name", name );
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("something", "Welcome to the Flight booking website!");
        return "main";
    }
}
