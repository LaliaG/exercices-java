package org.example.repository;

import org.example.model.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandRepository {
    private Map<String, Command> commands = new HashMap<>();

    public void save(String userId, Command command) {
        commands.put(userId, command);
    }

    public Command findByUserId(String userId) {
        return commands.get(userId);
    }
}
