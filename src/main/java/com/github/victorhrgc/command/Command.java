package com.github.victorhrgc.command;

import java.util.List;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * victorhrgc 02/10/2018.
 */
public interface Command {

	void runCommand(MessageReceivedEvent event, List<String> args);

}