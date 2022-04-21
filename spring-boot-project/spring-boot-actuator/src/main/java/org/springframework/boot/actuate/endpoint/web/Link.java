/*
 * Copyright 2012-2019 the original author or authors.
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

package org.springframework.boot.actuate.endpoint.web;

import org.springframework.core.style.ToStringCreator;
import org.springframework.util.Assert;

/**
 * Details for a link in a
 * <a href="https://tools.ietf.org/html/draft-kelly-json-hal-08">HAL</a>-formatted
 * response.
 *
 * @author Andy Wilkinson
 * @since 2.0.0
 */ // 类似于 http://ip:port/actuator 对应的响应中的一个 item
public class Link {

	private final String href;         // 超链接

	private final boolean templated;  // 是否是模板

	/**
	 * Creates a new {@link Link} with the given {@code href}.
	 * @param href the href
	 */
	public Link(String href) {
		Assert.notNull(href, "HREF must not be null");
		this.href = href;
		this.templated = href.contains("{");
	}

	/**
	 * Returns the href of the link.
	 * @return the href
	 */
	public String getHref() {
		return this.href;
	}

	/**
	 * Returns whether or not the {@link #getHref() href} is templated.
	 * @return {@code true} if the href is templated, otherwise {@code false}
	 */
	public boolean isTemplated() {
		return this.templated;
	}

	@Override
	public String toString() {
		return new ToStringCreator(this).append("href", this.href).toString();
	}

}
