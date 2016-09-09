package com.github.slamdev.morrigna.toolset.business.dashboard;

import com.github.slamdev.morrigna.toolset.integration.Controller;
import com.github.slamdev.morrigna.toolset.integration.Startup;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class StartupControllerProvider {

    @Inject
    private Instance<DashboardController> controller;

    @Produces
    @Startup
    public Controller produce() {
        if (/*some conditional check*/ true) {
            return controller.get();
        }
        return null;
    }
}
