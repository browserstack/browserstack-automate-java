package com.browserstack.automate.model;

import com.browserstack.automate.Automate.SessionStatus;
import com.browserstack.automate.AutomateClient;
import com.browserstack.automate.exception.AutomateException;
import com.browserstack.automate.exception.SessionNotFound;
import com.browserstack.client.BrowserStackClient;
import com.browserstack.client.model.BrowserStackObject;
import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Session extends BrowserStackObject {

    @JsonProperty("hashed_id")
    private String id;

    @JsonProperty("build_name")
    private String buildName;

    @JsonProperty("browser")
    private String browser;

    @JsonProperty("browser_version")
    private String browserVersion;

    @JsonProperty("os")
    private String os;

    @JsonProperty("os_version")
    private String osVersion;

    @JsonProperty("device")
    private String device;

    @JsonProperty("browser_url")
    private String browserUrl;

    @JsonProperty("public_url")
    private String publicUrl;

    @JsonProperty("video_url")
    private String videoUrl;

    @JsonProperty("logs")
    private String logUrl;

    @JsonProperty("project_name")
    private String projectName;

    @JsonProperty("status")
    private String status;

    @JsonProperty("reason")
    private String reason;

    @JsonProperty("duration")
    private Integer duration;

    @JsonProperty("name")
    private String name;

    @JsonProperty("browser_console_logs_url")
    private String browser_console_logs_url;

    @JsonProperty("har_logs_url")
    private String har_logs_url;

    @JsonProperty("appium_logs_url")
    private String appium_logs_url;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Session() {

    }

    public Session(BrowserStackClient client, String sessionId) {
        setClient(client);
        this.id = sessionId;
    }

    public final boolean delete() throws SessionNotFound, AutomateException {
        return ((AutomateClient) getClient()).deleteSession(getId());
    }

    public final Session updateStatus(final SessionStatus sessionStatus,
                                      final String reason) throws SessionNotFound, AutomateException {
        Session session = ((AutomateClient) getClient()).updateSessionStatus(getId(), sessionStatus, reason);
        if (session != null) {
            copyFrom(session);
        }

        return this;
    }

    public final Session updateStatus(final SessionStatus sessionStatus) throws SessionNotFound, AutomateException {
        return updateStatus(sessionStatus, null);
    }

    public final String getLogs() throws AutomateException {
        if (logUrl == null) {
            throw new AutomateException("Session logs not found", 404);
        }

        return ((AutomateClient) getClient()).getSessionLogs(this);
    }

    public final String getConsoleLogs() throws AutomateException {
        if (browser_console_logs_url == null) {
            throw new AutomateException("Session logs not found", 404);
        }

        return ((AutomateClient) getClient()).getSessionConsoleLogs(this);
    }

    public final String getHARLogs() throws AutomateException {
        if (logUrl == null) {
            throw new AutomateException("Session logs not found", 404);
        }

        return ((AutomateClient) getClient()).getSessionHARLogs(this);
    }

    public final String getAppiumLogs() throws AutomateException {
        if (logUrl == null) {
            throw new AutomateException("Session logs not found", 404);
        }

        return ((AutomateClient) getClient()).getSessionAppiumLogs(this);
    }

    /**
     * @return The id
     */
    @JsonProperty("hashed_id")
    public String getId() {
        return id;
    }

    /**
     * @param id The hashed_id
     */
    @JsonProperty("hashed_id")
    private void setId(String id) {
        this.id = id;
    }

    /**
     * @return The buildName
     */
    @JsonProperty("build_name")
    private String getBuildName() {
        return buildName;
    }

    /**
     * @param buildName The build_name
     */
    @JsonProperty("build_name")
    private void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    /**
     * @return The browser
     */
    @JsonProperty("browser")
    public String getBrowser() {
        return browser;
    }

    /**
     * @param browser The browser
     */
    @JsonProperty("browser")
    private void setBrowser(String browser) {
        this.browser = browser;
    }

    /**
     * @return The browserUrl
     */
    @JsonProperty("browser_url")
    public String getBrowserUrl() {
        return browserUrl;
    }

    /**
     * @param browserUrl The browser_url
     */
    @JsonProperty("browser_url")
    private void setBrowserUrl(String browserUrl) {
        this.browserUrl = browserUrl;
    }

    /**
     * @return The publicUrl
     */
    @JsonProperty("public_url")
    public String getPublicUrl() {
        return publicUrl;
    }

    /**
     * @param publicUrl The publicUrl
     */
    @JsonProperty("public_url")
    private void setPublicUrl(String publicUrl) {
        this.publicUrl = publicUrl;
    }

    /**
     * @return The videoUrl
     */
    @JsonProperty("video_url")
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * @param videoUrl The video_url
     */
    @JsonProperty("video_url")
    private void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    /**
     * @return The logs
     */
    @JsonProperty("logs")
    public String getLogUrl() {
        return logUrl;
    }

    /**
     * @param logUrl The logUrl
     */
    @JsonProperty("logs")
    private void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    /**
     * @return The projectName
     */
    @JsonProperty("project_name")
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName The project_name
     */
    @JsonProperty("project_name")
    private void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * @return The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    @JsonProperty("status")
    private void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return The browserVersion
     */
    @JsonProperty("browser_version")
    public String getBrowserVersion() {
        return browserVersion;
    }

    /**
     * @param browserVersion The browser_version
     */
    @JsonProperty("browser_version")
    private void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    /**
     * @return The osVersion
     */
    @JsonProperty("os_version")
    public String getOsVersion() {
        return osVersion;
    }

    /**
     * @param osVersion The os_version
     */
    @JsonProperty("os_version")
    private void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    /**
     * @return The reason
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * @param reason The reason
     */
    @JsonProperty("reason")
    private void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return The duration
     */
    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }

    /**
     * @param duration The duration
     */
    @JsonProperty("duration")
    private void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * @return The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    @JsonProperty("name")
    private void setName(String name) {
        this.name = name;
    }

    /**
     * @return The device
     */
    @JsonProperty("device")
    public String getDevice() {
        return device;
    }

    /**
     * @param device The device
     */
    @JsonProperty("device")
    private void setDevice(String device) {
        this.device = device;
    }

    /**
     * @return The os
     */
    @JsonProperty("os")
    public String getOs() {
        return os;
    }

    /**
     * @param os The os
     */
    @JsonProperty("os")
    private void setOs(String os) {
        this.os = os;
    }

    /**
     * @return The browser_console_logs_url
     */
    @JsonProperty("browser_console_logs_url")
    public String getBrowser_console_logs_url() {
        return browser_console_logs_url;
    }

    /**
     * @param browser_console_logs_url The browser_console_logs_url
     */
    @JsonProperty("browser_console_logs_url")
    private void setBrowser_console_logs_url(String browser_console_logs_url) {
        this.browser_console_logs_url = browser_console_logs_url;
    }

    /**
     * @return The har_logs_url
     */
    @JsonProperty("har_logs_url")
    public String getHar_logs_url() {
        return har_logs_url;
    }

    /**
     * @param har_logs_url The har_logs_url
     */
    @JsonProperty("har_logs_url")
    private void setHar_logs_url(String har_logs_url) {
        this.har_logs_url = har_logs_url;
    }

    /**
     * @return The appium_logs_url
     */
    @JsonProperty("appium_logs_url")
    public String getAppium_logs_url() {
        return appium_logs_url;
    }

    /**
     * @param appium_logs_url The appium_logs_url
     */
    @JsonProperty("appium_logs_url")
    private void setAppium_logs_url(String appium_logs_url) {
        this.appium_logs_url = appium_logs_url;
    }

    @JsonAnyGetter
    protected Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    private void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    private boolean copyFrom(Session s) {
        if (s != null) {
            setName(s.getName());
            setProjectName(s.getProjectName());
            setBuildName(s.getBuildName());
            setOs(s.getOs());
            setOsVersion(s.getOsVersion());
            setBrowser(s.getBrowser());
            setBrowserVersion(s.getBrowserVersion());
            setDevice(s.getDevice());
            setBrowserUrl(s.getBrowserUrl());
            setDuration(s.getDuration());
            setLogUrl(s.getLogUrl());
            setStatus(s.getStatus());
            setReason(s.getReason());
            setBrowser_console_logs_url(s.getBrowser_console_logs_url());
            setHar_logs_url(s.getHar_logs_url());
            setAppium_logs_url(s.getAppium_logs_url());
            this.additionalProperties = s.getAdditionalProperties();
            return true;
        }

        return false;
    }
}