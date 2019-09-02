package com.github.webisquid.controllers;

import com.github.webisquid.service.SystemMonitor;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import java.lang.management.ManagementFactory;

@Controller
public class IndexController {
    private int CPULoad;
    public int Memory;

    public int getCPULoad() {
        SystemMonitor monitor = new SystemMonitor();
        return (int) (monitor.getCpuLoad() * 100);
    }

    public int getMemory() {
        SystemMonitor monitor = new SystemMonitor();
        return (int)(100 - monitor.getMemoryLoad());
    }
}
