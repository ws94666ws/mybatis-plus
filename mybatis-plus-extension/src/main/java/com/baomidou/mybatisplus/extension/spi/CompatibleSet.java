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
package com.baomidou.mybatisplus.extension.spi;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.InputStream;
import java.util.function.Consumer;

/**
 * Web 开发平台待兼容方法集接口类
 */
public interface CompatibleSet {

    SqlSession getSqlSession(SqlSessionFactory sessionFactory);

    void closeSqlSession(SqlSession session, SqlSessionFactory sessionFactory);

    boolean executeBatch(SqlSessionFactory sqlSessionFactory, Log log, Consumer<SqlSession> consumer);

    InputStream getInputStream(String path) throws Exception;

}
