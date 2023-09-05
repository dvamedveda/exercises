package ru.savelev.patterns.command;

import ru.savelev.patterns.command.api.Transfer;
import ru.savelev.patterns.command.impl.BankAccountToBankAccountTransfer;
import ru.savelev.patterns.command.impl.CardToBankAccountTransfer;
import ru.savelev.patterns.command.service.BankProcessingService;
import ru.savelev.patterns.command.service.CardProcessingService;

import java.math.BigDecimal;

public class PaymentService {
    public static void main(String[] args) {
        BankProcessingService bankProcessingService = new BankProcessingService();
        CardProcessingService cardProcessingService = new CardProcessingService();
        TransferExecutor transferExecutor = new TransferExecutor();

        BankAccountToBankAccountTransfer fromAccountToAccountTransfer = new BankAccountToBankAccountTransfer(bankProcessingService);
        fromAccountToAccountTransfer.setSourceAccount("1234123412341234");
        fromAccountToAccountTransfer.setDestinationAccount("4321432143214321");
        fromAccountToAccountTransfer.setAmount(new BigDecimal("12.70"));
        transferExecutor.setTransfer(fromAccountToAccountTransfer);
        transferExecutor.execute();

        CardToBankAccountTransfer fromCardToAccountTransfer = new CardToBankAccountTransfer(bankProcessingService, cardProcessingService);
        fromCardToAccountTransfer.setSourceCardNumber("1234432112344321");
        fromCardToAccountTransfer.setDestinationAccount("4321432143214321");
        fromCardToAccountTransfer.setAmount(new BigDecimal("29.10"));
        transferExecutor.setTransfer(fromCardToAccountTransfer);
        transferExecutor.execute();
    }
}
