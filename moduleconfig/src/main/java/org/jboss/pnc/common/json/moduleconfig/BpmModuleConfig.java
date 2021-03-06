/**
 * JBoss, Home of Professional Open Source.
 * Copyright 2014-2020 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.pnc.common.json.moduleconfig;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import org.jboss.pnc.common.json.AbstractModuleConfig;

import java.net.MalformedURLException;

@ToString
public class BpmModuleConfig extends AbstractModuleConfig {

    /**
     * Username to authenticate against remote BPM server for build signal callbacks
     */
    private String username;

    /**
     * Password to authenticate against remote BPM server for build signal callbacks
     */
    private String password;

    private String bpmInstanceUrl;
    private final String pncBaseUrl;
    private final String jenkinsBaseUrl;
    private final String aproxBaseUrl;
    private final String repourBaseUrl;
    private final String daBaseUrl;
    private final String causewayBaseUrl;
    private String deploymentId;
    private String componentBuildProcessId;
    private String releaseProcessId;
    private String bcCreationProcessId;
    private String communityBuild;
    private String versionAdjust;

    @Getter
    private int httpConnectionRequestTimeout;

    @Getter
    private int httpConnectTimeout;

    @Getter
    private int httpSocketTimeout;

    @Getter
    private final String bpmNewBaseUrl;

    @Getter
    private final String bpmNewDeploymentId;

    @Getter
    private final String bpmNewBuildProcessName;

    @Getter
    private final String bpmNewUsername;

    @Getter
    private final String bpmNewPassword;

    public BpmModuleConfig(
            @JsonProperty("username") String username,
            @JsonProperty("password") String password,
            @JsonProperty("bpmInstanceUrl") String bpmInstanceUrl,
            @JsonProperty("deploymentId") String deploymentId,
            @JsonProperty("componentBuildProcessId") String componentBuildProcessId,
            @JsonProperty("releaseProcessId") String releaseProcessId,
            @JsonProperty("bcCreationProcessId") String bcCreationProcessId,
            @JsonProperty("pncBaseUrl") String pncBaseUrl,
            @JsonProperty("jenkinsBaseUrl") String jenkinsBaseUrl,
            @JsonProperty("aproxBaseUrl") String aproxBaseUrl,
            @JsonProperty("repourBaseUrl") String repourBaseUrl,
            @JsonProperty("causewayBaseUrl") String causewayBaseUrl,
            @JsonProperty("daBaseUrl") String daBaseUrl,
            @JsonProperty("communityBuild") String communityBuild,
            @JsonProperty("versionAdjust") String versionAdjust,
            @JsonProperty("connectionRequestTimeout") Integer httpConnectionRequestTimeout,
            @JsonProperty("connectTimeout") Integer httpConnectTimeout,
            @JsonProperty("socketTimeout") Integer httpSocketTimeout,
            @JsonProperty("bpmNewBaseUrl") String bpmNewBaseUrl,
            @JsonProperty("bpmNewDeploymentId") String bpmNewDeploymentId,
            @JsonProperty("bpmNewBuildProcessName") String bpmNewBuildProcessName,
            @JsonProperty("bpmNewUsername") String bpmNewUsername,
            @JsonProperty("bpmNewPassword") String bpmNewPassword) throws MalformedURLException {
        this.username = username;
        this.password = password;
        this.deploymentId = deploymentId;
        this.componentBuildProcessId = componentBuildProcessId;
        this.releaseProcessId = releaseProcessId;
        this.bcCreationProcessId = bcCreationProcessId;
        this.bpmInstanceUrl = bpmInstanceUrl;
        this.pncBaseUrl = pncBaseUrl;
        this.jenkinsBaseUrl = jenkinsBaseUrl;
        this.aproxBaseUrl = aproxBaseUrl;
        this.repourBaseUrl = repourBaseUrl;
        this.daBaseUrl = daBaseUrl;
        this.causewayBaseUrl = causewayBaseUrl;
        this.communityBuild = communityBuild;
        this.versionAdjust = versionAdjust;
        if (httpConnectionRequestTimeout == null) {
            this.httpConnectionRequestTimeout = 5000; // default to 5 sec
        } else {
            this.httpConnectionRequestTimeout = httpConnectionRequestTimeout;
        }
        if (httpConnectTimeout == null) {
            this.httpConnectTimeout = 5000; // default to 5 sec
        } else {
            this.httpConnectTimeout = httpConnectTimeout;
        }
        if (httpSocketTimeout == null) {
            this.httpSocketTimeout = 5000; // default to 5 sec
        } else {
            this.httpSocketTimeout = httpSocketTimeout;
        }
        this.bpmNewBaseUrl = bpmNewBaseUrl;
        this.bpmNewDeploymentId = bpmNewDeploymentId;
        this.bpmNewBuildProcessName = bpmNewBuildProcessName;
        this.bpmNewUsername = bpmNewUsername;
        this.bpmNewPassword = bpmNewPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBpmInstanceUrl() {
        return bpmInstanceUrl;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public String getComponentBuildProcessId() {
        return componentBuildProcessId;
    }

    public String getBcCreationProcessId() {
        return bcCreationProcessId;
    }

    public String getMilestoneReleaseProcessId() {
        return releaseProcessId;
    }

    public String getPncBaseUrl() {
        return pncBaseUrl;
    }

    public String getJenkinsBaseUrl() {
        return jenkinsBaseUrl;
    }

    public String getAproxBaseUrl() {
        return aproxBaseUrl;
    }

    public String getRepourBaseUrl() {
        return repourBaseUrl;
    }

    public String getDaBaseUrl() {
        return daBaseUrl;
    }

    public String getCommunityBuild() {
        return communityBuild;
    }

    public String getVersionAdjust() {
        return versionAdjust;
    }

    public String getCausewayBaseUrl() {
        return causewayBaseUrl;
    }

}
