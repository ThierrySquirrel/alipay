/**
 * Copyright 2026/6/1 ThierrySquirrel
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/

package io.github.thierrysquirrel.alipay.container;

/**
 * ClassName: PayCheckFactoryContainer
 * Description:
 * Date:2026/6/1
 *
 * @author ThierrySquirrel
 * @since JDK25
 */
public final class PayCheckFactoryContainer {
    /**
     * MAP_DEFAULT_SIZE
     * <p>
     * 默认Map大小
     */
    public static final int MAP_DEFAULT_SIZE = Runtime.getRuntime().availableProcessors() * 2;
    /**
     * Reload Join
     * <p>
     * 重置拼接符
     */
    public static final String RELOAD_JOIN = ",";

    private PayCheckFactoryContainer() {
    }


}
