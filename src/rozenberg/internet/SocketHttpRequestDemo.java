package rozenberg.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class SocketHttpRequestDemo {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// at the lowest level
		// when we talk abt communicating over the web we dont use socket...

		// needs the address and the port
		// they have no protocol associated to it
		Socket socket = new Socket("www.google.com", 80);
		// need a request - if type www.google.com and hit enter
		// this request is sent
		// this is the http protocol - part of the url;
		String httpRequestString = "GET /index.html\n\n";
		// get the ouptut stream from the socket and write this stream to the
		// socket
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write(httpRequestString);
		out.flush();
		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		socket.close();
	}
}
