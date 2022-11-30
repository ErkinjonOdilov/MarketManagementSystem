package uz.market.market.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.market.market.domain.Product;
import uz.market.market.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save (Product product){
        return productRepository.save(product);
    }

    public Product findOne(Long id){
        Optional<Product> optional = productRepository.findById(id);
        if(optional.isPresent()){
            Product product=optional.get();
            return product;
        }
        return null;
    }

    @Transactional(readOnly = true)
    public Page<Product> findAll(Pageable pageable){
        Page<Product> page=productRepository.findAll(pageable);
        return page;
    }

    @Transactional(readOnly = true)
    public Product findByCode(String code){
       return productRepository.findByCode(code);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
