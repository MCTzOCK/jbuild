package com.bensiebert.jbuildtool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class JarBuilder {

    public static void compile(String sourceDir, String outDir) {
        File src = new File(sourceDir);

        if (!src.exists()) {
            System.out.println("Source directory does not exist.");
            return;
        }

        if (!src.isDirectory()) {
            System.out.println("Source directory is not a directory.");
            return;
        }

        File out = new File(outDir);

        if (out.exists()) {
            out.delete();
        }

        out.mkdir();


        ArrayList<String> files = getFiles(src, "java");

        String commandline = "javac -d " + outDir + " ";

        for(String file : files) {
            commandline += file + " ";
        }

        try {
            Runtime.getRuntime().exec(commandline);
        } catch (IOException e) {
            System.out.println("Error while executing command: " + commandline);
        }

    }

    public static void build(File src, File dest, String mainClass) {
        compile(src.getAbsolutePath(), "build");

        jar(mainClass, dest.getAbsolutePath(), "build");
    }

    public static void jar(String mainClass, String jarFile, String classDir) {
        File src = new File(classDir);

        if (!src.exists()) {
            System.out.println("Class directory does not exist.");
            return;
        }

        if (!src.isDirectory()) {
            System.out.println("Class directory is not a directory.");
            return;
        }

        File out = new File(jarFile);

        if (out.exists()) {
            out.delete();
        }

        String commandline = "jar cfe " + jarFile + " " + mainClass + " .";

        try {
            Process p = Runtime.getRuntime().exec(commandline, null, new File(classDir));
            p.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error while executing command: " + commandline);
        }
    }

    public static ArrayList<String> getFiles(File dir, String extensionFilter) {
        ArrayList<String> files = new ArrayList<>();

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                files.addAll(getFiles(file, extensionFilter));
            } else {
                if (file.getName().endsWith(extensionFilter)) {
                    files.add(file.getAbsolutePath());
                }
            }
        }

        return files;
    }


}
