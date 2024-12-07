package web.PP_3_1_1_spring.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import web.PP_3_1_1_spring.model.User;

import java.util.List;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
    }
    public void update(User user) {
        entityManager.merge(user);
    }
    public void delete(Long id) {
        entityManager.createQuery("delete from User where id=:id").setParameter("id", id).executeUpdate();
    }
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }
    public List<User> findAll() {
        return entityManager.createQuery("from User").getResultList();
    }
}
