package com.example.spring.data.jpa.dao;

import java.util.Collection;

public interface ProductDao {
    Collection loadProductsByCategory(String category);
}
