package com.arch.gradle.dependencies.analyzer;

import com.arch.gradle.dependencies.model.Artifact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * This analyzer analyses dependency.report, which is build by gradle plugin dependencies.
 *
 * <b>Attention</b> The dependency.report don't include the dependencies of repackages and gradle plugins.
 * For instance, org.glassfish.hk2.external repacks aopalliance:aopalliance:1.0, which makes aopalliance not shown in the dependency report.
 * Besides, the dependencies of the gradle plugins that are being used in the build process, are not in the dependency report.
 *
 * @author antony.zhao@chase.com; yuechao.zhao@dieboldnixdorf.com
 * @since Oct, 2018
 */
public class DependencyReportAnalyzer {

    private static Map<String, Artifact> staticMapInternal = new TreeMap<>();
    private static Map<String, Artifact> staticMapExternal = new TreeMap<>();
    private static List<Integer> notFoundLines = new ArrayList<>();
    private static List<Integer> overrideLines = new ArrayList<>();
    private static List<Integer> duplicateLines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        analyze("dependency.report");
    }

    public static void analyze(String resource) throws IOException {
        List<String> lines = fileReader(resource);

        int i = 0;
        for (String line : lines) {
            funcLine(line, ++i);
        }

        System.out.println(notFoundLines);
        System.out.println(overrideLines);
        System.out.println(duplicateLines);
        System.out.println(staticMapInternal.keySet());
        System.out.println(staticMapExternal.keySet());

    }

    private static List<String> fileReader(String resource) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        List<String> lines;
        try (InputStream is = classloader.getResourceAsStream(resource)) {
            lines = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)).lines().collect(Collectors.toList());
        }

        return lines;
    }

    private static void funcLine(String line, int lineNumber) {

        final String regex = "([\\|\\ \\+\\-\\\\]{2,})([\\w\\.\\-]*):([\\w\\-]*)[:]{0,1}([\\d\\.\\-\\w]*)([\\ \\-\\>\\ ]{0,4})([\\d\\.\\-\\w]*)([\\ \\(\\*\\)]{0,4})";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher m = pattern.matcher(line);


        if (!m.find()) {
            notFoundLines.add(lineNumber);
            return;
        }

        Artifact art = new Artifact();
        art.setGroupId(m.group(2)); // aopalliance
        art.setArtifactId(m.group(3)); // aopalliance
        art.setVersion(m.group(4)); // 1.0
        art.setOverride(m.group(5)); // ->
        art.setOverVersion(m.group(6));
        art.setDuplicate(m.group(7)); // (*)

        if (art.isInternal()) {
            staticMapInternal.put(art.getFullMapKey(), art);
        } else {
            staticMapExternal.put(art.getFullMapKey(), art);
        }

        if (art.isOverride()) {
            overrideLines.add(lineNumber);
        }

        if (art.isDuplicate()) {
            duplicateLines.add(lineNumber);
        }
    }
}
