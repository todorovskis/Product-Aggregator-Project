package com.example.product_aggregator_project.mockito;

import com.example.product_aggregator_project.model.Product;
import com.example.product_aggregator_project.model.User;
import com.example.product_aggregator_project.model.UserFavourite;
import com.example.product_aggregator_project.repository.ProductRepository;
import com.example.product_aggregator_project.repository.UserFavouriteRepository;
import com.example.product_aggregator_project.repository.UserRepository;
import com.example.product_aggregator_project.service.impl.UserFavouriteServiceImpl;
import com.example.product_aggregator_project.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserFavouriteServiceTest {

    @Mock
    private UserFavouriteRepository userFavouriteRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private UserFavouriteServiceImpl userFavouriteService;

    private User user;

    private Product product;

    private UserFavourite userFavourite;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        product = new Product();
        userFavourite = new UserFavourite(user, product);
        userFavouriteService = spy(new UserFavouriteServiceImpl(userFavouriteRepository, userRepository, productRepository));
    }

    @DisplayName("Test for addProductToUserFavourites method")
    @Test
    public void addProductToUserFavouritesTest() {
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        UserFavourite newUserFavourite = userFavouriteService.addProductToUserFavourites(user.getId(), product.getId());
        verify(userFavouriteService).addProductToUserFavourites(userFavourite.getId(), userFavourite.getId());
    }
}
