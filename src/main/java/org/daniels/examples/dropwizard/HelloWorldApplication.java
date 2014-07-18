package org.daniels.examples.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import org.daniels.examples.dropwizard.health.TemplateHealthCheck;
import org.daniels.examples.dropwizard.resource.HelloWorldResource;
import org.daniels.examples.dropwizard.resource.SayingResource;


public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
	public static void main(String[] args) throws Exception {
		new HelloWorldApplication().run(args);
	}

	@Override
	public String getName() {
		return "hello-world";
	}

	@Override
	public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
		bootstrap.addBundle(new ViewBundle());
	}

	@Override
	public void run(HelloWorldConfiguration configuration,
			Environment environment) {
		
		final HelloWorldResource helloResource = new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName());
	    final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
	    final SayingResource sayingResource = new SayingResource();
	    
		environment.jersey().register(helloResource);
		environment.jersey().register(sayingResource);
		environment.healthChecks().register("template", healthCheck);
	}

}
