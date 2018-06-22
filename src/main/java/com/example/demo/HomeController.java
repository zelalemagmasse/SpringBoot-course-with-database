package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HomeController {

    // @Autowired
    //CourseRepository courseRepository
    ArrayList<Course> courses = new ArrayList<>();


    @RequestMapping("/")
    public String listJobs(Model model){
        model.addAttribute("course", courses);
        return "list";
    }

    @GetMapping("/add")
    public String jobForm(Model model){
        model.addAttribute("course", new Course());
        return "courseform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Course course, ArrayList<Course> courses){
        courses.add(course);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showJob(@PathVariable("id") int id, Model model){
        model.addAttribute("course", courses.get(id));
        return "show";
    }

    @RequestMapping("/delete/{id}")
    public String delJob(@PathVariable("id") int id){
        courses.remove(id);
        return "redirect:/";
    }
}
