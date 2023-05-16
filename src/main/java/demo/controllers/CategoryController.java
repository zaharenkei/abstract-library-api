package demo.controllers;

import demo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/categories")
    public List<Category> getCategories(@RequestParam(name = "parentId", required = false) Integer parentId) {
        List<Category> categories;
        
        if (parentId == null) {
            categories = mongoTemplate.find(Query.query(Criteria.where("parentId").is(null)), Category.class);
        } else {
            categories = mongoTemplate.find(Query.query(Criteria.where("parentId").is(parentId)), Category.class);
        }
        return categories;
    }
}
