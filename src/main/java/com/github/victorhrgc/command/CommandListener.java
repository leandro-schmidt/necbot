package com.github.victorhrgc.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.victorhrgc.utils.Utils;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * victorhrgc 02/10/2018.
 */
public class CommandListener {

	// Todos os comandos disponiveis
	private static Map<String, Command> commandMap = new HashMap<>();

	static {

		commandMap.put("random", (event, args) -> {
			double randNumber = Math.random();
			int randomInt = (int) (randNumber * 100 + 1);

			Utils.sendMessage(event.getChannel(), String.valueOf(randomInt));

			return;
		});

	}

	@EventSubscriber
	public void onMessageReceived(MessageReceivedEvent event) {

		String[] argArray = event.getMessage().getContent().split(" ");

		if (argArray.length == 0 || !argArray[0].startsWith(Utils.COMMANDS_PREFIX))
			return;

		String commandStr = argArray[0].substring(Utils.COMMANDS_PREFIX.length()).toLowerCase();

		List<String> argsList = new ArrayList<>(Arrays.asList(argArray));
		argsList.remove(0); // Remove o comando

		if (commandMap.containsKey(commandStr))
			commandMap.get(commandStr).runCommand(event, argsList);

	}

}