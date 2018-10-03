package com.github.victorhrgc.utils;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.RequestBuffer;

/**
 * Created by victorhrgc on 02/10/2018.
 */
public class Utils {
	// Constantes
	public static String COMMANDS_PREFIX = "!";

	// Builda um cliente discord a partir de um token de bot
	public static IDiscordClient getBuiltDiscordClient(String token) {
		return new ClientBuilder().withToken(token).withRecommendedShardCount().build();
	}

	// Envia uma mensagem
	public static void sendMessage(IChannel channel, String message) {
		RequestBuffer.request(() -> {
			try {
				channel.sendMessage(message);
			} catch (DiscordException e) {
				System.err.println("Nao foi possivel enviar a mensagem. Erro: ");
				e.printStackTrace();
			}
		});
	}

}