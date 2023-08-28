package xyz.lechi.onlineshop.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import xyz.lechi.onlineshop.domain.Product;
import xyz.lechi.onlineshop.domain.ProductCategory;
import xyz.lechi.onlineshop.domain.Supplier;
import xyz.lechi.onlineshop.repository.ProductCategoryRepository;
import xyz.lechi.onlineshop.repository.ProductRepository;
import xyz.lechi.onlineshop.repository.SupplierRepository;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final SupplierRepository supplierRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductRepository productRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeData() {
        var supplier1 = supplierRepository.save(
            Supplier.builder()
                .name("Josh's Electronics")
                .build()
        );

        var supplier2 = supplierRepository.save(
            Supplier.builder()
                .name("Tim's Computers")
                .build()
        );

        var laptopsProductCategory = productCategoryRepository.save(
            ProductCategory.builder()
                .name("Laptops")
                .description("Laptops and portable computers.")
                .build()
        );

        productRepository.saveAll(List.of(
            Product.builder()
                .name("Silver Laptop")
                .description("Silver laptop.")
                .price(new BigDecimal(1200))
                .weight(2.0)
                .category(laptopsProductCategory)
                .supplier(supplier1)
                .imageUrl("https://www.jaxtr.com/wp-content/uploads/2019/10/lenovo.jpg")
                .build(),
            Product.builder()
                .name("Gaming Laptop")
                .description("Gaming laptop with configurable RGB lights.")
                .price(new BigDecimal(1500))
                .weight(2.2)
                .category(laptopsProductCategory)
                .supplier(supplier1)
                .imageUrl("https://www.kindpng.com/picc/m/419-4190040_asus-aura-rgb-laptop-hd-png-download.png")
                .build()
        ));

        var keyboardsProductCategory = productCategoryRepository.save(
            ProductCategory.builder()
                .name("Keyboards")
                .description("Keyboards and keyboard accessories.")
                .build()
        );

        productRepository.saveAll(List.of(
            Product.builder()
                .name("RGB Keyboard")
                .description("Configurable RGB keyboard.")
                .price(new BigDecimal(200))
                .weight(0.2)
                .category(keyboardsProductCategory)
                .supplier(supplier1)
                .imageUrl("https://www.techspot.com/articles-info/1069/images/Tt_eSPORTS_Poseidon_Z_10.jpg")
                .build(),
            Product.builder()
                .name("Office Keyboard")
                .description("Comfortable office keyboard.")
                .price(new BigDecimal(150))
                .weight(0.2)
                .category(keyboardsProductCategory)
                .supplier(supplier1)
                .imageUrl("https://image.made-in-china.com/2f0j00lnSEdTQMnYby/Computer-Keyboard-Hot-Sale-Model.jpg")
                .build(),
            Product.builder()
                .name("Gaming Keyboard")
                .description("Mechanical gaming keyboard.")
                .price(new BigDecimal(300))
                .weight(0.3)
                .category(keyboardsProductCategory)
                .supplier(supplier1)
                .imageUrl("https://secure.logitech.com/assets/47978/5/g19s-gaming-keyboard.jpg")
                .build()
        ));

        var monitorsProductCategory = productCategoryRepository.save(
            ProductCategory.builder()
                .name("Monitors")
                .description("Monitors and monitor stands.")
                .build()
        );

        productRepository.saveAll(List.of(
            Product.builder()
                .name("Wide Monitor")
                .description("Wide curved monitor.")
                .price(new BigDecimal(1000))
                .weight(0.5)
                .category(monitorsProductCategory)
                .supplier(supplier2)
                .imageUrl("https://www.bhphotovideo.com/images/images2500x2500/hp_j9g67aa_aba_pavilion_27c_27_1920x1080_curved_1124310.jpg")
                .build(),
            Product.builder()
                .name("Computer Monitor")
                .description("Configurable computer monitor.")
                .price(new BigDecimal(500))
                .weight(0.4)
                .category(monitorsProductCategory)
                .supplier(supplier2)
                .imageUrl("https://www.serversplus.com/productImages/1600/MOPHI-221B7QPJKE.jpg")
                .build()
        ));
    }
}
