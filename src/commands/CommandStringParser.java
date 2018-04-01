package commands;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class CommandStringParser {
	
	private File workDir;

	public CommandStringParser(File workDir) {
		this.workDir = workDir;
	}
	
	public Command parse(String commandLine) {
		String[] commandWords = commandLine.split("\\s");
		String commandName = getCommandName(commandWords);
		Logger.debug("commandName : "+commandName);
		Map<String,String> args = getArgsMap(commandWords);
		Logger.debug("args : "+args);
		return CommandFactory.createCommand(workDir, commandName, args);
	}

	private Map<String, String> getArgsMap(String[] commandWords) {
		Map<String,String> args = new HashMap<String,String>();
		int argNumber = 0;
		while(true) {
			if(argExists(commandWords, argNumber)) {
				String argKey = getArgKey(commandWords, argNumber);
				String argValue = getArgValue(commandWords, argNumber);
				args.put(argKey, argValue);
			} else {
				break;
			}
			argNumber++;
		}
		return args;
	}

	private String getArgValue(String[] commandWords, int argNumber) {
		int index = 2 + 2*argNumber;
		return commandWords[index];
	}

	private String getArgKey(String[] commandWords, int argNumber) {
		int index = 1 + 2*argNumber;
		String argKey = commandWords[index];
		return argKey.substring(0);
	}

	private boolean argExists(String[] commandWords, int argNumber) {
		if( (commandWords.length-1)%2 != 0 )
			throw new IllegalArgumentException();
		int nArgs  =  (commandWords.length-1) / 2;
		if(argNumber < nArgs)
			return true;
		else
			return false;
	}

	private String getCommandName(String[] commandWords) {
		return commandWords[0];
	}

}
