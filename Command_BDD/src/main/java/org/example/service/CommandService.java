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
        command.addProduct(product, 1);
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



    public String getOrderConfirmation(Command command) {
        return "Order placed successfully";
    }

    public String getOrderErrorMessage(Command command) {
        return "Order does not exist";
    }
    public String getProductErrorMessage(Command command, Product product) {
        // Implémentez la logique pour retourner un message d'erreur si le produit n'est pas dans la commande
        return "Product is not in the order"; // Exemple
    }
}
