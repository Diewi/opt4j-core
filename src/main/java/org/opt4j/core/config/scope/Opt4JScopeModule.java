package org.opt4j.core.config.scope;

import org.opt4j.core.start.Opt4JTask;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class Opt4JScopeModule extends AbstractModule {
	
	protected Opt4JScope opt4JScope;
	
	public Opt4JScopeModule() {
		opt4JScope = new Opt4JScope();
	}
	
	public Opt4JScopeModule(Opt4JScope opt4JScope) {
		this.opt4JScope = opt4JScope;
	}
	
	public void configure() {
		// tell Guice about the scope
		bindScope(Opt4JScoped.class, opt4JScope);

		// make our scope instance injectable
//		bind(Opt4JScope.class).toProvider(Opt4JTask.class);
//		bind(Opt4JScope.class)
//		.annotatedWith(Names.named("opt4JScope"))
//		.toInstance(opt4JScope);
	}
}
