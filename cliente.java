import java.net.*;
import java.io.*;

public class TCPli {
	public static void main (String[] args){
		try{	
			Socket misocket = new Socket("127.0.0.1",4444);
			BufferedReader lectura, lee_datos;
			PrintWriter escritura;
			lectura = new BufferedReader(new InputStreamReader(misocket.getInputStream()));
			escritura = new PrintWriter(misocket.getOutputStream(), true);
			lee_datos = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Introduce tu mensaje al servidor(para salir escribe .):");
			String msg;
			while(true){
				msg=lee_datos.readLine();
				escritura.println(msg);
				
				if (msg.equals(".")) break;
				System.out.println("Mensaje del servidor"+lectura.readLine()); 
			}
			System.out.println("Mensaje del servidor: "+lectura.readLine());
		
		}
		catch(UnknownHostException e){
			System.err.println("Nombre de la maquina servidora desconocida");
			}
		catch(ConnectException e){
			System.err.println("El servidor no esta conectado en " + args[0]);
			}
		catch(SocketException e){
			System.err.println("Error en una operacion del socket");
			}
		catch(IOException e){
			System.err.println("Error en la lectura/escritura");
			}
			}
			
		
	}