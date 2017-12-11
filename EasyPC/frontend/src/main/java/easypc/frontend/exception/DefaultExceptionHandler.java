package easypc.frontend.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class DefaultExceptionHandler {
	// 404
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNHFException(NoHandlerFoundException e) {
		ModelAndView mav = new ModelAndView("error");

		// for Debugging-- display Stacktrace
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		e.printStackTrace(pw);

		mav.addObject("errorTitle", "OOPS!!! you ran into a FREAKING 404 error....");
		mav.addObject("errorDesc","Sorry, the page requested is either invalid and/or the idea has not hit our cheif engineers YET... ");
		mav.addObject("StackTrace", sw.toString());
		mav.addObject("title", "Four-O-Four");

		return mav;

	}

	// products not found
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlePNFException(ProductNotFoundException e) {
		ModelAndView mav = new ModelAndView("error");

		// for Debugging-- display Stacktrace
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		e.printStackTrace(pw);

		mav.addObject("errorTitle", "OOPS!!! The Product is Unavailable");
		mav.addObject("errorDesc", "Sorry, the Product you've requested for is Not added yet or was removed");
		mav.addObject("StackTrace", sw.toString());
		mav.addObject("title", "Product Unavailable");
		return mav;

	}

	// general Exception Handler
	// products not found
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		ModelAndView mav = new ModelAndView("error");

		mav.addObject("errorTitle", "OOPS!!! Something went wrong....");

		// for Debugging-- display Stacktrace
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		e.printStackTrace(pw);

		mav.addObject("errorDesc", "Sorry, You ran into an Exception :" + e.toString());
		mav.addObject("StackTrace", sw.toString());
		mav.addObject("title", "Some Exception");
		return mav;

	}

}
