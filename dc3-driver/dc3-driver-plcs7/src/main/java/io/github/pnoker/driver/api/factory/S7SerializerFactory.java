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
package io.github.pnoker.driver.api.factory;

import io.github.pnoker.common.constant.common.ExceptionConstant;
import io.github.pnoker.driver.api.S7Connector;
import io.github.pnoker.driver.api.S7Serializer;
import io.github.pnoker.driver.api.impl.serializer.S7SerializerImpl;

/**
 * S7 Serializer factory
 *
 * @author Thomas Rudin
 */
public class S7SerializerFactory {

    private S7SerializerFactory() {
        throw new IllegalStateException(ExceptionConstant.UTILITY_CLASS);
    }

    /**
     * Builds a new serializer with given connector
     *
     * @param connector the connector to use
     * @return a serializer instance
     */
    public static S7Serializer buildSerializer(final S7Connector connector) {
        return new S7SerializerImpl(connector);
    }

}
