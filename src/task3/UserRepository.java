package task3;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if (user.isAuthenticate) {
            data.add(user);
        }
    }

    public boolean findByName(String username) {
        for (User user : data){
            if (user.name.equals(username)){
                return true;
            }
        }
        return false;
    }

    public void logoutAllExceptAdmins(User userNotAdmin1, User userNotAdmin2) {
        for (User user : data) {
            if (!user.isAdmin) {
                user.logOut();
            }
        }
    }

    public void logoutAll() {
        for (User user : data) {
            user.logOut();
        }
    }

    public void logoutAllExceptAdmins() {
        for (User user : data) {
            if (!user.isAdmin) {
                user.logOut();
            }
        }
    }
}
