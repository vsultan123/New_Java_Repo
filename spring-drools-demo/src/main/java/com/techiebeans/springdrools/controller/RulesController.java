package com.techiebeans.springdrools.controller;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techiebeans.springdrools.config.DroolConfig;
import com.techiebeans.springdrools.model.RulesData;

@RestController
public class RulesController {
	
	@Autowired
	private DroolConfig droolConfig;
	
	@PostMapping("/rules")
	public RulesData orderNow(@RequestBody RulesData rulesData) {
		KieSession kieSession = this.droolConfig.kiaSession("rules.drl");
		try {
		
		kieSession.insert(rulesData);
		kieSession.fireAllRules();
		return rulesData;
		}
		finally {
			kieSession.destroy();
		}
	}
}
