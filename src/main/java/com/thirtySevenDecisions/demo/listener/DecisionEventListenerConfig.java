package com.thirtySevenDecisions.demo.listener;

import org.kie.kogito.dmn.config.CachedDecisionEventListenerConfig;
import org.springframework.stereotype.Component;

@Component
public class DecisionEventListenerConfig extends CachedDecisionEventListenerConfig {

    public DecisionEventListenerConfig() {
        register(new LoggingDMNRuntimeEventListener());
    }
}
