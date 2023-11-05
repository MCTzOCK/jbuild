package com.bensiebert.jbuildtool;

import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

public class Arguments {

    @Parameter
    private List<String> parameters = new ArrayList<>();

    @Parameter(names = {"-s", "--source"}, description = "Source directory", required = true)
    private String source = "src";

    @Parameter(names = {"-d", "--destination"}, description = "Jar Destination", required = true)
    private String destination = "app.jar";

    @Parameter(names = {"-m", "--main"}, description = "Main Class", required = true)
    private String mainClass = "Main";

    public List<String> getParameters() {
        return parameters;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getMainClass() {
        return mainClass;
    }
}
