/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.rest.repository.support;

import org.springframework.hateoas.RelProvider;
import org.springframework.util.StringUtils;

/**
 *
 * @author Oliver Gierke
 */
public class SimpleRelProvider implements RelProvider {

	/* 
	 * (non-Javadoc)
	 * @see org.springframework.plugin.core.Plugin#supports(java.lang.Object)
	 */
	@Override
	public boolean supports(Class<?> delimiter) {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.hateoas.RelProvider#getSingleResourceRelFor(java.lang.Class)
	 */
	@Override
	public String getSingleResourceRelFor(Class<?> type) {
		String collectionRel = getCollectionResourceRelFor(type);
		return String.format("%s.%s", collectionRel, collectionRel);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.springframework.hateoas.RelProvider#getCollectionResourceRelFor(java.lang.Class)
	 */
	@Override
	public String getCollectionResourceRelFor(Class<?> type) {
		return StringUtils.uncapitalize(type.getSimpleName());
	}
}
