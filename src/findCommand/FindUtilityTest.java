package findCommand;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class FindUtilityTest {
	
	@Test
	public void test() {
		File workDir = new File("test");
		String name = "1";
		FindUtility utility = new FindUtility(workDir, name);
		List<File> results = utility.compute();
		Logger.log(results);
	}

}
