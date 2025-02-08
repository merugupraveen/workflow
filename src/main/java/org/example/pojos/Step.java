package org.example.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Step {

  private String name;

  @JsonProperty("START")
  private boolean start;

  @JsonProperty("prev_exec_result")
  private String prevExecResult;

  @JsonProperty("current_exec_status")
  private String currentExecStatus;

  @JsonProperty("exec_date")
  private String execDate;

  private TestData testdata;

  // Getters and Setters
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isStart() {
    return start;
  }

  public void setStart(boolean start) {
    this.start = start;
  }

  public String getPrevExecResult() {
    return prevExecResult;
  }

  public void setPrevExecResult(String prevExecResult) {
    this.prevExecResult = prevExecResult;
  }

  public String getCurrentExecStatus() {
    return currentExecStatus;
  }

  public void setCurrentExecStatus(String currentExecStatus) {
    this.currentExecStatus = currentExecStatus;
  }

  public String getExecDate() {
    return execDate;
  }

  public void setExecDate(String execDate) {
    this.execDate = execDate;
  }

  public TestData getTestdata() {
    return testdata;
  }

  public void setTestdata(TestData testdata) {
    this.testdata = testdata;
  }
}

