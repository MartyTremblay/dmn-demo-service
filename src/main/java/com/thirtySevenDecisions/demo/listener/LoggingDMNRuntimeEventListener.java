package com.thirtySevenDecisions.demo.listener;

import org.kie.dmn.api.core.event.AfterEvaluateAllEvent;
import org.kie.dmn.api.core.event.AfterEvaluateDecisionServiceEvent;
import org.kie.dmn.api.core.event.DMNRuntimeEventListener;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
public class LoggingDMNRuntimeEventListener implements DMNRuntimeEventListener {

    @Override
    public void afterEvaluateAll(AfterEvaluateAllEvent event) {
        log.info("executed '{}.dmn' with {} errors", event.getModelName(), event.getResult().getMessages().size());
        logPayload(event.getResult().hasErrors(), event.getResult().getContext().toString());
    }

    @Override
    public void afterEvaluateDecisionService(AfterEvaluateDecisionServiceEvent event) {
        log.info("executed '{}' decision-service in '{}.dmn' with {} errors", event.getDecisionService().getName(),
                event.getDecisionService().getModelName(), event.getResult().getMessages().size());
        logPayload(event.getResult().hasErrors(), event.getResult().getContext().toString());
    }

    private void logPayload(boolean hasErrors, String payload) {
        if (hasErrors) {
            log.error("content: {}", payload);
        } else {
            log.debug("content: {}", payload);
        }
    }
}