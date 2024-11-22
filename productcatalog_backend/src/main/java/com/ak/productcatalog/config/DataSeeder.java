package com.ak.productcatalog.config;

import com.ak.productcatalog.model.Category;
import com.ak.productcatalog.model.Product;
import com.ak.productcatalog.repository.CategoryRepository;
import com.ak.productcatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // clear all existing data,
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        //create Category data,
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("HOME and Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics,clothing,home));

        //create Product data,
        Product apple = new Product();
        apple.setName("Apple iPhone 15 Pro Max");
        apple.setDescription("6.7 display, 48MP(2160p), 8GB RAM, 4441mAh Battery, Released 2023");
        apple.setImageUrl("https://placehold.co/600x400");
        apple.setPrice( 544900.00);
        apple.setCategory(electronics);

        Product sam = new Product();
        sam.setName("Samsung Galaxy S20 Ultra 5G");
        sam.setDescription("6.9 display, 108MP(4320p), 16GB RAM, 5000mAh Battery, Released 2020");
        sam.setImageUrl("https://placehold.co/600x400");
        sam.setPrice( 255900.00);
        sam.setCategory(electronics);

        Product lap = new Product();
        lap.setName("HUAWEI MateBook D 15 2021");
        lap.setDescription("HUAWEI MateBook D 15 with slim and weight of just 1.56 kg, Smooth-to-the-touch");
        lap.setImageUrl("https://placehold.co/600x400");
        lap.setPrice( 150999.00);
        lap.setCategory(electronics);

        Product vivo = new Product();
        vivo.setName("Vivo X100 Ultra");
        vivo.setDescription("6.78 display, 50MP + 50MP + 200MP Triple Primary Cameras & 50 MP Front Camera, 12GB RAM, 5500mAh Battery, Released 2024");
        vivo.setImageUrl("https://placehold.co/600x400");
        vivo.setPrice( 255900.00);
        vivo.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Winter Jacket");
        jacket.setDescription("Men's Casual Waterproof Jacket Windbreaker Men Outerwear");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice( 3500.00);
        jacket.setCategory(clothing);

        Product frock = new Product();
        frock.setName("Double Sleeve Frock");
        frock.setDescription("Double Sleeve Front Button Women Plain Frock");
        frock.setImageUrl("https://placehold.co/600x400");
        frock.setPrice( 2000.00);
        frock.setCategory(clothing);

        Product sofa = new Product();
        sofa.setName("Sofa Set");
        sofa.setDescription("3,2,1 Sofa Set With Coffee Table, Perfect your living room");
        sofa.setImageUrl("https://placehold.co/600x400");
        sofa.setPrice( 89900.00);
        sofa.setCategory(home);

        Product chair = new Product();
        chair.setName("Plastic chair 6 pieces");
        chair.setDescription("Piyestra Plastic chair, Set of 6, Kingstar brand, Comfortable seating");
        chair.setImageUrl("https://placehold.co/600x400");
        chair.setPrice( 10900.00);
        chair.setCategory(home);

        productRepository.saveAll(Arrays.asList(apple, sam, vivo, lap, jacket, frock, sofa, chair));
    }
}
