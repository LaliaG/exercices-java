package org.example.service;

import org.example.exception.CommandNotFoundException;
import org.example.model.Command;
import org.example.model.Product;
import org.example.repository.CommandRepository;

public class CommandService {
    private CommandRepository commandRepository;

    public CommandService() {
        this.commandRepository = new CommandRepository();
    }

    public void addProductToCommand(Command command, Product product) {
        command.addProduct(product);
    }

    public void removeProductFromCommand(Command command, Product product) {
        command.removeProduct(product);
    }

    public String placeOrder(Command command) {
        if (command == null || command.getProducts().isEmpty()) {
            throw new CommandNotFoundException("Order does not exist");
        }
        return "Order placed successfully";
    }
}
