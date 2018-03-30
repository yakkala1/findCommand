package findCommand;

import java.io.File;
import java.io.IOException;

public class RemoveAllFilesAndAddGitkeepFile {
	
	public static void main(String[] args) throws IOException {
		File workDir = new File("test");
		method(workDir);
	}

	private static void method(File workDir) throws IOException {
		for(File child : workDir.listFiles()) {
			if(child.isDirectory()) {
				method(child);
				File gitkeep = new File(child, ".gitkeep");
				gitkeep.createNewFile();
			} else if(child.getName().equals(".gitkeep")) {
			} else {
				child.delete();
			}
		}
	}

}
