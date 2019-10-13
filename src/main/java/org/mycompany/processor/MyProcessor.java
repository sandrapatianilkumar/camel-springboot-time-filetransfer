package org.mycompany.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.mycompany.exception.MyCamalCustomException;

public class MyProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		System.out.println("Exception Thrown");
		throw new MyCamalCustomException();
	}

}
