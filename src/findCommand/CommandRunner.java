package findCommand;

import java.io.File;

public class CommandRunner {
	
	private File workDir;
	private Command command;

	public CommandRunner(String workDir, String command) {
		validateWorkDir(workDir);
		this.workDir = new File(workDir);
		this.command = new Command(command);
	}

	private void validateWorkDir(String workDir) {
		File file = new File(workDir);
		if(!file.exists()) {
			throw new IllegalArgumentException();
		}
	}
	
	public String execute() {
		
	}

}
