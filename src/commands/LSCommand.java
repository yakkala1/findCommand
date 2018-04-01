package commands;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LSCommand extends Command {
	private static final Set<String> validArgumentNames;
	static {
		validArgumentNames = new HashSet<String>();
	}

	public LSCommand(File workDir, Map<String, String> args) {
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
		String[] fileNames = workDir.list();
		return formatOutput(fileNames);
	}

	private String formatOutput(String[] fileNames) {
		String result = "";
		for(String fileName : fileNames) {
			result += fileName+"\n";
		}
		return result;
	}

}
