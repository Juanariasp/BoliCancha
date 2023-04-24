package com.example.websocketi.service;


import com.example.websocketi.model.Admin;
import com.example.websocketi.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return this.adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int adminId) {
        return this.adminRepository.getAdmin(adminId);
    }

    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null)
            return this.adminRepository.save(admin);
        Optional<Admin> e = this.adminRepository.getAdmin(admin.getIdAdmin().intValue());
        if (!e.isPresent())
            return this.adminRepository.save(admin);
        return admin;
    }

    public void saveAmigo(int idAdmin, int idAmigo) {
        Optional<Admin> admin = this.adminRepository.getAdmin(idAdmin);
        if (admin.isPresent())
            ((Admin)admin.get()).getIdAmigos().add(Integer.valueOf(idAmigo));
        this.adminRepository.save(admin.get());
    }

    public Admin update(Admin admin) {
        if (admin.getIdAdmin() != null) {
            Optional<Admin> e = this.adminRepository.getAdmin(admin.getIdAdmin().intValue());
            if (e.isPresent()) {
                if (admin.getName() != null)
                    ((Admin)e.get()).setName(admin.getName());
                this.adminRepository.save(e.get());
                return e.get();
            }
            return admin;
        }
        return admin;
    }

    public boolean deleteAdmin(int adminId) {
        Boolean aBoolean = getAdmin(adminId).<Boolean>map(admin -> {
            this.adminRepository.delete(admin);
            return Boolean.valueOf(true);
        }).orElse(Boolean.valueOf(false));
        return aBoolean.booleanValue();
    }

    public Admin getAdmin(String admin, String password) {
        return this.adminRepository.getUser(admin, password);
    }
}
