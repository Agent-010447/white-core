package fr.agent040147.whitecore;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpy implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {

		if (!(sender instanceof Player))
			return true;

		if (args.length == 0) {

			sender.sendMessage("§4Il manque l'argument ON ou off");

			return true;

		}

		if (args[0].equals("on")) {
			// spy ON
			if (sender.hasPermission("whitecore.spy")) {

				if (whitecore.spying.contains((Player) sender)) {

					sender.sendMessage("§4Spy deja actif ! ");

					return true;

				} else {

					whitecore.spying.add((Player) sender);
					sender.sendMessage("§4Spy ON");

					return true;
		
				}

			}

		}

		if (args[0].equals("off")) {
			// spy OFF

			if (whitecore.spying.contains((Player) sender)) {

				if (sender.hasPermission("whitecore.spy")) {

					whitecore.spying.remove((Player) sender);
					sender.sendMessage("§4Spy OFF");
				}

			} else {

				sender.sendMessage("§4Votre spy n'était pas activé !");

			}

		}

		return true;
	}

}