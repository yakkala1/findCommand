package findCommand;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LSCommand {
	
	private File workDir;

	public LSCommand(File workDir) {
		this.workDir = workDir;
	}
	
	public List<File> compute() {
		File[] files = workDir.listFiles();
		List<File> result = new ArrayList<File>(Arrays.asList(files));
		return result;
	}

}
