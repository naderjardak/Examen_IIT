package io.microservice.userservice.Service.interfaces;

import io.microservice.userservice.entities.Role;
import io.microservice.userservice.entities.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UserInterface {
    User Create(User u,Long n);

    void  DeleteById(long id);

    public User update(User u);

    User GetById(long id);

    public List<User> GetAll();
    public void affectRoleAtUser(long idRole,long idUser);

    public void CreateForReset(User u);

    public User findByResetToken(String resetToken);
    public List<Role> getAllRolesd();
    public boolean sessionReteurn();
    public List<Map<String, Integer>> statsByRole();
    public User updateUserByID(long id,User u);

    public User userConnected();
    public void storeFile(MultipartFile file) throws IOException;


}
