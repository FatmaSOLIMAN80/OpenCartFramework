package listeners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult; 
public class MyListeners implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Start");
	    
	  }
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test success");
	  }
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Result Failure");
	  }
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Result Skipped");
	    
	  }
	
	public void onFinish(ITestContext context) {
		System.out.println("Test finish");
	    
	  }

}
