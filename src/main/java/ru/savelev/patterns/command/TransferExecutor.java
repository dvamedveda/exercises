package ru.savelev.patterns.command;

import ru.savelev.patterns.command.api.Transfer;

public class TransferExecutor {

    private Transfer currentTransfer;

    public void setTransfer(Transfer currentTransfer) {
        this.currentTransfer = currentTransfer;
    }

    public void execute() {
        this.currentTransfer.printDescription();
        this.currentTransfer.sendPayment();
    }
}
