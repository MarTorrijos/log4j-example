package user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import logs.*;

public class UserManager {

    private static final Logger logger = LogManager.getLogger(UserManager.class.getName());

    public void saveUser(User user){
        ObjectMapper objMapper = new ObjectMapper();
        Map<String, User> users = loadUsers();

        if(users.containsKey(user.getName())) {
            System.out.println(UserMessage.USER_ALREADY_REGISTERED);
            logger.debug(LoggingMsg.REGISTER_FAIL + "{}", user.getName());
            return;

        }
        users.put(user.getName(), user);
        try {
            objMapper.writeValue(new File("src/main/resources/users.json"), users);
            System.out.println(UserMessage.REGISTER_SUCCESS);
            logger.info(LoggingMsg.REGISTER_SUCCESS + ". Usuario registrado: {}", user.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void validateUser(String name, String pass){
        if(!loadUsers().containsKey(name)){
            System.out.println(UserMessage.INVALID_CREDENTIALS);
            logger.debug(LoggingMsg.LOGIN_FAIL + ". Usuario `{}` no existe", name);
            return;
        }
        if(!loadUsers().get(name).getPassword().equalsIgnoreCase(pass)) {
            System.out.println(UserMessage.INVALID_CREDENTIALS);
            logger.debug(LoggingMsg.LOGIN_FAIL + ". Contraseña no válida");
            return;
        }
        System.out.println(UserMessage.LOGIN_SUCCESS);
        logger.info(LoggingMsg.LOGIN_SUCCESS);
    }

    private Map<String, User> loadUsers(){
        ObjectMapper mapper = new ObjectMapper();
        File file =new File("src/main/resources/users.json");
        if(file.length() < 1)
            return new HashMap<>();
        try {
            return mapper.readValue(file, new TypeReference<HashMap<String, User>>() {});
        } catch (IOException e) {
            logger.error(LoggingMsg.IO_FAIL + " Archivo inexistente en la ruta proporcionada");
            throw new RuntimeException(e);
        }
    }

}