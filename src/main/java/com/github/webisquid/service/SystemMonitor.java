package com.github.webisquid.service;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;


public class SystemMonitor {
   private double CpuLoad = 0;
   private double MemoryLoad = 0;

    private void CpuLoad(){
        OperatingSystemMXBean bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        setCpuLoad(bean.getSystemCpuLoad());
    }

    private void MemoryLoad(){
        OperatingSystemMXBean bean =(OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        setMemoryLoad(bean.getTotalPhysicalMemorySize()/bean.getFreePhysicalMemorySize());
    }

    public double getCpuLoad() {
        CpuLoad();
        return CpuLoad ;
    }

    public double getMemoryLoad() {
        MemoryLoad();
        return MemoryLoad;
    }

    public void setMemoryLoad(double memoryLoad) {
        MemoryLoad = memoryLoad;
    }

    public void setCpuLoad(double cpuLoad) {
        CpuLoad = cpuLoad;
    }
}
