package master.Api;

import java.io.IOException;
import java.net.UnknownHostException;
import master.Model.Master;

public class Api {
    private MediatorSocket mediatorSocket;
    private MasterSocket masterSocket;
    private Master master;

    public Api(String ip, int port, Master slave) throws UnknownHostException, IOException {
        this.mediatorSocket = new MediatorSocket(ip, port, slave);
        this.master = slave;
    }
    
    public void start() throws IOException{
        registerChannel();
        startConnectionWithSlave();
    } 

    private void registerChannel() throws IOException {
        this.mediatorSocket.registerChannel();
    }
    
    private void startConnectionWithSlave() throws IOException{
        this.masterSocket= new MasterSocket(this.master);
        this.masterSocket.execute();
    }
    
}
