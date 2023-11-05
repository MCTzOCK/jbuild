package com.bensiebert.jbuildtool;

import com.beust.jcommander.JCommander;

import java.io.File;

public class Main {

    public static Arguments arguments;

    public static void main(String[] args) {
        arguments = new Arguments();
        JCommander.newBuilder()
                .addObject(arguments)
                .build()
                .parse(args);

        File source = new File(arguments.getSource());
        File destination = new File(arguments.getDestination());

        if(!source.exists()) {
            System.out.println("Source directory does not exist");
            System.exit(1);
        }

        if(!source.isDirectory()) {
            System.out.println("Source is not a directory");
            System.exit(1);
        }

        if(destination.exists()) {
            System.out.println("Destination already exists");
            System.exit(1);
        }

        if(!destination.getName().endsWith(".jar")) {
            System.out.println("Destination must be a jar file");
            System.exit(1);
        }

        JarBuilder.build(source, destination, arguments.getMainClass());
    }
}
