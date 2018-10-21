package com.arch.gradle.dependencies.analyzer;

import com.arch.gradle.dependencies.model.Artifact;
import com.arch.gradle.dependencies.util.ArtifactBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.regex.Pattern;

/**
 * Gradle cache artifact path: "org.eclipse.jetty/jetty-ajp/7.0.2.v20100331/2213868122782307bd35a187a7717100c8f43b78/jetty-ajp-7.0.2.v20100331.jar"
 * Normal Maven artifact path: "org/eclipse/jetty/jetty-ajp/7.0.2.v20100331/jetty-ajp-7.0.2.v20100331.jar"
 * <p>
 * This transformer transforms the gradle-cache libraries into Maven standard repository libraries.
 * The maven libraries could be uploaded to Artifactory for TM build process.
 * More information about standard orgPath of repository layout, see https://www.jfrog.com/confluence/display/RTF/Repository+Layouts
 *
 * @author antony.zhao@chase.com; yuechao.zhao@dieboldnixdorf.com
 * @since Oct, 2018
 */
public class GradleCacheTransformer {

    private static final String DIR_USER_HOME = System.getProperty("user.home");

    private static final String INPUT = DIR_USER_HOME + GradleCacheAnalyzer.DIR_GRADLE_CACHE;

    private static final String OUTPUT = "out/libraries";

    public static void main(String[] args) throws IOException {
        clsDir();
        pathReader();
    }

    private static void clsDir() throws IOException {
        Path toDelete = Paths.get(OUTPUT);

        if (Files.notExists(toDelete)) {
            return;
        }

        Files.walk(toDelete)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);

        Files.createDirectory(Paths.get(OUTPUT));
    }

    private static void pathReader() throws IOException {
        Path rootPath = Paths.get(INPUT);

        Files.walkFileTree(rootPath, EnumSet.noneOf(FileVisitOption.class), 3, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                if (attrs.isDirectory()) {
                    pathProcessor(path);
                }
                return FileVisitResult.CONTINUE;
            }
        });

    }

    private static void pathProcessor(Path artifactPath) throws IOException {
        Path outputArtifactPath = pathChecker(artifactPath);

        fileProcessor(artifactPath, outputArtifactPath);
    }

    private static Path pathChecker(Path artifactPath) throws IOException {
        Path relativeArtifactPath = Paths.get(INPUT).relativize(artifactPath);

        Artifact art = ArtifactBuilder.buildFromGradleCacheDir(relativeArtifactPath);
        String[] orgPath = art.getGroupId().split(Pattern.quote(".")); // Apply orgPath in Repository layout. See https://www.jfrog.com/confluence/display/RTF/Repository+Layouts

        if (orgPath.length == 0) {
            return Files.createDirectories(Paths.get(OUTPUT, art.getGroupId(), art.getArtifactId(), art.getVersion()));
        } else {
            Path outputPath = Paths.get(OUTPUT);

            for (String dir : orgPath) {
                outputPath = Files.createDirectories(Paths.get(outputPath.toString(), dir));
            }
            return Files.createDirectories(Paths.get(outputPath.toString(), art.getArtifactId(), art.getVersion()));
        }
    }

    private static void fileProcessor(Path artifactPath, Path outputArtifactPath) throws IOException {
        Files.walkFileTree(artifactPath, EnumSet.noneOf(FileVisitOption.class), 10, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs) throws IOException {
                if (attrs.isRegularFile()) {
                    Path outputPath = getOutputPath(filePath, outputArtifactPath);
                    Files.copy(filePath, outputPath);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static Path getOutputPath(Path filePath, Path outputArtifactPath) {
        return Paths.get(outputArtifactPath.toString(), filePath.getName(filePath.getNameCount() - 1).toString());
    }
}
