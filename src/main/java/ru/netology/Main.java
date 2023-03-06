package ru.netology;

import java.io.*;
import java.net.Socket;


public class Main {
    public static void main(String[] args) {
		String host = "127.0.0.1";
		int port = 8089;

		try (Socket clientSocket = new Socket(host, port);
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

			out.println("Netology");

			String resp = in.readLine();
			System.out.println(resp);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
