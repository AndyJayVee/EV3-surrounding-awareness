package main;

import java.io.*;
import java.net.*;
import java.nio.CharBuffer;

public class WebSocketMessageHandler implements Readable {

	private String receiveMessage;
	private String sendMessage;
	private PrintWriter printWriter;
	private BufferedReader bufferReader;
	private BufferedReader receiveRead;

	public void initiateServer() throws Exception {
		ServerSocket sersock = new ServerSocket(3000);
	      System.out.println("Server  ready for chatting");
	      Socket sock = sersock.accept();                          
	                              // reading from keyboard (keyRead object)
		bufferReader = new BufferedReader(new InputStreamReader(System.in));
		
		// sending to client (printWriter object)
		OutputStream ostream = sock.getOutputStream();
		printWriter = new PrintWriter(ostream, true);

		// receiving from server ( receiveRead object)
		InputStream istream = sock.getInputStream();
		receiveRead = new BufferedReader(new InputStreamReader(istream));

		startServer();
		sersock.close();
	}

	public void startServer() {
		while (true) {

			try {
				if ((receiveMessage = receiveRead.readLine()) != null) // receive from server
				{
					System.out.println(receiveMessage); // displaying at DOS prompt
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				sendMessage = bufferReader.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println(sendMessage); 
			printWriter.println(sendMessage); // sending to server
			printWriter.flush(); // flush the data
			
		}
	}

	@Override
	public int read(CharBuffer cb) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}
}
