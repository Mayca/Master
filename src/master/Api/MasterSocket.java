package master.Api;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import master.Model.Master;
import master.messages.Command;


public class MasterSocket {

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    private Master master;

    public MasterSocket(Master master) throws IOException {
        this.master = master;
        initializeConnection();
    }

    private void initializeConnection() throws IOException {
        this.socket = new Socket(this.master.getIp(), this.master.getPort());
        this.writer = new PrintWriter(this.socket.getOutputStream(), true);
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void execute() throws IOException {
        /*
        while ((command = readCommand()) != null) {
            registerCommand(command);
            sendResponseToMaster();
        }*/
    }

    private Command readCommand() throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(this.reader.readLine(), Command.class);
    }

    private void sendCommandToSlave(Command command) {
        Gson gson = new Gson();
        this.writer.println(gson.toJson(command));
    }
}
