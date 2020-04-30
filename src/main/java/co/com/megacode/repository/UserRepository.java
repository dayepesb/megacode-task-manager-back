package co.com.megacode.repository;

import co.com.megacode.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.username = :username")
    UserEntity findByUsername(@Param("username")String username);

    @Query("SELECT u FROM UserEntity u WHERE u.email = :email")
    UserEntity findByEmail(@Param("email")String email);

    @Query("SELECT u FROM UserEntity u WHERE u.username = :username AND u.password = :password")
    UserEntity findByUsernamePassword(@Param("username")String username, @Param("password")String password);

    @Query("SELECT u FROM UserEntity u WHERE u.username = :username AND u.id = :id")
    UserEntity findByUsernameId(@Param("username")String username, @Param("id")Long id);
}
