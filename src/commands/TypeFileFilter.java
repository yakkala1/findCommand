package commands;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class TypeFileFilter extends FileFilter {
	char type;

	public TypeFileFilter(String value) {
		if(value.length()!=1)
			throw new IllegalArgumentException();
		else 
			type = value.charAt(0);
	}

	@Override
	public boolean matches(File file) {
		Path filePath = file.toPath();
		if(type == 'd')
			return Files.isDirectory(filePath);
		else if(type == 'l')
			return Files.isSymbolicLink(filePath);
		else if(type == 'r')
			return Files.isRegularFile(filePath);
		else
			throw new IllegalArgumentException();
	}

}
