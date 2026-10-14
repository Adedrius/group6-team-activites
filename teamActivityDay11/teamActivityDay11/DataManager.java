// fixed imports to be able to use those classes
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataManager {
    // Stores users as User objects
    private final List<User> users = new ArrayList<>();

    // Adds a new user
    public void addUser(String firstName, String lastName, String email, String role) {
        users.add(new User(firstName, lastName, email, role));
    }

    // Finds a user by email
    public Optional<User> findByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }
}
