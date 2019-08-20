package com.github.webisquid.service;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;


public class SystemMonitor {
   private double CpuLoad = 0;

    private void CpuLoad(){
        OperatingSystemMXBean bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        setCpuLoad(bean.getSystemCpuLoad());
    }

    public double getCpuLoad() {
        CpuLoad();
        return CpuLoad ;
    }

    public void setCpuLoad(double cpuLoad) {
        CpuLoad = cpuLoad;
    }
}
