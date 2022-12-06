package com.sidorenko.dp.controller.command;

import com.sidorenko.dp.controller.command.impl.DecryptCommand;
import com.sidorenko.dp.controller.command.impl.EncryptCommand;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.sidorenko.dp.controller.command.CommandName.*;

public class CommandProvider {
    private final Map<CommandName, Command> commands = new LinkedHashMap<>();
    private static final CommandProvider provider = new CommandProvider();

    private CommandProvider() {
        commands.put(ENCRYPT, new EncryptCommand());
        commands.put(DECRYPT, new DecryptCommand());
    }

    public static CommandProvider getInstance() {
        return provider;
    }

    public Command getCommand(String commandName) {
        CommandName command = CommandName.valueOf(commandName.toUpperCase());
        return commands.get(command);
    }
}
