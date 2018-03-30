package findCommand;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class LSUtilityTest {

	@Test
	public void test() {
		File workDir = new File("test/videoGeneration");
		LSCommand ls = new LSCommand(workDir);
	}

}
