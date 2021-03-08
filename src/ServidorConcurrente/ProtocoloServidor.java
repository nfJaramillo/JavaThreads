package ServidorConcurrente;
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
		if(!inputLine.equals("Hola"))
		{
			// escribe en el flujo de la salida
			pOut.println("Mensaje erroneo, adios");
			System.out.println("Mensaje erroneo, adios");
		}

		else
		{
			// escribe en el flujo de la salida
			pOut.println("Listo");

			// lee del flujo de entrada
			inputLine = pIn.readLine();
			System.out.println("Entrada a procesar: " + inputLine);

			// procesa la entada
			try
			{
				int numero = Integer.parseInt(inputLine);
				outputLine = "" + (numero - 1);
				// escribe en el flujo de la salida
				pOut.println(outputLine);

				// lee del flujo de entrada
				inputLine = pIn.readLine();
				System.out.println("Entrada a procesar: " + inputLine);

				// procesa la entada
				if(!inputLine.equals("OK"))
				{
					// escribe en el flujo de la salida
					pOut.println("Mensaje erroneo, adios");
					System.out.println("Mensaje erroneo, adios");
				}

				else
				{
					// escribe en el flujo de la salida
					pOut.println("ADIOS");
				}
			}
			catch (Exception e) 
			{
				// escribe en el flujo de la salida
				pOut.println("Mensaje erroneo, adios");
				System.out.println("Mensaje erroneo, adios");


			}

		}
	}

}
