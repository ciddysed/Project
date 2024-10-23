package com.g1AppDev.KnowledgeForge.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Module")
public class ModuleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "moduleId")
    private int moduleId;

    @Column(name = "moduleName")
    private String moduleName;

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) { this.moduleId = moduleId; }

    public String getModuleName() { return moduleName; }    

    public void setModuleName(String moduleName) { this.moduleName = moduleName; }  
}
