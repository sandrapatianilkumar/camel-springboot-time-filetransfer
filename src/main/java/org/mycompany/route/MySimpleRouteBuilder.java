package org.mycompany.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.mycompany.exception.MyCamalCustomException;
import org.mycompany.processor.MyProcessor;

public class MySimpleRouteBuilder extends RouteBuilder {

	/* exception handling for one file */
	/*
	 * @Override public void configure() throws Exception {
	 * from("file:C:/myinputfolder?noop=true").doTry().process(new
	 * MyProcessor()).to("file:C:/myoutFolder")
	 * .doCatch(MyCamalCustomException.class).process(new Processor() { public void
	 * process(Exchange exchange) throws Exception {
	 * System.out.println("My handling exception"); }
	 * }).log("Received body - output file");
	 * from("file:C:/inbox?noop=true").process(new
	 * MyProcessor()).to("file:C:/outbox");
	 * 
	 * }
	 */

	@Override
	public void configure() throws Exception {

		/* common exception handling - applies for all the file transer in route */
		onException(MyCamalCustomException.class).process(new Processor() {

			public void process(Exchange exchange) throws Exception {
				System.out.println("handling ex");
			}
		}).log("Received body ").handled(true);

		from("file:C:/inputFolder?noop=true").to("file:C:/outputFolder");

		from("file:C:/inbox?noop=true").process(new MyProcessor()).to("file:C:/outputFolder");
	}
}
