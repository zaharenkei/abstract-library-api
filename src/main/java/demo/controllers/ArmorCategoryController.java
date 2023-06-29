package demo.controllers;

import demo.exeptions.ResourceNotFoundException;
import demo.model.armorCategory.ArmorCategory;
import demo.model.armorCategory.ArmorCategoryData;
import demo.service.ArmorCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("armor/categories")
public class ArmorCategoryController {

    @Autowired
    private ArmorCategoryService armorCategoryService;

    @GetMapping("/{id}")
    public ResponseEntity<ArmorCategory> read(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        return armorCategoryService.read(id);
    }

    @GetMapping("/")
    public List<ArmorCategory> readAll() {
        return armorCategoryService.read();
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Integer> create(@RequestBody ArmorCategoryData armorCategoryData) {
        return armorCategoryService.save(armorCategoryData);
    }

    @PutMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Boolean> update(@RequestBody ArmorCategory armorCategory) throws ResourceNotFoundException {
        return armorCategoryService.update(armorCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        return armorCategoryService.delete(id);
    }
}