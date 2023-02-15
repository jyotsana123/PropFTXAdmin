package PropFTX.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject() //We declare this method as static so that I can access this method without even declaring an object of this class.
	                                              //Whenever you declare as static then you should call this method by Classname.Methodname
	{
		//two classes are helpful to generate extent report - ExtentReports, ExptentSparkReporter class
				//ExptentSparkReporter class expect a path where your report should be created, This is responsible to creating report
				String path = System.getProperty("user.dir")+"\\reports\\index.html"; //Give path to create report inside the project
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				reporter.config().setDocumentTitle("Test Result");
				reporter.config().setReportName("Web Automation Results");
				//ExtentSparkReporter is a helper class which is helping to create some configuration and that will finally report to it's main class
				
				//ExtentReport class is main class which is responsible to create and consolidate all your test execution
				ExtentReports extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Jyotsana Pandey");
				
				//In framework if we have multiple test cases then we need to write all lines in every test methods, Which is not good approach, So we do it in optimized way
				//So I write these lines somewhere so all the test cases will commonly use that without messing up this code in the actual test
				//So for that there is a concept called TestNG listeners and that will awesomely handle this work.
				//Before that we need add extent report dependency in our project (PropFTXAdmin)
				//So first let me do one thing, for the report handling you need to set up metadata like creating extent spark reporter class object, setting report name, document title,
				//so for that under the resource in main java, let me create one new class to exclusively tell it as ExtentReporterNG. So inside this , Let's create one method which will create a report entry and give the object out of it - Get report object
				//Just copy paste these lines in ExtentReporterNG class (PropFTX/PropFTX.resources/ExtentReporterNG)
				//first we are going to create object of extent reports which is responsible to make all this happen. So for that we are attaching the reporter
				 //the reporter tells about what is the report name, what is the title, So all these we have to attaching to the main extent 
				//for this we are using extent.attachReporter(reporter);
				//Now using this extent object, We are going to create entries for each and every test in the report
				//So to create an entry for any test, We will start like extent.createTest(path), And whatever result is that it will show in the HTML report
				
				extent.createTest(path); //We are not going to write this in n no. of test cases, So there is a smart way of handle this - There is concept call TestNG listeners
				//We should write it in TestComponent package
				return extent;
	}
}
