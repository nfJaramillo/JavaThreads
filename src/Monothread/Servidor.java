package Monothread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import Multithread.ProtocoloServidor;



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


		while (continuar) {
			// crear el socket en el lado del servidor
			// queda bloqueado esperando a que llegue un ciente

			Socket socket = ss.accept();

			try {
				// se conectan los flujos tanto de salida como de entrada
				PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				// se ejecuta el protocolo del lado del servidor
				ProtocoloServidor.procesar(lector, escritor);

				// se cierran los flujos y el socket
				escritor.close();
				lector.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}




		}
		ss.close();
	}



}
