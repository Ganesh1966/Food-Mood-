package com.constructweek.foodmood.Repository;

import com.constructweek.foodmood.Entity.FoodMoods;
import com.constructweek.foodmood.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * from user u where u.email=?1",nativeQuery = true)
    public User findByEmail(String email);

    @Modifying
    @Transactional(readOnly=false)
    @Query(value = "UPDATE user u SET u.password = ?2 where u.email=?1",nativeQuery = true)
    public void updatePassword(String email, String newPassword);

    @Modifying
    @Transactional(readOnly=false)
    @Query(value = "DELETE FROM user u where u.email=?1",nativeQuery = true)
    void deleteAccount(String email);


//    @PersistenceContext
//    EntityManager entityManager;
//
//    @Transactional
//    public default User saveUser(User user) {
//
//        entityManager.createNativeQuery("INSERT INTO user (userId,userName,email,password) VALUES (?,?,?,?)")
//                .setParameter(1, user.getUserId())
//                .setParameter(2, user.getUserName())
//                .setParameter(3, user.getEmail())
//                .setParameter(4, user.getPassword())
//                .executeUpdate();
//
//        return user;
//    }

}
