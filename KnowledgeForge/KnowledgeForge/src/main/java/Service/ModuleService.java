package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g1AppDev.KnowledgeForge.Entity.ModuleEntity;

import Repository.ModuleRepo;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepo moduleRepo;

    public List<Module> getAllModules() {
        return moduleRepo.getAllModules();
    }

    public ModuleEntity saveDetails(ModuleEntity module){
        return moduleRepo.save(module);
    }

    // Get all students
    public List<Module> getAllModules() {
        return moduleRepo.findAll();
    }

    // Update
    public ModuleEntity updateModule(int id, ModuleEntity module) {
        Optional<Module> existingModule = moduleRepo.findById(id);

        if (existingModule.isPresent()) {
            Module updatedModule = existingModule.get();
            updatedModule.setModuleName(module.getModuleName());
            
            

            return moduleRepo.save(updatedModule);
        } else {
            throw new RuntimeException("Student not found with ID: " + id);
        }
    }

    // Delete
    public String deleteModule(int id) {
        Optional<ModuleEntity> module = moduleRepo.findById(id);

        if (module.isPresent()) {
            moduleRepo.deleteById(id);
            return "Student deleted successfully!";
        } else {
            throw new RuntimeException("Student not found with ID: " + id);
        }
    }
}