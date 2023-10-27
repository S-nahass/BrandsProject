import java.util.ArrayList;
import java.util.List;

public class BrandDatabase {
    private static List<Brand> brands;
    private static List<PerformanceData> performanceDataList;

    public BrandDatabase() {
        brands = new ArrayList<>();
        performanceDataList = new ArrayList<>();
        initializeTestData();
        initializeBrandPerformanceTestData();

    }

    public static List<PerformanceData> getPerformanceDataList() {
        return performanceDataList;
    }

    private void initializeTestData() {
        // Brand 1: Nike
        Brand brand1 = new Brand("Nike", "Sportswear", 1964, "United States", "Nike, Inc. is an American multinational corporation known for its innovative athletic footwear and apparel.");
        Product product1 = new Product("Air Max Running Shoes", 129.99, "Premium running shoes with air cushioning.", 100);
        Product product2 = new Product("Dri-FIT Sports T-Shirt", 34.99, "Moisture-wicking sports t-shirt for performance.", 100);
        brand1.addProduct(product1);
        brand1.addProduct(product2);
        brands.add(brand1);

        // Brand 2: Adidas
        Brand brand2 = new Brand("Adidas", "Sportswear", 1949, "Germany", "Adidas AG is a German multinational corporation, founded by Adolf Dassler, that designs and manufactures athletic and casual footwear, apparel, and accessories.");
        Product product3 = new Product("Ultraboost Running Shoes", 159.99, "High-performance running shoes with Boost technology.", 100);
        Product product4 = new Product("Essentials Hoodie", 49.99, "Comfortable hoodie for casual wear.", 100);
        brand2.addProduct(product3);
        brand2.addProduct(product4);
        brands.add(brand2);

        // Brand 3: Gucci
        Brand brand3 = new Brand("Gucci", "Luxury", 1921, "Italy", "Gucci is an Italian luxury brand known for its high-end fashion and leather goods.");
        Product product5 = new Product("Luxury Leather Bag", 899.99, "Elegant leather bag for the fashion-conscious.", 100);
        Product product6 = new Product("Designer Sunglasses", 249.99, "Luxury sunglasses with UV protection.", 100);
        brand3.addProduct(product5);
        brand3.addProduct(product6);
        brands.add(brand3);

        // Brand 4: Puma
        Brand brand4 = new Brand("Puma", "Sportswear", 1948, "Germany", "Puma is a German multinational corporation that designs and manufactures athletic and casual footwear, apparel, and accessories.");
        Product product7 = new Product("Running Sneakers", 89.99, "Comfortable running sneakers with excellent traction.", 100);
        Product product8 = new Product("Essential Training Shorts", 29.99, "Training shorts for active lifestyles.", 100);
        brand4.addProduct(product7);
        brand4.addProduct(product8);
        brands.add(brand4);

// Brand 5: H&M
        Brand brand5 = new Brand("H&M", "Fashion", 1947, "Sweden", "H&M is a Swedish multinational clothing-retail company known for its affordable and trendy fashion.");
        Product product9 = new Product("Casual Dress", 39.99, "Stylish and affordable casual dress.", 100);
        Product product10 = new Product("Slim-Fit Jeans", 29.99, "Slim-fit jeans for a modern look.", 100);
        brand5.addProduct(product9);
        brand5.addProduct(product10);
        brands.add(brand5);

// Brand 6: Zara
        Brand brand6 = new Brand("Zara", "Fashion", 1974, "Spain", "Zara is a Spanish clothing and accessories retailer known for its fast-fashion and stylish designs.");
        Product product11 = new Product("Stylish Jacket", 79.99, "Trendy jacket for all occasions.", 100);
        Product product12 = new Product("Denim Jeans", 39.99, "Classic denim jeans for everyday wear.", 100);
        brand6.addProduct(product11);
        brand6.addProduct(product12);
        brands.add(brand6);

// Brand 7: Levi's
        Brand brand7 = new Brand("Levi's", "Denim", 1853, "United States", "Levi's is an American company known for its denim jeans and casual clothing.");
        Product product13 = new Product("Classic 501 Jeans", 59.99, "Iconic 501 jeans for timeless style.", 100);
        Product product14 = new Product("Trucker Jacket", 69.99, "Classic denim jacket for a rugged look.", 100);
        brand7.addProduct(product13);
        brand7.addProduct(product14);
        brands.add(brand7);

// Brand 8: Tommy Hilfiger
        Brand brand8 = new Brand("Tommy Hilfiger", "Fashion", 1985, "United States", "Tommy Hilfiger is an American fashion brand known for its preppy and classic styles.");
        Product product15 = new Product("Polo Shirt", 49.99, "Preppy polo shirt with the Tommy logo.", 100);
        Product product16 = new Product("Chino Pants", 59.99, "Stylish chino pants for a classic look.", 100);
        brand8.addProduct(product15);
        brand8.addProduct(product16);
        brands.add(brand8);

// Brand 9: Calvin Klein
        Brand brand9 = new Brand("Calvin Klein", "Fashion", 1968, "United States", "Calvin Klein is an American fashion brand known for its minimalist and modern designs.");
        Product product17 = new Product("Modern Fit Suit", 199.99, "Sleek and modern fit suit for special occasions.", 100);
        Product product18 = new Product("Crew Neck T-Shirt", 24.99, "Essential crew neck t-shirt for everyday wear.", 100);
        brand9.addProduct(product17);
        brand9.addProduct(product18);
        brands.add(brand9);

        // Brand 10: Ralph Lauren
        Brand brand10 = new Brand("Ralph Lauren", "Fashion", 1967, "United States", "Ralph Lauren is an American fashion brand known for its upscale and classic clothing.");
        Product product19 = new Product("Classic Polo Shirt", 69.99, "Iconic polo shirt with the Ralph Lauren pony logo.", 100);
        Product product20 = new Product("Cable Knit Sweater", 79.99, "Timeless cable knit sweater for a sophisticated look.", 100);
        brand10.addProduct(product19);
        brand10.addProduct(product20);
        brands.add(brand10);

// Brand 11: Versace
        Brand brand11 = new Brand("Versace", "Luxury", 1978, "Italy", "Versace is an Italian luxury brand known for its bold and extravagant designs.");
        Product product21 = new Product("Medusa Logo Shirt", 129.99, "Elegant shirt with the Versace Medusa logo.", 100);
        Product product22 = new Product("Baroque Print Dress", 249.99, "Extravagant dress with Versace's iconic baroque print.", 100);
        brand11.addProduct(product21);
        brand11.addProduct(product22);
        brands.add(brand11);

// Brand 12: Armani
        Brand brand12 = new Brand("Armani", "Luxury", 1975, "Italy", "Armani is an Italian luxury brand known for its clean and sophisticated fashion.");
        Product product23 = new Product("Italian Wool Suit", 299.99, "High-quality wool suit for a timeless look.", 100);
        Product product24 = new Product("Silk Necktie", 59.99, "Elegant silk necktie to complete your outfit.", 100);
        brand12.addProduct(product23);
        brand12.addProduct(product24);
        brands.add(brand12);

// Brand 13: Prada
        Brand brand13 = new Brand("Prada", "Luxury", 1913, "Italy", "Prada is an Italian luxury brand known for its high-quality fashion and accessories.");
        Product product25 = new Product("Saffiano Leather Bag", 399.99, "Luxurious Saffiano leather bag with Prada logo.", 100);
        Product product26 = new Product("Cat-Eye Sunglasses", 179.99, "Stylish cat-eye sunglasses for a fashionable look.", 100);
        brand13.addProduct(product25);
        brand13.addProduct(product26);
        brands.add(brand13);

// Brand 14: Chanel
        Brand brand14 = new Brand("Chanel", "Fashion", 1909, "France", "Chanel is a French fashion brand known for its elegant and timeless designs.");
        Product product27 = new Product("Classic Flap Bag", 349.99, "Iconic Chanel flap bag for a sophisticated touch.", 100);
        Product product28 = new Product("Chanel No. 5 Perfume", 79.99, "Timeless Chanel No. 5 perfume for a classic fragrance.", 100);
        brand14.addProduct(product27);
        brand14.addProduct(product28);
        brands.add(brand14);

// Brand 15: Burberry
        Brand brand15 = new Brand("Burberry", "Fashion", 1856, "United Kingdom", "Burberry is a British fashion brand known for its iconic check patterns and trench coats.");
        Product product29 = new Product("Burberry Check Scarf", 149.99, "Iconic Burberry check scarf for a stylish accessory.", 100);
        Product product30 = new Product("Trench Coat", 299.99, "Timeless Burberry trench coat for all seasons.", 100);
        brand15.addProduct(product29);
        brand15.addProduct(product30);
        brands.add(brand15);

        // Brand 16: Louis Vuitton
        Brand brand16 = new Brand("Louis Vuitton", "Luxury", 1854, "France", "Louis Vuitton is a French luxury brand known for its high-end luggage and accessories.");
        Product product31 = new Product("Monogram Canvas Tote", 399.99, "Iconic Louis Vuitton monogram canvas tote.", 100);
        Product product32 = new Product("LV Leather Belt", 159.99, "Luxurious Louis Vuitton leather belt with LV logo.", 100);
        brand16.addProduct(product31);
        brand16.addProduct(product32);
        brands.add(brand16);

// Brand 17: Dior
        Brand brand17 = new Brand("Dior", "Luxury", 1946, "France", "Dior is a French luxury brand known for its haute couture and perfumes.");
        Product product33 = new Product("Lady Dior Handbag", 599.99, "Elegant Lady Dior handbag with signature quilted pattern.", 100);
        Product product34 = new Product("Sauvage Cologne", 89.99, "Signature Dior Sauvage cologne for men.", 100);
        brand17.addProduct(product33);
        brand17.addProduct(product34);
        brands.add(brand17);

// Brand 18: Balenciaga
        Brand brand18 = new Brand("Balenciaga", "Fashion", 1919, "Spain", "Balenciaga is a Spanish fashion brand known for its avant-garde and streetwear-inspired designs.");
        Product product35 = new Product("Speed Trainer Sneakers", 299.99, "Iconic Balenciaga Speed Trainer sneakers.", 100);
        Product product36 = new Product("Oversized Logo T-Shirt", 129.99, "Oversized logo t-shirt for a bold look.", 100);
        brand18.addProduct(product35);
        brand18.addProduct(product36);
        brands.add(brand18);

// Brand 19: Alexander McQueen
        Brand brand19 = new Brand("Alexander McQueen", "Fashion", 1992, "United Kingdom", "Alexander McQueen is a British fashion brand known for its dramatic and innovative fashion.");
        Product product37 = new Product("Skull Print Scarf", 149.99, "Signature Alexander McQueen skull print scarf.", 100);
        Product product38 = new Product("Chunky Sneakers", 249.99, "Chunky sneakers for a unique and edgy style.", 100);
        brand19.addProduct(product37);
        brand19.addProduct(product38);
        brands.add(brand19);

// Brand 20: Fendi
        Brand brand20 = new Brand("Fendi", "Luxury", 1925, "Italy", "Fendi is an Italian luxury brand known for its fur and leather goods.");
        Product product39 = new Product("Fur Shoulder Bag", 499.99, "Elegant fur shoulder bag with Fendi logo.", 100);
        Product product40 = new Product("FF Logo Belt", 199.99, "Stylish FF logo belt for a fashionable touch.", 100);
        brand20.addProduct(product39);
        brand20.addProduct(product39);
        brand20.addProduct(product40);
        brands.add(brand20);

    }


    public static List<Brand> getBrands() {
        return brands;
    }

    private void initializeBrandPerformanceTestData() {

        for (Brand brand : brands) {
            PerformanceData brandPerformance = new PerformanceData(brand.getName());

            // Generate random sales records for the brand
            for (int year = 2020; year <= 2022; year++) {
                int quantitySold = (int) (Math.random() * 1000) + 100;
                double totalRevenue = Math.random() * 50000 + 1000;
                brandPerformance.addSalesRecord(new SalesRecord(year, quantitySold, totalRevenue));
            }

            // Generate random product popularity data for the brand's products
            for (Product product : brand.getProducts()) {
                ProductPopularity popularity = new ProductPopularity(product.getName(), (int) (Math.random() * 100));
                brandPerformance.addProductPopularity(popularity);
            }

            // Add the brand's performance data to the performanceDataList
            performanceDataList.add(brandPerformance);
        }

    }
}