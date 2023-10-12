/*
 * Copyright (c) 2011-2023, baomidou (jobob@qq.com).
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
package com.baomidou.mybatisplus.core.conditions.interfaces;

import java.io.Serializable;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

/**
 * 查询条件封装
 * <p>比较值</p>
 *
 * @author hubin miemie HCL
 * @since 2017-05-26
 */
public interface Compare<Children, R> extends Serializable {

    /**
     * map 所有非空属性等于 =
     *
     * @param params      map 类型的参数, key 是字段名, value 是字段值
     * @return children
     */
    default <V> Children allEq(Map<R, V> params) {
        return allEq(params, true);
    }

    /**
     * map 所有非空属性等于 =
     *
     * @param params      map 类型的参数, key 是字段名, value 是字段值
     * @param null2IsNull 是否参数为 null 自动执行 isNull 方法, false 则忽略这个字段\
     * @return children
     */
    default <V> Children allEq(Map<R, V> params, boolean null2IsNull) {
        return allEq(true, params, null2IsNull);
    }

    /**
     * map 所有非空属性等于 =
     *
     * @param condition   执行条件
     * @param params      map 类型的参数, key 是字段名, value 是字段值
     * @param null2IsNull 是否参数为 null 自动执行 isNull 方法, false 则忽略这个字段\
     * @return children
     */
    <V> Children allEq(boolean condition, Map<R, V> params, boolean null2IsNull);

    /**
     * 字段过滤接口，传入多参数时允许对参数进行过滤
     *
     * @param filter      返回 true 来允许字段传入比对条件中
     * @param params      map 类型的参数, key 是字段名, value 是字段值
     * @return children
     */
    default <V> Children allEq(BiPredicate<R, V> filter, Map<R, V> params) {
        return allEq(filter, params, true);
    }

    /**
     * 字段过滤接口，传入多参数时允许对参数进行过滤
     *
     * @param filter      返回 true 来允许字段传入比对条件中
     * @param params      map 类型的参数, key 是字段名, value 是字段值
     * @param null2IsNull 是否参数为 null 自动执行 isNull 方法, false 则忽略这个字段
     * @return children
     */
    default <V> Children allEq(BiPredicate<R, V> filter, Map<R, V> params, boolean null2IsNull) {
        return allEq(true, filter, params, null2IsNull);
    }

    /**
     * 字段过滤接口，传入多参数时允许对参数进行过滤
     *
     * @param condition   执行条件
     * @param filter      返回 true 来允许字段传入比对条件中
     * @param params      map 类型的参数, key 是字段名, value 是字段值
     * @param null2IsNull 是否参数为 null 自动执行 isNull 方法, false 则忽略这个字段
     * @return children
     */
    <V> Children allEq(boolean condition, BiPredicate<R, V> filter, Map<R, V> params, boolean null2IsNull);

    /**
     * 等于 =
     *
     * @param column    字段
     * @param val       值
     * @return children
     */
    default Children eq(R column, Object val) {
        return eq(true, column, val);
    }

    /**
     * 等于 =
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     */
    Children eq(boolean condition, R column, Object val);


    /**
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     * @since 3.5.4
     */
    Children eq(boolean condition, R column, Supplier<Object> val);


    /**
     * ignore
     */
    default Children ne(R column, Object val) {
        return ne(true, column, val);
    }

    /**
     * 不等于 &lt;&gt;
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     */
    Children ne(boolean condition, R column, Object val);

    /**
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     * @since 3.5.4
     */
    Children ne(boolean condition, R column, Supplier<Object> val);

    /**
     * ignore
     */
    default Children gt(R column, Object val) {
        return gt(true, column, val);
    }

    /**
     * 大于 &gt;
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     */
    Children gt(boolean condition, R column, Object val);

    /**
     * 大于 &gt;
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     * @since 3.5.4
     */
    Children gt(boolean condition, R column, Supplier<Object> val);

    /**
     * 大于等于 &gt;=
     *
     * @param column 字段
     * @param val    值
     * @return children
     */
    default Children ge(R column, Object val) {
        return ge(true, column, val);
    }

    /**
     * 大于等于 &gt;=
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     */
    Children ge(boolean condition, R column, Object val);

    /**
     * 大于等于 &gt;=
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     * @since 3.5.4
     */
    Children ge(boolean condition, R column, Supplier<Object> val);

    /**
     * 小于 &lt;
     *
     * @param column    字段
     * @param val       值
     * @return children
     */
    default Children lt(R column, Object val) {
        return lt(true, column, val);
    }

    /**
     * 小于 &lt;
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     */
    Children lt(boolean condition, R column, Object val);

    /**
     * 小于 &lt;
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     * @since 3.5.4
     */
    Children lt(boolean condition, R column, Supplier<Object> val);

    /**
     * 小于等于 &lt;=
     *
     * @param column    字段
     * @param val       值
     * @return children
     */
    default Children le(R column, Object val) {
        return le(true, column, val);
    }

    /**
     * 小于等于 &lt;=
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     */
    Children le(boolean condition, R column, Object val);


    /**
     * 小于等于 &lt;=
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     * @since 3.5.4
     */
    Children le(boolean condition, R column, Supplier<Object> val);

    /**
     * BETWEEN 值1 AND 值2
     *
     * @param column    字段
     * @param val1      值1
     * @param val2      值2
     * @return children
     */
    default Children between(R column, Object val1, Object val2) {
        return between(true, column, val1, val2);
    }

    /**
     * BETWEEN 值1 AND 值2
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val1      值1
     * @param val2      值2
     * @return children
     */
    Children between(boolean condition, R column, Object val1, Object val2);

    /**
     * BETWEEN 值1 AND 值2
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val1      值1
     * @param val2      值2
     * @return children
     * @since 3.5.4
     */
    Children between(boolean condition, R column, Supplier<Object> val1, Supplier<Object> val2);

    /**
     * NOT BETWEEN 值1 AND 值2
     *
     * @param column    字段
     * @param val1      值1
     * @param val2      值2
     * @return children
     */
    default Children notBetween(R column, Object val1, Object val2) {
        return notBetween(true, column, val1, val2);
    }

    /**
     * NOT BETWEEN 值1 AND 值2
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val1      值1
     * @param val2      值2
     * @return children
     */
    Children notBetween(boolean condition, R column, Object val1, Object val2);

    /**
     * NOT BETWEEN 值1 AND 值2
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val1      值1
     * @param val2      值2
     * @return children
     * @since 3.5.4
     */
    Children notBetween(boolean condition, R column, Supplier<Object> val1, Supplier<Object> val2);

    /**
     * LIKE '%值%'
     *
     * @param column    字段
     * @param val       值
     * @return children
     */
    default Children like(R column, Object val) {
        return like(true, column, val);
    }

    /**
     * LIKE '%值%'
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     */
    Children like(boolean condition, R column, Object val);

    /**
     * LIKE '%值%'
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     * @since 3.5.4
     */
    Children like(boolean condition, R column, Supplier<Object> val);

    /**
     * NOT LIKE '%值%'
     *
     * @param column    字段
     * @param val       值
     * @return children
     */
    default Children notLike(R column, Object val) {
        return notLike(true, column, val);
    }

    /**
     * NOT LIKE '%值%'
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     */
    Children notLike(boolean condition, R column, Object val);

    /**
     * NOT LIKE '%值%'
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     * @since 3.5.4
     */
    Children notLike(boolean condition, R column, Supplier<Object> val);


    /**
     * NOT LIKE '%值'
     *
     * @param column 字段
     * @param val 值
     * @return children
     */
    default Children notLikeLeft(R column, Object val) {
        return notLikeLeft(true, column, val);
    }

    /**
     * NOT LIKE '%值'
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     */
    Children notLikeLeft(boolean condition, R column, Object val);


    /**
     * NOT LIKE '%值'
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     * @since 3.5.4
     */
    Children notLikeLeft(boolean condition, R column, Supplier<Object> val);

    /**
     * NOT LIKE '值%'
     *
     * @param column 字段
     * @param val 值
     * @return children
     */
    default Children notLikeRight(R column, Object val) {
        return notLikeRight(true, column, val);
    }

    /**
     * NOT LIKE '值%'
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     */
    Children notLikeRight(boolean condition, R column, Object val);

    /**
     * NOT LIKE '值%'
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     * @since 3.5.4
     */
    Children notLikeRight(boolean condition, R column, Supplier<Object> val);

    /**
     * LIKE '%值'
     *
     * @param column    字段
     * @param val       值
     * @return children
     */
    default Children likeLeft(R column, Object val) {
        return likeLeft(true, column, val);
    }

    /**
     * LIKE '%值'
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     */
    Children likeLeft(boolean condition, R column, Object val);

    /**
     * LIKE '%值'
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     * @since 3.5.4
     */
    Children likeLeft(boolean condition, R column, Supplier<Object> val);

    /**
     * LIKE '值%'
     *
     * @param column    字段
     * @param val       值
     * @return children
     */
    default Children likeRight(R column, Object val) {
        return likeRight(true, column, val);
    }

    /**
     * LIKE '值%'
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     */
    Children likeRight(boolean condition, R column, Object val);

    /**
     * LIKE '值%'
     *
     * @param condition 执行条件
     * @param column    字段
     * @param val       值
     * @return children
     * @since 3.5.4
     */
    Children likeRight(boolean condition, R column, Supplier<Object> val);
}
