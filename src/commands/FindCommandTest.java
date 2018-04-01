package commands;

import java.io.File;

import org.junit.Test;

public class FindCommandTest {

	@Test
	public void testNameArgument() {
		testCommand("find name services");
	}
	
	@Test
	public void testSizeArgument() {
		testCommand("find size +3000");
	}
	
	@Test
	public void testUserArgument() {
		testCommand("find user ravimsp");
	}
	
	@Test
	public void testTypeArgument() {
		testCommand("find type r");
	}
	
	@Test
	public void testMultipleArguments() {
		testCommand("find name scratch.vim type r");
	}

	@Test
	public void testMultipleArguments1() {
		testCommand("find size +3000 type r");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMultipleArguments2() {
		testCommand("find size +3000 type x");
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
