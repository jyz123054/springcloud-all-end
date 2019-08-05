package org.zmodule.mapper;
import org.zmodule.vo.Product;
import java.util.List;

public interface ProductMapper {
    boolean create(Product product);
    public Product findById(Long id);
    public List<Product> findAll();
}