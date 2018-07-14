/*-------------------------------------------------------------------------+
| Copyright 2018 fortiss GmbH                                              |
|                                                                          |
| Licensed under the Apache License, Version 2.0 (the "License");          |
| you may not use this file except in compliance with the License.         |
| You may obtain a copy of the License at                                  |
|                                                                          |
|    http://www.apache.org/licenses/LICENSE-2.0                            |
|                                                                          |
| Unless required by applicable law or agreed to in writing, software      |
| distributed under the License is distributed on an "AS IS" BASIS,        |
| WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. |
| See the License for the specific language governing permissions and      |
| limitations under the License.                                           |
+--------------------------------------------------------------------------*/
package org.opt4j.core.start;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.name.Named;

/**
 * @author diewald
 */
public class Opt4JTaskProvider extends AbstractModule implements Provider<Opt4JTask> {
	private Opt4JTask opt4JTask;

	@Inject
	public Opt4JTaskProvider(Opt4JTask opt4JDseTask) {
		this.opt4JTask = opt4JDseTask;
	}

	/** {@inheritDoc} */
	@Provides
	@Named("Opt4JDseInjector")
	public Opt4JTask get() {
		return opt4JTask;
	}
	
	protected void configure() {
		bind(Opt4JTask.class).toProvider(this);
	}
}
