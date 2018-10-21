package com.arch.gradle.dependencies.model;


import org.apache.commons.lang.StringUtils;

/**
 * The data model of artifact.
 *
 * @author antony.zhao@chase.com; yuechao.zhao@dieboldnixdorf.com
 * @since Oct, 2018
 */
public class Artifact {

    private String groupId;

    private String artifactId;

    private String version;

    private String overVersion;

    private String override;

    private String duplicate;

    private String checkSum;

    private String fileName;

    public Artifact() {
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        if (!(StringUtils.isBlank(getOverVersion()) ^ isOverride())) {
            System.out.println("error! do something.");
        }
        return StringUtils.isBlank(getOverVersion()) ? this.version : this.overVersion;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setOverVersion(String overVersion) {
        this.overVersion = overVersion;
    }

    public String getOverVersion() {
        return overVersion;
    }

    public String getOverride() {
        return override;
    }

    public void setOverride(String override) {
        this.override = override;
    }

    public String getDuplicate() {
        return duplicate;
    }

    public void setDuplicate(String duplicate) {
        this.duplicate = duplicate;
    }

    public String getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(String checkSum) {
        this.checkSum = checkSum;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Boolean isOverride() {
        return StringUtils.contains(getOverride(), "->");
    }

    public Boolean isDuplicate() {
        return StringUtils.contains(getDuplicate(), "(*)");
    }

    public Boolean isInternal() {
        return StringUtils.contains(getGroupId(), "dieboldnixdorf") || StringUtils.contains(getGroupId(), "wincornixdorf");
    }

    public String getFullMapKey() {
        return this.getGroupId() + ":" + getArtifactId() + ":" + getVersion();
    }
}