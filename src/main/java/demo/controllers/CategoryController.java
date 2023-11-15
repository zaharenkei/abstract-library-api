package demo.controllers;

import demo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/root")
    public List<Category> getTopLevelCategories() {
        return mongoTemplate.find(Query.query(Criteria.where("parentId").is(null)), Category.class);
    }

    @GetMapping("/{parentId}/children")
    public List<Category> getSubcategoriesByParentId(@PathVariable("parentId") int parentId) {
        return mongoTemplate.find(Query.query(Criteria.where("parentId").is(parentId)), Category.class);
    }
}
