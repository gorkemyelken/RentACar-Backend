package backend.rentacar.business.constants;

import backend.rentacar.entities.dtos.branddto.BrandViewDto;
import backend.rentacar.entities.dtos.cardto.CarViewDto;
import backend.rentacar.entities.dtos.colordto.ColorViewDto;

public class Messages {
    public static class GlobalMessages{
        public static final String DATA_LISTED = "Data listed successfully.";
        public static final String DATA_ADDED = "Data added successfully.";
        public static final String DATA_UPDATED = "Data updated successfully.";
        public static final String DATA_DELETED = "Data deleted successfully.";
    }
    public static class BrandMessages{
        public static final String BRAND_LISTED_BY_BRAND_NAME_ASC = "Brands listed by brand name in ascending order.";
        public static final String BRAND_LISTED_BY_BRAND_NAME_DESC = "Brands listed by brand name in descending order.";
        public static final String BRAND_LISTED_BY_BRAND_ID = "Brand listed by brand id.";
        public static final String BRAND_LISTED_BY_BRAND_NAME = "Brand listed by brand name.";
        public static final String BRAND_ID_NOT_FOUND = "Brand id not found." ;
        public static final String BRAND_NAME_ALREADY_EXIST = "Brand name already exist.";
        public static final String BRAND_NAME_NOT_FOUND = "Brand name not found.";
    }
    public static class CarMessages{
        public static final String CAR_LISTED_BY_CAR_NAME_ASC = "Cars listed by car name in ascending order.";
        public static final String CAR_LISTED_BY_CAR_NAME_DESC = "Cars listed by car name in descending order.";
        public static final String CAR_LISTED_BY_DAILY_PRICE_ASC = "Cars listed by daily price in ascending order.";
        public static final String CAR_LISTED_BY_DAILY_PRICE_DESC = "Cars listed by daily price in descending order.";
        public static final String CAR_LISTED_BY_MODEL_YEAR_ASC = "Cars listed by model year in ascending order.";
        public static final String CAR_LISTED_BY_MODEL_YEAR_DESC = "Cars listed by model year in descending order.";
        public static final String CAR_LISTED_BY_CAR_ID = "Car listed by car id.";
        public static final String CAR_LISTED_BY_CAR_NAME = "Car listed by car name.";
        public static final String CAR_LISTED_BY_DAILY_PRICE = "Car listed by daily price.";
        public static final String CAR_LISTED_BY_MODEL_YEAR = "Car listed by model year.";
        public static final String CAR_LISTED_BY_DAILY_PRICE_LESS_THAN = "Cars listed by daily price less than.";
        public static final String CAR_LISTED_BY_DAILY_PRICE_GREATER_THAN = "Cars listed by daily price greater than.";
        public static final String CAR_LISTED_BY_DAILY_PRICE_BETWEEN = "Cars listed by daily price between.";
        public static final String CAR_LISTED_BY_MODEL_YEAR_LESS_THAN = "Cars listed by model year less than.";
        public static final String CAR_LISTED_BY_MODEL_YEAR_GREATER_THAN = "Cars listed by model year greater than.";
        public static final String CAR_LISTED_BY_MODEL_YEAR_BETWEEN = "Cars listed by model year between.";
        public static final String CAR_LISTED_BY_DESCRIPTION_CONTAINING = "Cars listed by description containing.";
        public static final String CAR_LISTED_BY_BRAND = "Cars listed by brand.";
        public static final String CAR_LISTED_BY_COLOR = "Cars listed by color.";
        public static final String CAR_NAME_ALREADY_EXIST = "Car name already exist.";
        public static final String CAR_ID_NOT_FOUND = "Car id not found.";
        public static final String CAR_NAME_NOT_FOUND = "Car name not found.";
    }
    public static class ColorMessages{
        public static final String COLOR_LISTED_BY_COLOR_NAME_ASC = "Colors listed by color name in ascending order.";
        public static final String COLOR_LISTED_BY_COLOR_NAME_DESC = "Colors listed by color name in descending order.";
        public static final String COLOR_LISTED_BY_COLOR_ID = "Color listed by color id.";
        public static final String COLOR_LISTED_BY_COLOR_NAME = "Colors listed by color name.";
        public static final String COLOR_NAME_ALREADY_EXIST = "Color name already exist.";
        public static final String COLOR_ID_NOT_FOUND = "Color id not found.";
        public static final String COLOR_NAME_NOT_FOUND = "Color name not found.";
    }
    public static class RentalMessages{

        public static final String RENTAL_LISTED_BY_RENTAL_ID = "Rental listed by rental id.";
        public static final String RENTAL_LISTED_BY_RENT_DATE_ASC = "Rentals listed by rent date in ascending order.";
        public static final String RENTAL_LISTED_BY_RENT_DATE_DESC = "Rentals listed by rent date in descending order.";
        public static final String RENTAL_LISTED_BY_RETURN_DATE_ASC = "Rentals listed by return date in ascending order.";
        public static final String RENTAL_LISTED_BY_RETURN_DATE_DESC = "Rentals listed by return date in descending order.";
        public static final String RENTAL_ID_NOT_FOUND = "Rental id not found.";
    }
    public static class CarImageMessages{
        public static final String IMAGE_PATH_ALREADY_EXIST = "Image path already exist.";
        public static final String CAR_IMAGE_ID_NOT_FOUND = "Car image id not found.";
    }
    public static class CustomerMessages{

        public static final String CUSTOMER_EMAIL_ALREADY_EXIST = "Customer email already exist.";
        public static final String CUSTOMER_NATIONALITY_NUMBER_ALREADY_EXIST = "Customer nationality number already exist.";
        public static final String CUSTOMER_ID_NOT_FOUND = "Customer id not found.";
    }
}

