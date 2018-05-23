package com.example.spring.data.jpa.dao;

import java.util.Collection;

public interface ProductDao2 {
    Collection loadProductsByCategory(String category);
}
