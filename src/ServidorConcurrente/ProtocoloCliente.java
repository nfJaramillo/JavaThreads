package ServidorConcurrente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ProtocoloCliente {

	public static void procesar (BufferedReader stdIn, BufferedReader pIn, PrintWriter pOut) throws IOException
	{


		// lee del teclado
		System.out.println("Escriba el mensaje para enviar: ");
		String fromUser = stdIn.readLine();

		// envia por la red
		pOut.println(fromUser);
		
		System.out.println("El usuario escribio: " + fromUser);

		String fromServer = "";

		// lee lo que llega por la red
		// si lo que llega del servidor no es null
		// observe la asignacion luego la condicion
		if((fromServer = pIn.readLine()) != null) 
		{
			System.out.println("Respuesta del servidor: " + fromServer);
			if(fromServer.equals("Listo"))
			{
				// lee del teclado
				System.out.println("Escriba el mensaje para enviar: ");
				fromUser = stdIn.readLine();

				// envia por la red
				pOut.println(fromUser);
				System.out.println("El usuario escribio: " + fromUser);
			}
			else
			{
				return;
			}
		}
		
		fromServer = pIn.readLine();
		System.out.println("Respuesta del servidor: " + fromServer);
		if(fromServer.equals("Mensaje erroneo, adios"))
		{
			return;
		}
		
		// lee del teclado
		System.out.println("Escriba el mensaje para enviar: ");
		fromUser = stdIn.readLine();
		
		// envia por la red
		pOut.println(fromUser);
		System.out.println("El usuario escribio: " + fromUser );
		
		fromServer = pIn.readLine();
		System.out.println("Respuesta del servidor: " + fromServer);
		
		
		
		
	}

}
