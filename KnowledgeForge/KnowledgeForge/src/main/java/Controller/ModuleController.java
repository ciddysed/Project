package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g1AppDev.KnowledgeForge.Entity.ModuleEntity;

import Service.ModuleService;


@RestController
@RequestMapping("/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @GetMapping("module")
    public List<Module> getAllModules() {
        return moduleService.getAllModules();
    }
    @PostMapping("/addModule")
    public ModuleEntity createModule(@RequestBody ModuleEntity module) {
        return moduleService.saveDetails(module);
    }

    @PutMapping("/updateModule/{id}")
    public ModuleEntity updateModule(@PathVariable int id, @RequestBody ModuleEntity module) {
        return moduleService.updateModule(id, module);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteModule(@PathVariable int id) {
        return moduleService.deleteModule(id);
    }
}
