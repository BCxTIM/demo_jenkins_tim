package demo.spring.selenium.models;

public class UserCredentials {
    private String username;
    private String password;
    private String someText;


    public UserCredentials(String username, String password, String someText) {
        this.username = username;
        this.password = password;
        this.someText = someText;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String someText() {
        return someText;
    }
}
