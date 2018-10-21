package com.arch.gradle.dependencies.analyzer;

import com.arch.gradle.dependencies.model.Artifact;
import com.arch.gradle.dependencies.util.ArtifactBuilder;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * This analyzer extracts all artifacts, which are in the gradle cache. It outputs gradle dependency configuration at console.
 * Before run this analyzer, clean the gradle cache <USER_HOME>\.gradle\caches
 * After run this analyzer, copy <USER_HOME>\.gradle\caches\artifacts-2\files-2.1\ to <USER_HOME>\.gradle\caches\artifacts-2\files-2.1-state\
 * Since this cache repo contains all the transitive libraries, the result are useful when introducing a local network repo.
 *
 * @author antony.zhao@chase.com; yuechao.zhao@dieboldnixdorf.com
 * @since Oct, 2018
 */
public class GradleCacheAnalyzer {

    private static final String DIR_USER_HOME = System.getProperty("user.home");

    public static final String DIR_GRADLE_CACHE = "\\.gradle\\caches\\modules-2\\files-2.1-state\\";

    private static final Map<String, Artifact> artifacts = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        pathReader(GradleCacheAnalyzer.DIR_USER_HOME + GradleCacheAnalyzer.DIR_GRADLE_CACHE);
    }

    private static void pathReader(String lib) throws IOException {
        Path root = Paths.get(lib);

        Files.walkFileTree(root, EnumSet.noneOf(FileVisitOption.class), 3, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                if (attrs.isDirectory()) {
                    pathProcessor(root.relativize(path));
                }
                return FileVisitResult.CONTINUE;
            }
        });

        System.out.println(artifacts.keySet());
    }

    private static void pathProcessor(Path path) {
        Artifact art = ArtifactBuilder.buildFromGradleCacheDir(path);
        artifacts.put(art.getFullMapKey(), art);
    }
}
