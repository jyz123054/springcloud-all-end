package org.zmodule.service;
import org.zmodule.vo.Product;
import java.util.List;

public interface IProductService {
    Product get(long id);
    boolean add(Product product);
    List<Product> list();
}