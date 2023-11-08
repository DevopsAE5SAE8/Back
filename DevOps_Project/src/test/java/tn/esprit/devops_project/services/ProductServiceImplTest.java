package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

/*
        @InjectMocks
        private ProductServiceImpl productService;

        @Mock
        private ProductRepository productRepository;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.initMocks(this);
        }
        Product product = new Product(1L,"qqq");
        List<Product> productList= new ArrayList<>(){
            {
                add(new Product(2L,"aaa"));
                add(new Product(3L, "bbb"));
            }
        };
        @Test
        void  testretrieveAllStock() {
            Mockito.when(productService.retreiveAllProduct()).thenReturn(productList);
            List<Product> list = productService.retreiveAllProduct();
            Assertions.assertNotNull(list);
        } */
}