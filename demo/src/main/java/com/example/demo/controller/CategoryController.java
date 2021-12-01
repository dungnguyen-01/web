package com.example.demo.controller;


import com.example.demo.model.entities.Category;
import com.example.demo.repository.CategoryRepsitory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryRepsitory  categoryRepsitory;

    @RequestMapping("/admin/category")
    public String list(Model model)
    {
        List<Category> list = categoryRepsitory.findAll();
        model.addAttribute("items",list);
        return "/admin/category";
    }

    @PostMapping("/category/add")
    public String addCategory(Model model,Category category)
    {
        categoryRepsitory.save(category);
        return "redirect:/admin/category";
    }

    @RequestMapping ("/category/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer id)
    {
        categoryRepsitory.deleteById(id);
        return "redirect:/admin/category";
    }

    @RequestMapping("/category/edit/{id}")
    public String editCategory(Model model,@PathVariable("id") Integer id)
    {
        Category category = categoryRepsitory.getById(id);
        model.addAttribute("list" ,category);



        return "redirect:/admin/category";
    }

    @RequestMapping ("/category/update")
    public String updateCategory(Model model,Category category)
    {
        categoryRepsitory.save(category);
        return "redirect:/category/edit" +category.getId();
    }

//    @ResponseBody
//    @RequestMapping(value = "/category/delete", method = RequestMethod.GET)
//    public JSONObject deleteCategory(@RequestParam("id") Integer id) throws JSONException {
//        JSONObject js = new JSONObject();
//        try {
//            categoryRepsitory.deleteById(id);
//            js.put("code","00");
//            return js;
//        } catch (Exception e){
//            js.put("code","01");
//            return js;
//        }
//    }
//
//    @RequestMapping(value = "/category/edit", method = RequestMethod.POST)
//    public String editCategory(Model model,@RequestParam("id") Integer id)
//    {
//        Category category = categoryRepsitory.getById(id);
//
//        model.addAttribute("form" ,category);
//        categoryRepsitory.deleteById(id);
//        return "redirect:/admin/category";
//    }




}
