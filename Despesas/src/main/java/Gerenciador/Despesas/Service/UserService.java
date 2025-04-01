package gerenciador.despesas.Service;

import gerenciador.despesas.Model.UserModel;
import gerenciador.despesas.Repository.UserRepository;
import gerenciador.despesas.Service.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserModel addUserToDB(UserModel userToAdd){return userRepository.save(userToAdd);}
}
