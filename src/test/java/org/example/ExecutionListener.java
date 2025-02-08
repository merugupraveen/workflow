package org.example;

import static org.example.JsonUtils.findStep;
import static org.example.JsonUtils.readWorkFlow;

import lombok.SneakyThrows;
import org.example.pojos.Step;
import org.example.pojos.WorkFlow;
import org.testng.IExecutionListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExecutionListener implements IExecutionListener, ISuiteListener, ITestListener {

  String suitName;
  String testStatus;

  @Override
  public void onTestStart(ITestResult result) {
    ITestListener.super.onTestStart(result);
    testStatus = "STARTED";
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    ITestListener.super.onTestSuccess(result);
    testStatus = "PASS";
  }

  @Override
  public void onTestFailure(ITestResult result) {
    ITestListener.super.onTestFailure(result);
    testStatus = "FAIL";
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    ITestListener.super.onTestSkipped(result);
    testStatus = "SKIP";
  }

  @Override
  public void onStart(ISuite suite) {
    ISuiteListener.super.onStart(suite);
    suitName = suite.getName();
  }

  @Override
  public void onExecutionStart() {
    IExecutionListener.super.onExecutionStart();

  }

  @SneakyThrows
  @Override
  public void onExecutionFinish() {
    IExecutionListener.super.onExecutionFinish();
    if (Boolean.valueOf(System.getProperty("workflow"))) {
      WorkFlow workFlow = readWorkFlow("C:\\Users\\Praveen\\IdeaProjects\\github\\workflow\\src\\main\\resources\\workflow.json");
      Step step = findStep(workFlow,suitName);
      System.out.println(step.getCurrentExecStatus());
      System.out.println(suitName);
      step.setCurrentExecStatus(testStatus);
      RedisUtils.set("wrkflow1",workFlow.toString(),300);
    }
  }
}
