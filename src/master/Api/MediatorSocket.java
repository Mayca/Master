package master.Api;

import master.messages.Message;
import master.messages.MasterResponseMessage;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import master.Model.Master;

public class MediatorSocket {

    private Socket socket = null;
    private PrintWriter writer;
    private BufferedReader reader;
    private Master master;

    public MediatorSocket(String ip, int port, Master master) throws UnknownHostException, IOException {
        initializeConnection(ip, port);
        this.master = master;
    }

    private void initializeConnection(String ip, int port) throws IOException {
        this.socket = new Socket(ip, port);
        this.writer = new PrintWriter(this.socket.getOutputStream(), true);
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void registerChannel() throws IOException{
        sendRequest();
        waitResponse();
    }
    private void sendRequest() {
        sendHeader();
        sendMasterRequest();
    }
    
     private void waitResponse() throws IOException {
        Gson gson = new Gson();
        MasterResponseMessage masterResponseMessage = gson.fromJson(this.reader.readLine(), MasterResponseMessage.class);
        this.master.registerResponse(masterResponseMessage);
    }

    private void sendHeader() {
        Gson gson = new Gson();
        this.writer.println(gson.toJson("MASTER"));
    }

    private void sendMasterRequest() {
        Message request = this.master.getRequest();
        Gson gson = new Gson();
        this.writer.println(gson.toJson(request));
    }   
}
