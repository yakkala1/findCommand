package commands;

import java.io.File;

public class NameFileFilter extends FileFilter {

	String name;
	
	public NameFileFilter(String value) {
		this.name = value;
	}

	@Override
	public boolean matches(File file) {
		return file.getName().equals(name);
	}

}
