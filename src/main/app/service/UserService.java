package app.service;

import app.model.User;
import java.util.List;

public interface UserService {
    public List<User> getAll();
    public User get(int id);
    public void save(User user);
    public void delete(int id);
}
