/*
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
'use strict';

(function() {

  var module = angular.module('pnc.common.restclient');

  module.value('BUILDS_ENDPOINT', '/builds/:id');

  /**
   * @author Alex Creasy
   */
  module.factory('BuildsDAO', [
    '$resource',
    'REST_BASE_URL',
    'BUILDS_ENDPOINT',
    'PageFactory',
    'QueryHelper',
    function($resource, REST_BASE_URL, BUILDS_ENDPOINT, PageFactory, qh) {
      var ENDPOINT = REST_BASE_URL + BUILDS_ENDPOINT;

      var resource = $resource(ENDPOINT, {}, {
        _getAll: {
          method: 'GET',
          url: ENDPOINT + qh.searchOnly(['user.username'])
        },
        _getByConfiguration: {
          method: 'GET',
          url: REST_BASE_URL + '/builds?q=buildConfigurationId==:id'
        },
        _getLastByConfiguration: {
          method: 'GET',
          url: REST_BASE_URL + '/builds?q=buildConfigurationId==:id&pageIndex=0&pageSize=1'
        }
      });

      PageFactory.decorate(resource, '_getAll', 'getPaged');
      PageFactory.decorate(resource, '_getByConfiguration', 'getByConfiguration');
      PageFactory.decorate(resource, '_getLastByConfiguration', 'getLastByConfiguration');

      return resource;
    }

  ]);


})();
