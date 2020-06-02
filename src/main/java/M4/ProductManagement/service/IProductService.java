package M4.ProductManagement.service;

import M4.ProductManagement.model.Product;

import java.util.List;

public interface IProductService {
List<Product>findAll();
void save(Product product);
void update(int id, Product product);
void delete(int id);
Product findById(int id);
}

