package commands;

import java.io.File;
import java.util.Map;

public class CommandFactory {
	
	public static Command createCommand(File workDir, String commandName, Map<String, String> args) 
	{
		Logger.debug("createCommand function");
		Logger.debug("commandName : "+commandName);
		switch (commandName) {
		case "find":
			Logger.debug("find case");
			return new FindCommand(workDir, args);
		case "ls":
			return new LSCommand(workDir, args);
		default:
			throw new IllegalArgumentException();
		}
	}

}