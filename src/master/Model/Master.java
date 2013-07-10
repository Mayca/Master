package master.Model;

import master.messages.MasterRequestMessage;
import master.messages.MasterResponseMessage;
import master.messages.Message;

public class Master {
    private String name;
    private String ip;
    private int port;
    
    public Master(String name, String ip, int port) {
        this.name = name;
        this.ip = ip;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public Message getRequest() {
        return new MasterRequestMessage(this.name, this.ip, this.port);        
    }

    public void registerResponse(MasterResponseMessage masterResponseMessage) {
        this.ip = masterResponseMessage.getIp();
        this.port = masterResponseMessage.getPort();
    }
}
