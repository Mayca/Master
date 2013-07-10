package master.messages;

public class MasterRequestMessage extends RequestMessage {
    private String ip;
    private int port;

    public MasterRequestMessage(String channel, String ip, int port) {
        super(channel);
        this.ip = ip;
        this.port = port;
    }

    public String getFmuName() {
        return channel;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }
    
}
