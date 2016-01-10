package rozenberg.twitter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class TwitterHandler extends AbstractHandler {

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		response.getWriter().println("<h1>Hello</h1>");
		//content type - how the server tells the web browser what it is downloading
		//status - tells the browser what type of response it will be - 200- "ok" = 404 = "error"
		//need to tell the request you've handles the message
		//print out the response in html because thats what the browser expects 
		
	}

}
