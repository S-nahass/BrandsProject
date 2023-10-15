import java.util.List;
import java.util.ArrayList;
public class User {
    private List<Brand> favoriteBrands;

    public User() {
        favoriteBrands = new ArrayList<>();
    }

    public List<Brand> getFavoriteBrands() {
        return favoriteBrands;
    }

    public void addFavoriteBrand(Brand brand) {
        favoriteBrands.add(brand);
    }

    public void removeFavoriteBrand(Brand brand) {
        favoriteBrands.remove(brand);
    }

    public void viewFavoriteBrands() {
        for (Brand brand : favoriteBrands) {
            System.out.println(brand.getName());
        }
    }


}


