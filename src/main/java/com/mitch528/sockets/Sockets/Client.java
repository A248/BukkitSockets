package com.mitch528.sockets.Sockets;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private Socket sock;

	private SocketHandler handler = new SocketHandler();

	private String host;
	private int port;

	public Client(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void connect() throws UnknownHostException, IOException {
		sock = new Socket(host, port);
		
		handler.setSocket(sock);
		handler.setID(0);
		
		handler.handleConnection();
	}

	public void sendMessage(String message) throws IOException {
		handler.sendMessage(message);
	}

	public void disconnect() throws IOException {
		handler.disconnect();
	}
	
	public boolean isConnected() {
		if (sock == null) {
			return false;
		} else {
			return sock.isConnected();
		}
	}

	public SocketHandler getHandler() {
		return handler;
	}

	public Socket getSocket() {
		return sock;
	}

}
