package fr.blablacar.server;

import java.awt.Desktop;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class BlaBlaServer {

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);

		ResourceConfig config = new ResourceConfig();
		config.packages("fr.blablacar", "com.jersey.jaxb", "com.fasterxml.jackson.jaxrs.json");

		ServletHolder servlet = new ServletHolder(new ServletContainer(config));

		ServletContextHandler context = new ServletContextHandler(server, "/*");
		context.addServlet(servlet, "/*");

		server.start();
		// makes the main thread wait for server thread terminiation
		server.join();

	}

}