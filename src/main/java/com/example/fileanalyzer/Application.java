package com.example.fileanalyzer;

import com.example.fileanalyzer.modules.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

@SpringBootApplication
public class Application {

    private static List<Module> modules;
    private static Map<String, Consumer<String>> commands;
    private static boolean running = true;

    @Autowired
    public Application(List<Module> modules) {
        Application.modules = modules;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        for (int i = args[0].length() - 1; i >= 0; i--) {
            if (args[0].charAt(i) == '.') {
                initCommands(args[0].substring(i));
                break;
            }
        }
        readCommands(args[0]);
    }

    private static void initCommands(String fileType) {
        commands = new HashMap<>();
        System.out.println("Hello! Here are my functions:");
        int count = 1;
        commands.put("q", Application::exit);
        commands.put("path", Application::printCurrentPath);
        for (Module module : modules) {
            if (module.supportsFileType(fileType)) {
                System.out.printf("[%d] %s%n", count, module.getDescription());
                commands.put(String.valueOf(count), module::runFunc);
                count++;
            }
        }
    }

    private static void exit(String args) {
        running = false;
        System.out.println("Goodbye!");
    }

    private static void printCurrentPath(String args) {
        try {
            System.out.println(new java.io.File(".").getCanonicalPath());
        } catch (IOException ioException) {
            System.out.println("error");
        }
    }

    private static void readCommands(String filepath) {
        Scanner in = new Scanner(System.in);

        running = true;
        while (running) {
            if (in.hasNextLine()) {
                String command = in.nextLine();
                if (!commands.containsKey(command)) {
                    System.out.println("I don't have an option for " + command);
                } else {
                    if (filepath == null) {
                        System.out.println("enter filepath:");
                        commands.get(command).accept(in.nextLine());
                    } else {
                        commands.get(command).accept(filepath);
                    }
                }
            }
        }
        in.close();
    }

}
