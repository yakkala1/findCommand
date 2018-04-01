package commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class UserFileFilter extends FileFilter {
	String user;

	public UserFileFilter(String user) {
		this.user = user;
	}

	@Override
	public boolean matches(File file) {
		String owner;
		owner = getOwnerName(file);
		return owner.equals(user);
	}

	private String getOwnerName(File file) {
		try {
			return Files.getOwner(file.toPath()).getName();
		} catch (IOException e) {
			Logger.error(e);
			throw new RuntimeException();
		}
	}

}