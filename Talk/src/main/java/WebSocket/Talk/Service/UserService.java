package WebSocket.Talk.Service;

import WebSocket.Talk.Dto.UserInfoDto;
import WebSocket.Talk.Model.UserModel;
import WebSocket.Talk.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserModel createUser(UserModel userForAdd){
        return userRepository.save(userForAdd);
    }

    public UserModel loginUser(String username, String password){
        return userRepository.findByUsername(username);
    }

    public List<UserInfoDto> getAllUsers(){
        return userRepository.findAllUserInfo();
    }
}
