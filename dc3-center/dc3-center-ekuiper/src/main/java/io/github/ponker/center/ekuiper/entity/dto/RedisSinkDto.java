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

package io.github.ponker.center.ekuiper.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author : Zhen
 */
@Data
public class RedisSinkDto {

    @NotBlank
    private String format;

    private Boolean sendSingle;

    private Boolean omitIfEmpty;

    @NotBlank
    private String addr;

    private String key;

    private String dataType;

    private Integer db;

    private Integer expiration;

    @JsonProperty("rowkindField")
    private String rowkindField;

    @JsonProperty("password")
    private String password;

    private String field;

    private String keyType;

//    @JsonProperty("resourceId")
//    private String resourceId;

}
