package jsonData.nopcommerce;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;

public class UserInfoData {

    public static UserInfoData getUserInfo() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.RESOURCE_PATH + "userData.json"), UserInfoData.class);
        } catch (Exception ex) {
            ex.getStackTrace();
            return null;
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDiscount() {
        return checkout.discount;
    }

    @JsonProperty("Checkout")
    Checkout checkout;

    static class Checkout {
        @JsonProperty("discount")
        String discount;
    }

}
