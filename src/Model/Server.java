package Model;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Nadin on 9/29/16.
 */
public class Server extends Thread {
    private BufferedWriter client;
    private ServerSocket server;
    private Socket connection;
    private String name;
    private InputStream inputStream;
    private InputStreamReader inputStreamReader;
    private BufferedReader buffReader;

    public Server(Socket connection, ServerSocket server){
        this.connection = connection;
        this.server = server;
        try{
            inputStream = this.connection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            buffReader = new BufferedReader(inputStreamReader);
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public void run(){
        try{
            String message;
            OutputStream outStream =  this.connection.getOutputStream();
            Writer writer = new OutputStreamWriter(outStream);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            client = bufferedWriter;
            message = buffReader.readLine();

            while(!"Sair".equalsIgnoreCase(message) && message != null)
            {
                message = buffReader.readLine();
                System.out.println(message);
            }

        }catch (Exception e) {
            e.printStackTrace();

        }
    }
}