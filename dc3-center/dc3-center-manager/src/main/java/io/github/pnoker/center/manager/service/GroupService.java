/*
 * Copyright 2016-present the IoT DC3 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.pnoker.center.manager.service;

import io.github.pnoker.center.manager.entity.model.GroupDO;
import io.github.pnoker.center.manager.entity.query.GroupPageQuery;
import io.github.pnoker.common.base.Service;

/**
 * Group Interface
 *
 * @author pnoker
 * @since 2022.1.0
 */
public interface GroupService extends Service<GroupDO, GroupPageQuery> {
    /**
     * 根据分组 NAME 查询
     *
     * @param name     分组名称
     * @param tenantId 租户ID
     * @return Group
     */
    GroupDO selectByName(String name, Long tenantId);

}
