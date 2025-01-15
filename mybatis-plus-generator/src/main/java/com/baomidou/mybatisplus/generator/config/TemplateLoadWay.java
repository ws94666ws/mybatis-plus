/*
 * Copyright (c) 2011-2025, baomidou (jobob@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.baomidou.mybatisplus.generator.config;

import lombok.Getter;

/**
 * 模板文件加载方式
 *
 * @author hubin
 * @since 3.5.9
 */
@Getter
public enum TemplateLoadWay {
    STRING("string"),
    FILE("file");

    private final String value;

    TemplateLoadWay(String value) {
        this.value = value;
    }

    public boolean isFile() {
        return FILE == this;
    }
}
