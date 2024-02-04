package data;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class User
{
    private final Faker faker = new Faker();
    private final FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"),
            new RandomService());
    public String username = faker.name().username();
    public String email = fakeValuesService.bothify("????##@gmail.com");
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String password;
    public String postalCode = faker.address().zipCode();

    public static User valid()
    {
        User user = new User();
        user.setUsername("standard_user");
        user.setPassword("secret_sauce");
        return user;
    }

    public static User invalid()
    {
        User user = new User();
        user.setUsername("locked_out_user");
        user.setPassword("wrong_user");
        return user;
    }
    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getPassword()
    {
        return password;
    }





}
