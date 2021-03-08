package Multithread;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadServidor extends Thread{

	private Socket socket;

	private int id;


	public ThreadServidor(Socket pSocket, int pId) {
		socket = pSocket;
		id = pId;
	}

	@Override
	public void run() {
		try {
			System.out.println("El thread: " + id +" incia (Aqui deben cambiar a la consola del cliente pra enviar el mensaje");
			// se conectan los flujos tanto de salida como de entrada
			PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// se ejecuta el protocolo del lado del servidor
			ProtocoloServidor.procesar(lector, escritor);

			// se cierran los flujos y el socket
			escritor.close();
			lector.close();
			System.out.println("El thread: " + id +" termina");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}








}
