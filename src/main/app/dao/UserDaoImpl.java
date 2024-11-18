package app.dao;

import app.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return this.entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User get(int id) {
        return this.entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        if (user.getId() == 0) {
            this.entityManager.persist(user);
        } else {
            this.entityManager.merge(user);
        }
    }

    @Override
    public void delete(int id) {
        this.entityManager
                .createQuery("delete from User where id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
