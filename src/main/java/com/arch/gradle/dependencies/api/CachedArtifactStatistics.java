package com.arch.gradle.dependencies.api;

import com.arch.gradle.dependencies.model.Artifact;
import com.arch.gradle.dependencies.util.ArtifactBuilder;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

/**
 * Get the External artifacts which have been downloaded.
 */
public class CachedArtifactStatistics extends ArtifactStatistics {

    public static final Map<String, Integer> mapDownLoadStats = new TreeMap<>();

    public static final String EXT_REPO = "tm-local/";

    public static void main(String[] args) throws IOException {

        CachedArtifactStatistics eas = new CachedArtifactStatistics();

        eas.pathProcessor(Paths.get(ArtifactStatistics.INPUT));

        System.out.println(mapDownLoadStats);
    }

    @Override
    public void fileProcessor(Path relativePath) {
        Artifact art = ArtifactBuilder.buildFromGradleCacheFile(relativePath);

        int downloadCount = restExchange(EXT_REPO, ArtifactBuilder.buildRemoteURLFromMavenPath(art));

        mapDownLoadStats.compute(art.getFullMapKey(), (key, value) -> value == null ? downloadCount : value + downloadCount);
    }
}
