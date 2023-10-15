import java.util.ArrayList;
import java.util.List;

public class BrandDatabase {
    private List<Brand> brands;

    public BrandDatabase() {
        this.brands = new ArrayList<>();
        initializeTestData();
    }

    private void initializeTestData() {
        // Add some test brands to the database
        Brand brand1 = new Brand("Nike", "Sportswear", 1964, "United States");
        Brand brand2 = new Brand("Adidas", "Sportswear", 1949, "Germany");
        Brand brand3 = new Brand("Gucci", "Luxury", 1921, "Italy");
        Brand brand4 = new Brand("Puma", "Sportswear", 1948, "Germany");
        Brand brand5 = new Brand("H&M", "Fashion", 1947, "Sweden");
        Brand brand6 = new Brand("Zara", "Fashion", 1974, "Spain");
        Brand brand7 = new Brand("Levi's", "Denim", 1853, "United States");
        Brand brand8 = new Brand("Tommy Hilfiger", "Fashion", 1985, "United States");
        Brand brand9 = new Brand("Calvin Klein", "Fashion", 1968, "United States");
        Brand brand10 = new Brand("Ralph Lauren", "Fashion", 1967, "United States");
        Brand brand11 = new Brand("Versace", "Luxury", 1978, "Italy");
        Brand brand12 = new Brand("Armani", "Luxury", 1975, "Italy");
        Brand brand13 =  new Brand("Prada", "Luxury", 1913, "Italy");
        Brand brand14 =  new Brand("Chanel", "Fashion", 1909, "France");
        Brand brand15 = new Brand("Burberry", "Fashion", 1856, "United Kingdom");
        Brand brand16 =  new Brand("Louis Vuitton", "Luxury", 1854, "France");
        Brand brand17 = new Brand("Dior", "Luxury", 1946, "France");
        Brand brand18 =  new Brand("Balenciaga", "Fashion", 1919, "Spain");
        Brand brand19 =  new Brand("Alexander McQueen", "Fashion", 1992, "United Kingdom");
        Brand brand20 =  new Brand("Fendi", "Luxury", 1925, "Italy");

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