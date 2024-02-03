package data;

import com.github.javafaker.Faker;

public class User {
    private final Faker faker = new Faker();
    private String accountId;
    private String merchantId;
    private String email;
    private String username;
    private String password;


    public static User valid() {
        User user = new User();
        user.setUsername("standard_user");
        user.setPassword("secret_sauce");
        return user;
    }

    public static User invalid() {
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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getRandomName()
    {
        return faker.name().firstName();
    }

    public String getRandomPostalCode()
    {
        return faker.address().zipCode();
    }

    private String businessName;




}
