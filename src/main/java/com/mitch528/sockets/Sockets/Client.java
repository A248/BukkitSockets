package com.mitch528.sockets.Sockets;

import java.net.Socket;

public class Client {

	private Socket sock;

	private SocketHandler handler = new SocketHandler();

	private String host;
	private int port;

	public Client(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void connect() {

		try {

			sock = new Socket(host, port);

			handler.setSocket(sock);
			handler.setID(0);

			handler.start();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

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
