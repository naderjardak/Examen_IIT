package io.microservice.userservice.controllers;

import io.microservice.userservice.API.StatStorePDF;
import io.microservice.userservice.Service.interfaces.UserInterface;
import io.microservice.userservice.entities.Role;
import io.microservice.userservice.entities.User;
import io.microservice.userservice.repositories.UserrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", allowedHeaders = "*") // add this line
public class UserController {
    @Autowired
    UserInterface userInterface;

    @Autowired
    UserrRepository userrRepository;

    @PostMapping("/addUser")
    public User Create(@RequestBody User u) {
        return userInterface.Create(u,3L);
    }

    @PostMapping("/addAll")
    public User Create(@RequestBody User u,@RequestParam Long n) {
        return userInterface.Create(u,n);
    }


    @PutMapping("/updateUser")
    public User update(@RequestBody User u) {
       return  userInterface.update(u);
    }

    @GetMapping("/selectUserById")
    User GetById(@RequestParam long id){
        return userInterface.GetById(id);
    }


    @PutMapping("/affectRole")
    public void affectRoleAtUser(@RequestParam long idRole,@RequestParam long idUser){
     userInterface.affectRoleAtUser(idRole,idUser);
    }
    @GetMapping("getAllRoles")
    public  List<Role> getAllRolesd(){return  userInterface.getAllRolesd();}

    @GetMapping("session")
    public boolean sessionReteurn(){
        return userInterface.sessionReteurn();
    }

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/logout")
    public String logout() {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login";
    }

    // @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("update/{id}")
    public User updateUserById(@RequestParam long id, @RequestBody User u) {
        return userInterface.updateUserByID(id, u);
    }

    @GetMapping("StatsByRole")
    public List<Map<String, Integer>> statsByRole(){return userInterface.statsByRole();}

    @GetMapping("users")
    public List<User> GetAll() {
        return userInterface.GetAll();
    }

    // @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("delete/{id}")
    void DeleteById(@RequestParam long id) {
        userInterface.DeleteById(id);
    }


    @GetMapping(value = "/PDF_Stats", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> SellersGroupedByCityName() throws IOException {
        List<String> stats = userrRepository.getUsersGroupedByType();

        ByteArrayInputStream bis = StatStorePDF.SellersGroupedByCityName(stats);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/pdf");
        headers.add("Content-Disposition", "attachment; filename=" + new Date(System.currentTimeMillis()) + ".pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @GetMapping("/connected")
    public User userConnected(){return userInterface.userConnected();}
}
