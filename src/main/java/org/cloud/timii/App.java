package org.cloud.timii;

import io.undertow.Undertow;

import java.util.logging.Logger;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
public class App {

	private static final Logger logger = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {

		UndertowJaxrsServer ut = new UndertowJaxrsServer();

		TestApplication ta = new TestApplication();

		ut.deploy(ta);

		ut.start(Undertow.builder().addHttpListener(8080, "localhost"));

		logger.info("Server up and running...");
	}
}
