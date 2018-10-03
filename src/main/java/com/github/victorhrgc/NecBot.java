package com.github.victorhrgc;

import com.github.victorhrgc.command.CommandListener;
import com.github.victorhrgc.utils.Utils;

import sx.blah.discord.api.IDiscordClient;

/**
 * victorhrgc 02/10/2018.
 */
public class NecBot {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println(
					"Por favor informe o token do bot como o primeiro parametro (java -jar nomedojar.jar token");
			return;
		}

		IDiscordClient cli = Utils.getBuiltDiscordClient(args[0]);

		cli.getDispatcher().registerListener(new CommandListener());

		cli.login();

	}

}