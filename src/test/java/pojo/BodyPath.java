

package pojo;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder
public class BodyPath {

    @JsonProperty("userName")
    private String userName;
    @JsonProperty("confirmPassword")
    private String confirmPassword;
    @JsonProperty("email")
    private String email;
    @JsonProperty("isActivated")
    private Boolean isActivated;
    @JsonProperty("loginName")
    private String loginName;
    @JsonProperty("name")
    private String name;
    @JsonProperty("password")
    private String password;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("storeLogoContent")
    private String storeLogoContent;
    @JsonProperty("storeLogoName")
    private String storeLogoName;
    @JsonProperty("storeLogoUrl")
    private String storeLogoUrl;
    @JsonProperty("userType")
    private Integer userType;


    //public BodyPath(String phoneNumber, String userName, String loginName, String name, String password, String confirmPassword, String email, boolean isActivated, String storeLogoContent, String storeLogoName, String storeLogoUrl, int userType) {
   // }

    public BodyPath(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }


    public BodyPath(String confirmPassword, String email, Boolean isActivated, String loginName, String name, String password, String phoneNumber, String storeLogoContent, String storeLogoName, String storeLogoUrl, Integer userType) {

        this.confirmPassword = confirmPassword;
        this.email = email;
        this.isActivated = isActivated;
        this.loginName = loginName;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.storeLogoContent = storeLogoContent;
        this.storeLogoName = storeLogoName;
        this.storeLogoUrl = storeLogoUrl;
        this.userType = userType;
    }




    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }
    @JsonProperty("userName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("confirmPassword")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    @JsonProperty("confirmPassword")
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("isActivated")
    public Boolean getIsActivated() {
        return isActivated;
    }

    @JsonProperty("isActivated")
    public void setIsActivated(Boolean isActivated) {
        this.isActivated = isActivated;
    }

    @JsonProperty("loginName")
    public String getLoginName() {
        return loginName;
    }

    @JsonProperty("loginName")
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("storeLogoContent")
    public String getStoreLogoContent() {
        return storeLogoContent;
    }

    @JsonProperty("storeLogoContent")
    public void setStoreLogoContent(String storeLogoContent) {
        this.storeLogoContent = storeLogoContent;
    }

    @JsonProperty("storeLogoName")
    public String getStoreLogoName() {
        return storeLogoName;
    }

    @JsonProperty("storeLogoName")
    public void setStoreLogoName(String storeLogoName) {
        this.storeLogoName = storeLogoName;
    }

    @JsonProperty("storeLogoUrl")
    public String getStoreLogoUrl() {
        return storeLogoUrl;
    }

    @JsonProperty("storeLogoUrl")
    public void setStoreLogoUrl(String storeLogoUrl) {
        this.storeLogoUrl = storeLogoUrl;
    }

    @JsonProperty("userType")
    public Integer getUserType() {
        return userType;
    }

    @JsonProperty("userType")
    public void setUserType(Integer userType) {
        this.userType = userType;
    }



}