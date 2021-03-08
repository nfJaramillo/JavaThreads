package Monothread;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

	public static final int PUERTO = 3400; // Para conectarse al servidor online aqui iria el puerto 5000
	public static final String SERVIDOR = "localhost"; // Para conectarse al servidor online aqui iria la ip 54.208.112.235

	public static void main(String[] args) throws IOException{
		Socket socket = null;
		PrintWriter escritor = null;
		BufferedReader lector = null;

		System.out.println("Cliente ...");


		try {
			// crea el socket del lado cliente
			socket = new Socket(SERVIDOR,PUERTO);
			// se conectan los flujos, tanto de salida co de entrada
			escritor = new PrintWriter(socket.getOutputStream(),true);
			lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		// crea un flujo para leer lo que escribe el cliente por el teclado
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		// se ejecuta el protocolo en el lado cliente
		ProtocoloCliente.procesar(stdIn, lector, escritor);

		// se cierran los flujos y el socket
		escritor.close();
		lector.close();
		socket.close();


		stdIn.close();

	}


}
