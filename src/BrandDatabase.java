import java.util.ArrayList;
import java.util.List;

public class BrandDatabase {
    private List<Brand> brands;

    public BrandDatabase() {
        this.brands = new ArrayList<>();
        initializeTestData();
    }

    private void initializeTestData() {

    Brand brand1 = new Brand("Nike", "Sportswear", 1964, "United States", "Nike, Inc. is an American multinational corporation known for its innovative athletic footwear and apparel.");
    Brand brand2 = new Brand("Adidas", "Sportswear", 1949, "Germany", "Adidas AG is a German multinational corporation, founded by Adolf Dassler, that designs and manufactures athletic and casual footwear, apparel, and accessories.");
    Brand brand3 = new Brand("Gucci", "Luxury", 1921, "Italy", "Gucci is an Italian luxury brand known for its high-end fashion and leather goods.");
    Brand brand4 = new Brand("Puma", "Sportswear", 1948, "Germany", "Puma is a German multinational corporation that designs and manufactures athletic and casual footwear, apparel, and accessories.");
    Brand brand5 = new Brand("H&M", "Fashion", 1947, "Sweden", "H&M is a Swedish multinational clothing-retail company known for its affordable and trendy fashion.");
    Brand brand6 = new Brand("Zara", "Fashion", 1974, "Spain", "Zara is a Spanish clothing and accessories retailer known for its fast-fashion and stylish designs.");
    Brand brand7 = new Brand("Levi's", "Denim", 1853, "United States", "Levi's is an American company known for its denim jeans and casual clothing.");
    Brand brand8 = new Brand("Tommy Hilfiger", "Fashion", 1985, "United States", "Tommy Hilfiger is an American fashion brand known for its preppy and classic styles.");
    Brand brand9 = new Brand("Calvin Klein", "Fashion", 1968, "United States", "Calvin Klein is an American fashion brand known for its minimalist and modern designs.");
    Brand brand10 = new Brand("Ralph Lauren", "Fashion", 1967, "United States", "Ralph Lauren is an American fashion brand known for its upscale and classic clothing.");
    Brand brand11 = new Brand("Versace", "Luxury", 1978, "Italy", "Versace is an Italian luxury brand known for its bold and extravagant designs.");
    Brand brand12 = new Brand("Armani", "Luxury", 1975, "Italy", "Armani is an Italian luxury brand known for its clean and sophisticated fashion.");
    Brand brand13 = new Brand("Prada", "Luxury", 1913, "Italy", "Prada is an Italian luxury brand known for its high-quality fashion and accessories.");
    Brand brand14 = new Brand("Chanel", "Fashion", 1909, "France", "Chanel is a French fashion brand known for its elegant and timeless designs.");
    Brand brand15 = new Brand("Burberry", "Fashion", 1856, "United Kingdom", "Burberry is a British fashion brand known for its iconic check patterns and trench coats.");
    Brand brand16 = new Brand("Louis Vuitton", "Luxury", 1854, "France", "Louis Vuitton is a French luxury brand known for its high-end luggage and accessories.");
    Brand brand17 = new Brand("Dior", "Luxury", 1946, "France", "Dior is a French luxury brand known for its haute couture and perfumes.");
    Brand brand18 = new Brand("Balenciaga", "Fashion", 1919, "Spain", "Balenciaga is a Spanish fashion brand known for its avant-garde and streetwear-inspired designs.");
    Brand brand19 = new Brand("Alexander McQueen", "Fashion", 1992, "United Kingdom", "Alexander McQueen is a British fashion brand known for its dramatic and innovative fashion.");
    Brand brand20 = new Brand("Fendi", "Luxury", 1925, "Italy", "Fendi is an Italian luxury brand known for its fur and leather goods.");

        brands.add(brand1);
        brands.add(brand2);
        brands.add(brand3);
        brands.add(brand4);
        brands.add(brand5);
        brands.add(brand6);
        brands.add(brand7);
        brands.add(brand8);
        brands.add(brand9);
        brands.add(brand10);
        brands.add(brand11);
        brands.add(brand12);
        brands.add(brand13);
        brands.add(brand14);
        brands.add(brand15);
        brands.add(brand16);
        brands.add(brand17);
        brands.add(brand18);
        brands.add(brand19);
        brands.add(brand20);

    }


    public List<Brand> getBrands() {
        return brands;
    }

}