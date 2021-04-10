package logico;

import java.net.*;
import java.io.*;
import java.util.*;

public class Flujo extends Thread
{
	Socket nsfd;
	DataInputStream FlujoLectura;
	DataOutputStream FlujoEscritura;
	InputStream in = null;
	OutputStream out = null;

	public Flujo (Socket sfd)
	{
		nsfd = sfd;
		try
		{
			FlujoLectura = new DataInputStream(new BufferedInputStream(sfd.getInputStream()));
			FlujoEscritura = new DataOutputStream(new BufferedOutputStream(sfd.getOutputStream()));
		}
		catch(IOException ioe)
		{
			System.out.println("IOException(Flujo): "+ioe);
		}
	}

	public void run() {
		String path = System.getProperty("user.dir");

		try {
			in = nsfd.getInputStream();
		} catch (IOException ex) {
			System.out.println("Can't get socket input stream. ");
		}

		try {
			out = new FileOutputStream(path+"\\Respaldo\\"+ Principal.getNombreFactura() +".dat");
		} catch (FileNotFoundException ex) {
			System.out.println("File not found. ");
		}

		byte[] bytes = new byte[16*1024];

		int count;
		try {
			while ((count = in.read(bytes)) > 0) {
				out.write(bytes, 0, count);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			out.close();
			in.close();
			nsfd.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}