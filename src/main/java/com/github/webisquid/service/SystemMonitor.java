package com.github.webisquid.service;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class SystemMonitor {
    final OperatingSystemMXBean mxBean =
            (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    double load = 0;
    double load() {

        for (int i = 0; i < 10; i++) {
            load = mxBean.getSystemCpuLoad();
            if ((load < 0.0 || load > 1.0) && load != -1.0) {
                throw new RuntimeException("getSystemCpuLoad() returns " + load
                        + " which is not in the [0.0,1.0] interval");
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }return load;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }}
