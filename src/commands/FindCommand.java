package commands;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FindCommand extends Command {
	private List<FileFilter> fileFilters;
	
	public FindCommand(File workDir, Map<String, String> args) {
		super(workDir, args);
	}

	@Override
	protected void processArguments() throws IllegalArgumentException {
		fileFilters = new ArrayList<FileFilter>();
		Iterator<Map.Entry<String,String>> iterator = args.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			String argumentName = entry.getKey();
			String argumentValue = entry.getValue();
			FileFilter filter = FileFilterFactory.createFilter(argumentName, argumentValue);
			Logger.debug("filter : "+filter);
			fileFilters.add(filter);
		}
	}

	@Override
	public String execute() {
		List<File> matchingFiles = new FindUtility(workDir, fileFilters).compute();
		return formatResult(matchingFiles);
	}

	private String formatResult(List<File> matchingFiles) {
		String result = "";
		for(File file:matchingFiles) {
			result += file.getAbsolutePath()+"\n";
		}
		return result;
	}

}