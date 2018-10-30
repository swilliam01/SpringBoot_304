package com.example.demo;


import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    CarModelRepository carModelRepository;

    @GetMapping("/")
    public String listForm(Model model){
        model.addAttribute("cars", carModelRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String carForm(Model model){
        model.addAttribute("car", new CarModel());
        return "carform";
    }

    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute("car") CarModel car, BindingResult result){
        if (result.hasErrors()){
            return "/carform";
        }
        carModelRepository.save(car);
        return "redirect:/";
    }
    @RequestMapping("/detail/{id}")
    public String showCars (@PathVariable ("id") long id, Model model){
        model.addAttribute("car", carModelRepository.findById(id).get());
        return "show";
    }
    @RequestMapping("/update/{id}")
    public String updateCars (@PathVariable ("id") long id, Model model){
        model.addAttribute("car", carModelRepository.findById(id).get());
        return "carform";
    }
    @RequestMapping("/delete/{id}")
    public String delCars (@PathVariable ("id") long id, Model model){
        carModelRepository.deleteById(id);
        return "redirect:/";
    }



}
