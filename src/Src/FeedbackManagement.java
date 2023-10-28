package Src;

import java.util.List;

public class FeedbackManagement {
    private static List<UserReview> userReviews;
    private static List<Brand> brands;



    public FeedbackManagement( List<Brand> brands, List<UserReview> userReviews) {
        this.userReviews = userReviews;
        this.brands = brands;
    }




    public static void calculateAverageRatingsByProduct() {
        for (Brand brand : brands) {
            List<Product> products = brand.getProducts();

            for (Product product : products) {
                double sumRatings = 0.0;
                int reviewCount = 0;

                for (UserReview review : userReviews) {
                    if (review.getProduct() == product) {
                        sumRatings += review.getRating();
                        reviewCount++;
                    }
                }

                if (reviewCount > 0) {
                    double averageRating = sumRatings / reviewCount;
                    System.out.println("Src.Brand: " + brand.getName());
                    System.out.println("Src.Product: " + product.getName());
                    System.out.println("Average Rating: " + averageRating);
                    System.out.println("Total Reviews: " + reviewCount);
                }
            }
        }
    }


    public static void generateFeedbackTrendsReport() {
        System.out.println("Feedback Trends Report");

        if (userReviews.isEmpty()) {
            System.out.println("No feedback available in the system.");
        } else {
            int[] ratingCounts = new int[5];  // An array to store counts for ratings 1 to 5
            int totalRatings = 0;

            for (UserReview review : userReviews) {
                int rating = review.getRating();
                if (rating >= 1 && rating <= 5) {  // Ensure the rating is within the valid range
                    ratingCounts[rating - 1]++;  // Decrement by 1 to match array index
                    totalRatings++;
                }
            }

            System.out.println("Total Ratings: " + totalRatings);
            System.out.println("Rating Distribution:");

            for (int i = 0; i < 5; i++) {
                int count = ratingCounts[i];
                double percentage = (double) count / totalRatings * 100;
                System.out.println((i + 1) + " Stars: " + count + " (" + percentage + "%)");
            }
        }
    }

}
