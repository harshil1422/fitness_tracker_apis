package com.fitnesstracker.dao.impl;

//import com.fitnesstracker.dao.UserDAO;
//import com.fitnesstracker.model.User;
//import com.fitnesstracker.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class UserDAOImpl implements UserDAO {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    @Override
//    public boolean existsByUsername(String username) {
//        return false;
//    }
//
//    @Override
//    public boolean existsByEmail(String email) {
//        return false;
//    }
//
//    @Override
//    public User save(User user) {
//        return userRepository.save(user);
//    }
//}



import com.fitnesstracker.dao.UserDAO;
import com.fitnesstracker.model.User;


        import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> findByUsername(String username) {
        String query = "SELECT u FROM User u WHERE u.username = :username";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        typedQuery.setParameter("username", username);
        try {
            User user = typedQuery.getSingleResult();
            return Optional.of(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean existsByUsername(String username) {
        String query = "SELECT COUNT(u) FROM User u WHERE u.username = :username";
        Long count = (Long) entityManager.createQuery(query)
                .setParameter("username", username)
                .getSingleResult();
        return count > 0;
    }

    @Override
    public boolean existsByEmail(String email) {
        String query = "SELECT COUNT(u) FROM User u WHERE u.email = :email";
        Long count = (Long) entityManager.createQuery(query)
                .setParameter("email", email)
                .getSingleResult();
        return count > 0;
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
        return user;
    }


    @Override
    public Optional<User> findById(Long id) {
        User user = entityManager.find(User.class, id);
        return Optional.ofNullable(user);
    }


}
