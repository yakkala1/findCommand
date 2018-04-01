package commands;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindUtility {
	
	File workDir;
	List<FileFilter> filters;
	
	public FindUtility(File workDir, List<FileFilter> filters) {
		this.workDir = workDir;
		this.filters = filters;
	}
	
	public List<File> compute() {
		List<File> results = new ArrayList<File>();
		for(File child : workDir.listFiles()) {
			if( matches(child) ) {
				results.add(child);
			}
			if(child.isDirectory()) {
				List<File> resultsOfChild = new FindUtility(child, filters).compute();
				results.addAll(resultsOfChild);
			}
		}
		return results;
	}

	private boolean matches(File child) {
		for(FileFilter filter : filters) {
			if( !filter.matches(child) )
				return false;
		}
		return true;
	}

}
