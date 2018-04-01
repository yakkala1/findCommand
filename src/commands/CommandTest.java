package commands;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class CommandTest {

	@Test
	public void testLs() {
		testCommand("ls");
	}
	
	@Test
	public void testFind() {
		testCommand("find name 1");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWrongArgumentToLs() {
		testCommand("ls name1 an");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWrongArgumentToFind() {
		testCommand("find name1 an");
	}
	
	private void testCommand(String string) {
		testCommand(new File("test"), string);
	}

	private void testCommand(File workDir, String commandLine) {
		CommandStringParser parser = new CommandStringParser(workDir);
		Command command = parser.parse(commandLine);
		String result = command.execute();
		Logger.log(result);
	}

}