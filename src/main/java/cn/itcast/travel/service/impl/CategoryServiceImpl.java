package cn.itcast.travel.service.impl;

import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> findAll() {
        CategoryService categoryService = new CategoryServiceImpl();
        return categoryService.findAll();
    }
}
