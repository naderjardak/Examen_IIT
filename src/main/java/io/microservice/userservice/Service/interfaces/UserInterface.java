package io.microservice.userservice.Service.interfaces;

import io.microservice.userservice.entities.Role;
import io.microservice.userservice.entities.User;

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

    
}
