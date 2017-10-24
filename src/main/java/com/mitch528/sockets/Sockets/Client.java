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
		
		handler.start();
	}

	public void sendMessage(String message) {
		handler.sendMessage(message);
	}

	public void disconnect() {
		handler.disconnect();
	}

	public SocketHandler getHandler() {
		return handler;
	}

	public Socket getSocket() {
		return sock;
	}

}
