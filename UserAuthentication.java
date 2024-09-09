import java.util.HashMap;
import java.util.Map;

public class UserAuthentication {
    private Map<String, String> users = new HashMap<>();
    private Account account;

    public UserAuthentication() {
        // Sample users and pins
        users.put("user123", "pin123");
        users.put("user456", "pin456");
        users.put("Divyanshisonkar214", "pin1011");
        users.put("user8055", "pin8055");
       

    }

    public boolean login(String userID, String userPIN) {
        if (users.containsKey(userID) && users.get(userID).equals(userPIN)) {
            account = new Account(userID);  // Create a new account for the user
            return true;
        }
        return false;
    }

    public Account getAccount() {
        return account;
    }
}