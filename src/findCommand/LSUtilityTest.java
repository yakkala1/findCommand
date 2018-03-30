package findCommand;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class LSUtilityTest {

	@Test
	public void test() {
		File workDir = new File("test/videoGeneration");
		LSUtility ls = new LSUtility(workDir);
		List<File> files = ls.compute();
		Logger.log(files);
	}

}
