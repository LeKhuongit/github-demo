package com.ps21510.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps21510.entity.Category;



public interface CategoryDAO extends JpaRepository<Category, String>{
}
