#!/bin/bash

#
# Copyright 2016-present Pnoker All Rights Reserved
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#      https://www.apache.org/licenses/LICENSE-2.0
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

set -e

echo 'You can use make to execute the following commands:'
echo 'Usage: make [clean | package | deploy | dev | tag]'
echo ' - make clean: mvn clean'
echo ' - make package: mvn package'
echo ' - make deploy: mvn deploy'
echo ' - make tag: git tag'
echo ' - make dev: run development environment'