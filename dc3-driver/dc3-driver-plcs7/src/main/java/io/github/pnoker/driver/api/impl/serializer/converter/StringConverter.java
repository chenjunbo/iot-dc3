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

import io.github.pnoker.common.utils.DecodeUtil;
import io.github.pnoker.driver.api.S7Serializable;
import io.github.pnoker.driver.api.S7Type;

public final class StringConverter implements S7Serializable {

    private static final int OFFSET_CURRENT_LENGTH = 1;
    private static final int OFFSET_OVERALL_LENGTH = 0;
    private static final int OFFSET_START = 2;

    @Override
    public <T> T extract(final Class<T> targetClass, final byte[] buffer, final int byteOffset, final int bitOffset) {
        final int len = buffer[byteOffset + OFFSET_CURRENT_LENGTH] & 0xFF;

        return targetClass.cast(new String(buffer, byteOffset + OFFSET_START, len));
    }

    @Override
    public S7Type getS7Type() {
        return S7Type.STRING;
    }

    @Override
    public int getSizeInBits() {
        // Not static
        return 0;
    }

    @Override
    public int getSizeInBytes() {
        // Not static
        return 2; // 2 bytes overhead
    }

    @Override
    public void insert(final Object javaType, final byte[] buffer, final int byteOffset, final int bitOffset,
                       final int size) {
        final String value = (String) javaType;

        final int len = value.length();

        if (len > size) {
            throw new IllegalArgumentException("String to big: " + len);
        }

        buffer[byteOffset + OFFSET_OVERALL_LENGTH] = (byte) size;
        buffer[byteOffset + OFFSET_CURRENT_LENGTH] = (byte) len;

        final byte[] strBytes = DecodeUtil.stringToByte(value);
        System.arraycopy(strBytes, 0, buffer, byteOffset + OFFSET_START, len);
    }

}
