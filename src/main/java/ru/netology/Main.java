package ru.netology;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws Exception {
		String host = "127.0.0.1";
		int port = 8089;

		try (Socket clientSocket = new Socket(host, port);
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

			TimeUnit.SECONDS.sleep(4);
			System.out.println("- Hi, I'm Client. Let's talk to you. What's your name?");
			out.println("Client");

			TimeUnit.SECONDS.sleep(4);
			String resp = in.readLine();
			System.out.println("- " + resp);

			TimeUnit.SECONDS.sleep(4);
			System.out.println("- Great, I'm from the fire fox tribe, my version is 110.0.");
			out.println("req1");

			resp = in.readLine();
			System.out.println("- " + resp);

			TimeUnit.SECONDS.sleep(4);
			System.out.println("- Cool, you're too old for me too. Then goodbye. Good refactoring to you, Server.");
			out.println("req2");

			resp = in.readLine();
			System.out.println("- " + resp);


		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
