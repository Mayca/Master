package master;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import master.Api.Api;
import master.Model.Master;

public class Main {

    public static void main(String[] args) throws UnknownHostException, IOException {
      // Api api = new Api(args[0],Integer.valueOf(args[1]),new Slave(args[2],args[3], Integer.valueOf(args[4])));
        Api api = new Api(InetAddress.getLocalHost().getHostAddress(), 4444,new Master("bouncing",InetAddress.getLocalHost().getHostAddress(), 8000));
       api.start();
    }
}
