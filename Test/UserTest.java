import org.junit.jupiter.api.Test;
import task3.User;
import task3.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void userCreation() {
        User user = new User("user_0", "psw123", false);
        assertTrue(user.authenticate("user_0", "psw123"));
    }

    @Test
    void userCreationFailed() {
        User user = new User("user_0", "123psw", false);
        assertFalse(user.authenticate("user_0", "psw123"));
    }

    @Test
    void userRepository() {
        UserRepository userRepository = new UserRepository();
        User userNA = new User("user_0", "psw123", false);
        userRepository.addUser(userNA);
        assertFalse(userRepository.findByName(userNA.name));
    }

    @Test
    void userRepositoryNA() {
        UserRepository userRepository = new UserRepository();
        User userNA = new User("user_0", "psw123", false);
        userNA.authenticate("user_0", "psw23");
        userRepository.addUser(userNA);
        assertFalse(userRepository.findByName(userNA.name));
    }

    @Test
    void adminHasAccessListUsers() {
        UserRepository userRepository = new UserRepository();

        User admin = new User("admin", "admin123", true); // Администратор
        User userNotAdmin1 = new User("user_0", "psw0", false);
        User userNotAdmin2 = new User("user_1", "psw1", false);

        admin.authenticate("admin", "admin123");
        userNotAdmin1.authenticate("user_0", "psw0");
        userNotAdmin2.authenticate("user_1", "psw1");

        userRepository.addUser(admin);
        userRepository.addUser(userNotAdmin1);
        userRepository.addUser(userNotAdmin2);

        userRepository.logoutAllExceptAdmins();

        assertFalse(userNotAdmin1.isAuthenticate, "Пользователь user_0 должен быть разлогинен.");
        assertFalse(userNotAdmin2.isAuthenticate, "Пользователь user_1 должен быть разлогинен.");
        assertTrue(admin.isAuthenticate, "Администратор должен остаться залогинен.");
    }

    @Test
    void logoutAllExceptAdmins() {
        UserRepository userRepository = new UserRepository();

        User admin = new User("admin", "admin123", true);
        User userNotAdmin1 = new User("user_0", "psw0", false);
        User userNotAdmin2 = new User("user_1", "psw1", false);

        admin.authenticate("admin", "admin123");
        userNotAdmin1.authenticate("user_0", "psw0");
        userNotAdmin2.authenticate("user_1", "psw1");

        userRepository.addUser(admin);
        userRepository.addUser(userNotAdmin1);
        userRepository.addUser(userNotAdmin2);

        userRepository.logoutAllExceptAdmins(userNotAdmin1, userNotAdmin2);

        assertFalse(userNotAdmin1.isAuthenticate, "Пользователь user_0 должен быть разлогинен.");
        assertFalse(userNotAdmin2.isAuthenticate, "Пользователь user_1 должен быть разлогинен.");
        assertTrue(admin.isAuthenticate, "Администратор должен остаться залогинен.");
    }

    @Test
    void logoutAllUsers() {
        UserRepository userRepository = new UserRepository();

        User admin = new User("admin", "admin123", true);
        User userNotAdmin1 = new User("user_0", "psw0", false);
        User userNotAdmin2 = new User("user_1", "psw1", false);

        admin.authenticate("admin", "admin123");
        userNotAdmin1.authenticate("user_0", "psw0");
        userNotAdmin2.authenticate("user_1", "psw1");

        userRepository.addUser(admin);
        userRepository.addUser(userNotAdmin1);
        userRepository.addUser(userNotAdmin2);

        userRepository.logoutAll();

        assertFalse(admin.isAuthenticate, "Администратор должен быть разлогинен.");
        assertFalse(userNotAdmin1.isAuthenticate, "Пользователь user_0 должен быть разлогинен.");
        assertFalse(userNotAdmin2.isAuthenticate, "Пользователь user_1 должен быть разлогинен.");
    }
}
