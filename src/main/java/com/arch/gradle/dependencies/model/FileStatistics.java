package com.arch.gradle.dependencies.model;

/**
 * The data model of file metric in the open source repository of Artifactory.
 * More information about this data model, see https://www.jfrog.com/confluence/display/RTF/Artifactory+REST+API#ArtifactoryRESTAPI-FileStatistics
 *
 * @author antony.zhao@chase.com; yuechao.zhao@dieboldnixdorf.com
 * @since Oct, 2018
 */
public class FileStatistics {

    private String uri;

    private int downloadCount;

    private String lastDownloaded;

    private int remoteDownloadCount;

    private String remoteLastDownloaded;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public String getLastDownloaded() {
        return lastDownloaded;
    }

    public void setLastDownloaded(String lastDownloaded) {
        this.lastDownloaded = lastDownloaded;
    }

    public int getRemoteDownloadCount() {
        return remoteDownloadCount;
    }

    public void setRemoteDownloadCount(int remoteDownloadCount) {
        this.remoteDownloadCount = remoteDownloadCount;
    }

    public String getRemoteLastDownloaded() {
        return remoteLastDownloaded;
    }

    public void setRemoteLastDownloaded(String remoteLastDownloaded) {
        this.remoteLastDownloaded = remoteLastDownloaded;
    }
}
