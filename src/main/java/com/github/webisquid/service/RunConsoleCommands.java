package com.github.webisquid.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class RunConsoleCommands {
    private String cmd;

    private void runCommand(String cmd){

        try {
            this.cmd = cmd;
            System.out.println("Executing command: " + cmd);
            Process p = Runtime.getRuntime().exec(cmd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}