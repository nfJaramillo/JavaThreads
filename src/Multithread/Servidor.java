package Multithread;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;



public class Servidor {

	public static final int PUERTO = 3400;



	public static void main(String[] args) throws IOException{
		ServerSocket ss = null;
		boolean continuar = true;

		System.out.println("Main Server ...");

		try {
			ss = new ServerSocket (PUERTO);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(-1);
		}

		int numeroThreads = 0;

		while (continuar) {
			// crear el socket en el lado del servidor
			// queda bloqueado esperando a que llegue un ciente

			Socket socket = ss.accept();

			// crear el thread con el socket y el id
			ThreadServidor thread = new ThreadServidor(socket, numeroThreads);
			numeroThreads++;

			// start
			thread.start();


		}
		ss.close();
	}



}
