package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("animals") // lecture method routes to localhost:8080/animals
public class AnimalsController {

    private final Map<String, String> roster = new HashMap<>();

    @GetMapping
    public String index() {
        return "animals/index"; // points to /templates/animals/index.html
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<String> animals = new ArrayList<>();
        animals.add("Banana Cat");
        animals.add("Apple Dog");
        animals.add("Mango Zebra");
        model.addAttribute("animallist", animals);
        List<String> caretakers = new ArrayList<>();
        caretakers.add("Gerard");
        caretakers.add("Arielle");
        caretakers.add("Theo");
//        Map<String, String> roster = new HashMap<>();
        roster.put("Banana Cat", "Gerard");
        roster.put("Apple Dog", "Arielle");
        roster.put("Mango Zebra", "Theo");
        model.addAttribute("roster", roster);
        return "animals/list";
    }

    @GetMapping("/add")
    public String add() {
        return "animals/add";
    }

    @PostMapping("/add")
    public String processAddForm(@RequestParam String animal, String caretaker) {
        roster.put(animal, caretaker);
        return "redirect:/animals/list";
    }

}
