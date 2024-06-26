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

package io.github.pnoker.center.auth.dal.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.pnoker.center.auth.dal.DriverTokenManager;
import io.github.pnoker.center.auth.entity.model.DriverTokenDO;
import io.github.pnoker.center.auth.mapper.DriverTokenMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 驱动令牌表 服务实现类
 * </p>
 *
 * @author pnoker
 * @since 2022.1.0
 */
@Service
public class DriverTokenManagerImpl extends ServiceImpl<DriverTokenMapper, DriverTokenDO> implements DriverTokenManager {

}
