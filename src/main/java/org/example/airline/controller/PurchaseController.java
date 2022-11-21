package org.example.airline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class PurchaseController {
    @GetMapping("/purchase")
    public String purchase( @RequestParam(name = "id", required = false, defaultValue = "1234") String id, Map<String, Object> model ) {

        model.put("id", id);

        return "purchase";
    }
}
