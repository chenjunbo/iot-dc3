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

package io.github.pnoker.center.auth.biz;

import io.github.pnoker.center.auth.entity.bean.Login;
import io.github.pnoker.center.auth.entity.bo.UserLoginBO;
import io.github.pnoker.common.model.AuthUser;

/**
 * User Manage Service
 *
 * @author linys
 * @since 2022.1.0
 */
public interface AuthService {

    /**
     * 鉴定用户, 并返回token
     *
     * @param login login info
     * @return UserLogin userLogin
     */
    UserLoginBO authenticateUser(Login login);

    /**
     * 用户登录
     *
     * @param login 登录参数
     * @return AuthUser
     */
    AuthUser login(Login login);

    /**
     * 当前用户退出登录
     */
    void logout();
}
