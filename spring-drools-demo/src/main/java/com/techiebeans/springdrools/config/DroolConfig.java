package com.techiebeans.springdrools.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolConfig {
    
    private KieServices getKieServices() {
        return KieServices.Factory.get();
    }
    
    public KieSession kiaSession( String rdlFile){

        KieFileSystem kieFileSystem = getKieFileSystem(rdlFile);
        KieBuilder kieBuilder = getKieServices().newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        KieContainer kieContainer = getKieServices().newKieContainer(kieModule.getReleaseId());
        return kieContainer.newKieSession();
    } 
   
    private KieFileSystem getKieFileSystem(String rdlFile) {
        KieFileSystem kieFileSystem = getKieServices().newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource(rdlFile));
        return kieFileSystem;
    }
}
