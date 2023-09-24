package com.example.product_aggregator_project.mockito;

import com.example.product_aggregator_project.model.*;
import com.example.product_aggregator_project.repository.*;
import com.example.product_aggregator_project.service.CategoryService;
import com.example.product_aggregator_project.service.ProductService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

import com.example.product_aggregator_project.service.impl.CategoryServiceImpl;
import com.example.product_aggregator_project.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ManufacturerRepository manufacturerRepository;

    @Mock
    private ProductCharacteristicRepository characteristicRepository;

    @Mock
    private CategoryServiceImpl categoryService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserFavouriteRepository userFavouriteRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private List<Product> products;

    private Category category;

    private Manufacturer manufacturer;

    private ProductCharacteristic characteristic;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        productService = spy(new ProductServiceImpl(
                productRepository,
                categoryRepository,
                manufacturerRepository,
                characteristicRepository,
                categoryService,
                userRepository,
                userFavouriteRepository));

        products = new ArrayList<>();
        category = new Category("TestCategory", null);
        category.setId(1);
        manufacturer = new Manufacturer("TestManufacturer", "TestCountry");
        manufacturer.setId(1);
        characteristic = new ProductCharacteristic("TestDesc");
        Product product1 = new Product("Product1", category, manufacturer, LocalDate.now(), characteristic);
        Product product2 = new Product("Product2", category, manufacturer, LocalDate.now(), characteristic);

        products.addAll(List.of(product1, product2));
    }

    @DisplayName("Test for listAllUnsorted method")
    @Test
    public void findAllProductsTest() {
        when(productRepository.findAll()).thenReturn(products);
        List<Product> productList = productService.listAllUnsorted();
        assertEquals(2, productList.size());
        verify(productRepository, times(1)).findAll();
    }

    @DisplayName("Test for findById method")
    @Test
    public void findProductById() {
        Product product1 = products.get(0);
        when(productRepository.findById(product1.getId())).thenReturn(Optional.of(product1));
        Product returnedProduct = productService.findById(product1.getId());
        assertEquals(product1.getId(), returnedProduct.getId());
        verify(productRepository).findById(product1.getId());
    }

    @DisplayName("Test for addProduct method")
    @Test
    public void addProductTest() {
        when(categoryRepository.findById(category.getId())).thenReturn(Optional.of(category));
        when(manufacturerRepository.findById(manufacturer.getId())).thenReturn(Optional.of(manufacturer));

        Product product = productService.addProduct("NewProduct", category.getId(), manufacturer.getId(), LocalDate.now(), characteristic.getCharacteristicDescription());

        verify(productService).addProduct("NewProduct", category.getId(), manufacturer.getId(), LocalDate.now(), characteristic.getCharacteristicDescription());
        verify(productRepository).save(product);
    }

    @DisplayName("Test for listProductsByNameAndCategoryAndManufacturer method")
    @Test
    public void FilterProductsTest() {
        when(categoryRepository.findById(1)).thenReturn(Optional.of(category));
        when(manufacturerRepository.findById(1)).thenReturn(Optional.of(manufacturer));
        when(productRepository.findAllByProductNameContainingIgnoreCaseAndCategoryEqualsAndManufacturerEquals(eq(""), eq(category), eq(manufacturer))).thenReturn(products);

        List<Product> filteredProducts = productService.listProductsByNameAndCategoryAndManufacturer(null, 1, 1);

        assertEquals(products.size(), filteredProducts.size());

        verify(categoryRepository, times(1)).findById(1);
        verify(manufacturerRepository, times(1)).findById(1);
        verify(productRepository, times(1)).findAllByProductNameContainingIgnoreCaseAndCategoryEqualsAndManufacturerEquals(eq(""), eq(category), eq(manufacturer));
    }
}
