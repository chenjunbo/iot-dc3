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
package io.github.pnoker.driver.api.impl.serializer.converter;

import io.github.pnoker.driver.api.S7Serializable;
import io.github.pnoker.driver.api.S7Type;

/**
 * The Class BitConverter is responsible for converting bit values
 */
public final class BitConverter implements S7Serializable {


    @Override
    public <T> T extract(final Class<T> targetClass, final byte[] buffer, final int byteOffset, final int bitOffset) {
        final byte bufValue = buffer[byteOffset];
        return targetClass.cast(bufValue == (bufValue | (0x01 << bitOffset)));
    }


    @Override
    public S7Type getS7Type() {
        return S7Type.BOOL;
    }


    @Override
    public int getSizeInBits() {
        return 1;
    }


    @Override
    public int getSizeInBytes() {
        return 0;
    }


    @Override
    public void insert(final Object javaType, final byte[] buffer, final int byteOffset, final int bitOffset,
                       final int size) {
        final Boolean value = (Boolean) javaType;

        //thx to @mfriedemann (https://github.com/mfriedemann)
        if (value) {
            buffer[byteOffset] |= (0x01 << bitOffset);
        } else {
            buffer[byteOffset] &= ~(0x01 << bitOffset);
        }
    }

}
