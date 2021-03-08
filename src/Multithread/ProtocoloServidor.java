package Multithread;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class ProtocoloServidor {
	
	// observe que es un metodo estatico.
	// observe que lanza excepciones de tipo IOException
	
	public static void procesar (BufferedReader pIn, PrintWriter pOut) throws IOException
	{
		String inputLine;
		String outputLine;
		
		// lee del flujo de entrada
		inputLine = pIn.readLine();
		System.out.println("Entrada a procesar: " + inputLine);
		
		// procesa la entada
		outputLine = inputLine;
		
		// escribe ne el flujo de la salida
		pOut.println(outputLine);
		System.out.println("Salida procesada: " + outputLine);
	}

}
