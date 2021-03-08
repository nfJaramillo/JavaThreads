package PoolDeThreads;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test implements Runnable{
	
	private Socket socketCliente;
	private PrintWriter sOutput;
	private BufferedReader sInput;
	private static int PUERTO = 8081;
	
	public Test (Socket pSocketCliente)
	{
		socketCliente = pSocketCliente;
	}
	
	public void run()
	{
		try {
			System.out.println("Runnable en ejecucion: " + Thread.currentThread().getName());
			sOutput = new PrintWriter(socketCliente.getOutputStream(),true);
			sInput = new BufferedReader (new InputStreamReader(socketCliente.getInputStream()));
			String inputLine = sInput.readLine();
			String outputLine = "servidor responde" + inputLine;
			sOutput.println(outputLine);
		} catch (Exception e) {e.printStackTrace();}
	}
	
	

	public static void main(String[] args) {
		int numThreads = 4;
		ExecutorService pool = Executors.newFixedThreadPool(numThreads);
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(PUERTO);
			System.out.println("Servidor escuchando en puerto " + PUERTO);
			while (true)
			{
				Socket cliente = ss.accept();
				System.out.println("Servidor aceptado conexion ");
				pool.execute(new Test(cliente));
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	

}
