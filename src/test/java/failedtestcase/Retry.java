package failedtestcase;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
int maxTry=1;
int count=0;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(!result.isSuccess()) {
			if(count<maxTry) {
				count++;
				return true;
			}
		}
		return false;
	}

}
