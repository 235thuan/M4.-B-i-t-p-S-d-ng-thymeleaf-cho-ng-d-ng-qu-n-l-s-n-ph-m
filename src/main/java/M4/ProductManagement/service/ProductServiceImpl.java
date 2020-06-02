package M4.ProductManagement.service;

import M4.ProductManagement.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements IProductService {
     private static Map<Integer, Product> products;
     
         static {
             products = new HashMap<>();
             products.put(1, new Product(1, "Bphone8", "Bphone", 99999));
             products.put(2, new Product(2, "SamSung Galaxy 8", "SamSung", 100000));
             products.put(3, new Product(3, "SamSung Note 9", "SamSung", 200000));
             products.put(4, new Product(4, "Iphone X", "Apple", 500000));
             products.put(5, new Product(5, "Iphone XS", "Apple", 600000));
             products.put(6, new Product(6, "XiaoMi Note", "XiaoMi", 400000));
         }
    
    @Override
        public List<Product> findAll() {
            return new ArrayList<>(products.values());
        }
    
        @Override
        public void save(Product product) {
    
            products.put(product.getId(), product);
        }
    
        @Override
        public Product findById(int id) {
            return products.get(id);
        }
    
        @Override
        public void update(int id, Product product) {
            products.put(id, product);
    
        }
    
        @Override
        public void delete(int id) {
            products.remove(id);
        }
}
