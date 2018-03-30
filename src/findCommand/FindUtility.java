package findCommand;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindUtility {
	
	File workDir;
	String name;
	
	public FindUtility(File workDir, String name) {
		this.workDir = workDir;
		this.name = name;
	}
	
	public List<File> compute() {
		List<File> results = new ArrayList<File>();
		for(File child : workDir.listFiles()) {
			if(child.getName().equals(name))
				results.add(child);
			if(child.isDirectory()) {
				List<File> resultsOfChild = new FindUtility(child, name).compute();
				results.addAll(resultsOfChild);
			}
		}
		return results;
	}

}
