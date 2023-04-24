package com.example.websocketi.controller;



import com.example.websocketi.model.Admin;
import com.example.websocketi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/api/Admin"})
public class AdminController {
  @Autowired
  private AdminService adminService;
  
  @GetMapping({"/all"})
  public List<Admin> getClients() {
    return this.adminService.getAll();
  }
  
  @GetMapping({"/{id}"})
  public Optional<Admin> getAdmin(@PathVariable("id") int adminId) {
    return this.adminService.getAdmin(adminId);
  }
  
  @GetMapping({"ingresar/{user}/{password}"})
  @CrossOrigin(origins = "http://localhost:3000")
  public Admin getAdmin(@PathVariable("user") String userAdmin, @PathVariable("password") String userPassword) {
    return this.adminService.getAdmin(userAdmin, userPassword);
  }
  
  @PostMapping({"/save"})
  @ResponseStatus(HttpStatus.CREATED)
  @CrossOrigin(origins = "http://localhost:3000")
  public Admin save(@RequestBody Admin admin) {
    return this.adminService.save(admin);
  }
  
  @GetMapping({"/saveAmigo/{idClient}/{idAmigo}"})
  @ResponseStatus(HttpStatus.CREATED)
  public void saveAmigo(@PathVariable("idClient") int idAdmin, @PathVariable("idAmigo") int idAmigo) {
    this.adminService.saveAmigo(idAdmin, idAmigo);
  }
  
  @PutMapping({"/update"})
  @ResponseStatus(HttpStatus.CREATED)
  public Admin update(@RequestBody Admin admin) {
    return this.adminService.update(admin);
  }
  
  @DeleteMapping({"/{id}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public boolean delete(@PathVariable("id") int adminId) {
    return this.adminService.deleteAdmin(adminId);
  }
}

