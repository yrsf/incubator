package com.arch.gradle.dependencies.api;


import com.arch.gradle.dependencies.analyzer.GradleCacheAnalyzer;
import com.arch.gradle.dependencies.model.FileStatistics;
import com.google.gson.Gson;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public abstract class ArtifactStatistics {

    private static final String DIR_USER_HOME = System.getProperty("user.home");

    protected static final String INPUT = DIR_USER_HOME + GradleCacheAnalyzer.DIR_GRADLE_CACHE;

    private static final RestClient REST_CLIENT = new RestClient();

    protected final void pathProcessor(Path root) throws IOException {

        Files.walkFileTree(root, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs) throws IOException {
                if (attrs.isRegularFile()) {

                    String extension = FilenameUtils.getExtension(filePath.toString());

                    if (!StringUtils.equals(extension, "pom") && !StringUtils.equals(extension, "jar")) {
                        return FileVisitResult.CONTINUE;
                    }

                    fileProcessor(root.relativize(filePath));

                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    protected static int restExchange(String repo, String url) {
        String rep = REST_CLIENT.get(repo, url);

        Gson g = new Gson();
        FileStatistics fm = g.fromJson(rep, FileStatistics.class);

        return fm.getDownloadCount();
    }

    abstract void fileProcessor(Path relativePath);
}
