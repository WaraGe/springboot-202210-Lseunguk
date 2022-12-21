package com.study.springboot202210Lseunguk.web.controller;

import com.study.springboot202210Lseunguk.service.OptionService;
import com.study.springboot202210Lseunguk.web.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/option")
public class OptionController {

    @Autowired
    private OptionService optionService;

    @PostMapping("/category")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto categoryDto) {
//        int categoryId = optionService.addCategory(categoryDto);
//        System.out.println(categoryDto);
        return ResponseEntity
                .created(URI.create("/api/option/category/" + optionService.addCategory(categoryDto)))
                .body(categoryDto);
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getCategory() {

        return ResponseEntity.ok(optionService.getCategories()); //ok(optionService.getCategories()) 자체가 리스트
    }

    @PutMapping("/category/{categoryId}")
    public ResponseEntity<?> modifyCategory(@PathVariable int categoryId, @RequestBody CategoryDto categoryDto) {
        optionService.modifyCategory(categoryId, categoryDto);
        return ResponseEntity.ok(true);
    }
}
