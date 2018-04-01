package commands;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
	
	public static Command createCommand(File workDir, String commandName, Map<String, String> args) 
	{
		switch (commandName) {
		case "find":
			return new FindCommand(workDir, args);
		case "ls":
			return new LSCommand(workDir, args);
		default:
			throw new IllegalArgumentException();
		}
	}

}