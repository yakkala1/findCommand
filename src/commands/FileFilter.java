package commands;

import java.io.File;

public abstract class FileFilter {

	public abstract boolean matches(File file);

}
