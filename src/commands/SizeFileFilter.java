package commands;

import java.io.File;

public class SizeFileFilter extends FileFilter {
	private static enum Relation {
		GREATER_THAN,
		LESS_THAN,
		EQUAL_TO
	}
	
	long size;
	private Relation expectedRelation;

	public SizeFileFilter(String argument) {
		setExpectedRelation(argument);
		setSize(argument);
	}

	private void setSize(String argument) {
		char firstChar = argument.charAt(0);
		String sizeString;
		if(firstChar=='+' || firstChar=='-')
			sizeString = argument.substring(1);
		else
			sizeString = argument;
		size = Long.parseLong(sizeString);
	}

	private void setExpectedRelation(String argument) {
		char firstChar = argument.charAt(0);
		switch(firstChar) {
		case '+':
			expectedRelation = Relation.GREATER_THAN;
			break;
		case '-':
			expectedRelation = Relation.LESS_THAN;
			break;
		default:
			expectedRelation = Relation.EQUAL_TO;
		}
	}

	@Override
	public boolean matches(File child) {
		switch(expectedRelation) {
		case GREATER_THAN:
			return isGreaterThan(child);
		case LESS_THAN:
			return isLessThan(child);
		case EQUAL_TO:
			return isEqualTo(child);
		default:
			return false;
		}
	}

	private boolean isEqualTo(File child) {
		return child.length()==size;
	}

	private boolean isLessThan(File child) {
		return child.length()<size;
	}

	private boolean isGreaterThan(File child) {
		return child.length()>size;
	}

}
