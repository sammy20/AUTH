package fmi.pserasmusip.dao;

import fmi.pserasmusip.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findById(int id);

//    @Query(value = "select * from users", nativeQuery = true)
//    List<User> findAllUsers();

    void deleteById(int userId);


    //@Query("DELETE FROM users u WHERE u.username=:username")
    @Modifying
    void deleteUserByUsername(String username);

    User findByUsername(String username);



}
