package commands;

public class FileFilterFactory {

	public static FileFilter createFilter(String filterName, String filterArgument) {
		switch(filterName) {
		case "name":
			return new NameFileFilter(filterArgument);
		case "size":
			return new SizeFileFilter(filterArgument);
		case "user":
			return new UserFileFilter(filterArgument);
		case "type":
			return new TypeFileFilter(filterArgument);
		default:
			throw new IllegalArgumentException();
		}
	}

}
