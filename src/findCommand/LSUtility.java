package findCommand;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LSUtility {
	
	private File workDir;

	public LSUtility(File workDir) {
		this.workDir = workDir;
	}
	
	public List<File> compute() {
		File[] files = workDir.listFiles();
		List<File> result = new ArrayList<File>(Arrays.asList(files));
		return result;
	}

}
