package master.Model;

import master.command.CommandFactory;
import master.messages.MasterRequestMessage;
import master.messages.MasterResponseMessage;
import master.messages.Message;

public class MasterManager {

    private CommandFactory commandFactory;
    private Master master;

    public MasterManager(Master master) {
        this.master = master;
        this.commandFactory = new CommandFactory();
    }

    public Master getMaster() {
        return master;
    }

    public Message getRequestForMediator() {
        return new MasterRequestMessage(this.master.getName(), this.master.getIp(), this.master.getPort());
    }

    public void registerMediatorResponse(MasterResponseMessage masterResponseMessage) {
        this.master.setPort(masterResponseMessage.getPort());
        this.master.setIp(masterResponseMessage.getIp());
    }
}
