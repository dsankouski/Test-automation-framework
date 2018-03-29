package report; /**
 * Created by Dzmitry_Sankouski
 */
import com.relevantcodes.extentreports.ExtentReports;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            System.out.println("getting reporter....");
            extent = new ExtentReports(workingDir+"\\ExtentReports\\ExtentReportResults.html", true);
            System.out.println("working dir is :" + workingDir);
        }
        return extent;
    }
}
