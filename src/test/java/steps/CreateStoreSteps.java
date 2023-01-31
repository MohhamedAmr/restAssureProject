package steps;

import com.github.javafaker.Faker;
import org.jetbrains.annotations.NotNull;
import pojo.BodyPath;

public class CreateStoreSteps {
    public static @NotNull BodyPath generateUser() {
        Faker faker = new Faker();
        String phoneNumber = faker.numerify("+2012########");
        String userName = faker.internet().emailAddress();
        String loginName = faker.name().lastName();
        String name = faker.name().lastName();
        String password = "123456";
        String confirmPassword = "123456";
        String email = faker.internet().emailAddress();
        Boolean isActivated = true;
        String storeLogoContent = "";
        String storeLogoName = "";
        String storeLogoUrl = "https://dev.cdn.shgardi.app/catalog/StoreLogoImages/4f703f47-14f7-4b8d-b708-5a7b409e7489_2022-06-20_09-56-41-AM.jpg";
        Integer userType = 5;
        // BodyPath body = new BodyPath(phoneNumber , userName , loginName , name , password ,confirmPassword ,email ,isActivated,storeLogoContent,storeLogoName ,storeLogoUrl ,userType);

        return null;
    }}


