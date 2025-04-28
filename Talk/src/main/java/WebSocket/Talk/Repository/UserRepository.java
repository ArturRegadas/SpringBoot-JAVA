package WebSocket.Talk.Repository;

import WebSocket.Talk.Dto.UserInfoDto;
import WebSocket.Talk.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    @Query("SELECT u FROM UserModel u WHERE u.userName = :username")
    UserModel findByUsername(@Param("username")String username);

    @Query("SELECT new WebSocket.Talk.Dto.UserInfoDto(u.id, u.userName) FROM UserModel u")
    List<UserInfoDto> findAllUserInfo();
}
