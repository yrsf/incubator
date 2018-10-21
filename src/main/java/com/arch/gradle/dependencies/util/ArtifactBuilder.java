package com.arch.gradle.dependencies.util;

import com.arch.gradle.dependencies.model.Artifact;
import org.springframework.web.util.UriBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArtifactBuilder {

    /**
     * cache dir - group\artifactId\version
     * example
     * aopalliance\aopalliance\1.0
     */
    public static Artifact buildFromGradleCacheDir(Path cacheDir) {

        final String regex = "(.+)\\\\(.+)\\\\(.+)";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher m = pattern.matcher(cacheDir.toString());

        if (!m.find()) {
            System.out.println(MessageFormat.format("Path {1} not matched", cacheDir.toString()));
            return null;
        }

        Artifact art = new Artifact();
        art.setGroupId(m.group(1));
        art.setArtifactId(m.group(2));
        art.setVersion(m.group(3));

        return art;
    }

    /**
     * cache file - group\artifactId\version\checksum\name.jar
     * example
     * aopalliance\aopalliance\1.0\235ba8b489512805ac13a8f9ea77a1ca5ebe3e8\aopalliance-1.0.jar
     */
    public static Artifact buildFromGradleCacheFile(Path cacheFile) {

        final String regex = "(.+)\\\\(.+)\\\\(.+)\\\\(.+)\\\\(.+)";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher m = pattern.matcher(cacheFile.toString());

        if (!m.find()) {
            System.out.println(MessageFormat.format("Path {1} not matched", cacheFile.toString()));
            return null;
        }

        Artifact art = new Artifact();
        art.setGroupId(m.group(1));
        art.setArtifactId(m.group(2));
        art.setVersion(m.group(3));
        art.setCheckSum(m.group(4));
        art.setFileName(m.group(5));

        return art;
    }

    public static Path removeChecksumFromGradleCachePath (Path from){
        Artifact artifact = buildFromGradleCacheFile(from);
        return Paths.get(artifact.getGroupId(), artifact.getArtifactId(), artifact.getVersion(), artifact.getFileName());
    }

    /**
     * @param mavenPath "org/eclipse/jetty/jetty-ajp/7.0.2.v20100331/jetty-ajp-7.0.2.v20100331.jar"
     */
    public static Artifact buildFromMavenPath(Path mavenPath) {

        Artifact art = new Artifact();

        art.setArtifactId(mavenPath.getName(mavenPath.getNameCount() - 3).toString());
        art.setVersion(mavenPath.getName(mavenPath.getNameCount() - 2).toString());
        art.setFileName(mavenPath.getName(mavenPath.getNameCount() - 1).toString());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mavenPath.getNameCount() - 3; i++) {
            sb.append(mavenPath.getName(i)).append(".");
        }
        art.setGroupId(sb.deleteCharAt(sb.length() - 1).toString());

        return art;
    }

    public static Path buildMavenFileFromGradleCachedFile (Path gradleCachedFile){

        Artifact art = ArtifactBuilder.buildFromGradleCacheFile(gradleCachedFile);

        String[] orgPath = art.getGroupId().split(Pattern.quote(".")); // Apply orgPath in Repository layout. See https://www.jfrog.com/confluence/display/RTF/Repository+Layouts

        if (orgPath.length == 0) {
            return Paths.get(art.getGroupId(), art.getArtifactId(),art.getVersion(),art.getFileName());
        } else {

            Path groupPath = null;
            for (String dir : orgPath) {
                groupPath =Paths.get(groupPath.toString(), dir);
            }
            return Paths.get(groupPath.toString(), art.getArtifactId(),art.getVersion(),art.getFileName());
        }
    }

    public static String buildRemoteURLFromMavenPath(Artifact art) {
        return Paths.get(art.getGroupId().replaceAll("\\.", "\\"), art.getArtifactId(), art.getVersion(), art.getFileName()).toString().replaceAll("\\\\", "/");
    }
}
