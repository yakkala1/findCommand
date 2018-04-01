package commands;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindCommand extends Command {
	private static final Set<String> validArgumentNames;
	static {
		validArgumentNames = new HashSet<String>();
		validArgumentNames.add("name");
	}

	public FindCommand(File workDir, Map<String, String> args) {
		super(workDir, args);
	}

	@Override
	protected void processArguments() throws IllegalArgumentException {
		Iterator<Map.Entry<String,String>> iterator = args.entrySet().iterator();
		while(iterator.hasNext()) {
			String argumentName = iterator.next().getKey();
			if( !validArgumentNames.contains(argumentName) ) {
				throw new IllegalArgumentException();
			}
		}
	}

	@Override
	public String execute() {
		String name = args.get("name");
		List<File> matchingFiles = new FindUtility(workDir, name).compute();
		Logger.debug(matchingFiles);
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