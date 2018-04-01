package commands;

import java.io.File;
import java.util.Map;

public abstract class Command {
	
	protected Map<String,String> args;
	protected File workDir;
	
	public Command(File workDir, Map<String,String> args) {
		this.workDir = workDir;
		this.args = args;
		processArguments();
		Logger.debug("args : "+args);
	}
	
	protected abstract void processArguments() throws IllegalArgumentException;

	public abstract String execute();

}