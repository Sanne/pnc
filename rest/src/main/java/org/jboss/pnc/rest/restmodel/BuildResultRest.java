/**
 * JBoss, Home of Professional Open Source.
 * Copyright 2014 Red Hat, Inc., and individual contributors
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

package org.jboss.pnc.rest.restmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.jboss.pnc.spi.BuildResult;
import org.jboss.pnc.spi.builddriver.BuildDriverResult;
import org.jboss.pnc.spi.builddriver.BuildDriverStatus;
import org.jboss.pnc.spi.builddriver.exception.BuildDriverException;
import org.jboss.pnc.spi.executor.exceptions.ExecutorException;
import org.jboss.pnc.spi.repositorymanager.RepositoryManagerResult;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Optional;

/**
 * @author <a href="mailto:matejonnet@gmail.com">Matej Lazar</a>
 */
@XmlRootElement(name = "buildResult")
public class BuildResultRest implements Serializable {

    private BuildDriverResultRest buildDriverResult;

    private RepositoryManagerResultRest repositoryManagerResult;

    private ExecutorException exception;

    public BuildResultRest() {
    }

    public BuildResultRest(BuildResult buildResult) throws BuildDriverException {
        buildResult.getBuildDriverResult().ifPresent((result) -> {
            try {
                buildDriverResult = new BuildDriverResultRest(result);
            } catch (BuildDriverException e) {
                new RuntimeException(e);
            }
        });

        buildResult.getRepositoryManagerResult().ifPresent((result) -> {
            repositoryManagerResult = new RepositoryManagerResultRest(result);
        });

        exception = buildResult.getException().orElse(null);
    }

    public BuildResult toBuildResult() {
        return new BuildResult(
                Optional.ofNullable(buildDriverResult),
                Optional.ofNullable(repositoryManagerResult),
                Optional.ofNullable(exception));
    }

    public BuildDriverResultRest getBuildDriverResult() {
        return buildDriverResult;
    }

    public void setBuildDriverResult(BuildDriverResultRest buildDriverResult) {
        this.buildDriverResult = buildDriverResult;
    }

    public RepositoryManagerResultRest getRepositoryManagerResult() {
        return repositoryManagerResult;
    }

    public void setRepositoryManagerResult(RepositoryManagerResultRest repositoryManagerResult) {
        this.repositoryManagerResult = repositoryManagerResult;
    }

    public ExecutorException getException() {
        return exception;
    }

    public void setException(ExecutorException exception) {
        this.exception = exception;
    }

}
