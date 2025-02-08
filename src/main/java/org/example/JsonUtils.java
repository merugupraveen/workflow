package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Optional;
import org.example.pojos.Step;
import org.example.pojos.WorkFlow;

public class JsonUtils {

  static WorkFlow readWorkFlow (String path) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(new File(path), WorkFlow.class);

  }

  static Step findStart(WorkFlow workFlow){
    Optional<Step> optionalStep =  workFlow.getSteps().stream().filter(step->step.isStart()).findFirst();
    return optionalStep.get();
  }

  static Step findStep(WorkFlow workFlow, String name){
    Optional<Step> optionalStep =  workFlow.getSteps().stream().filter(step->step.getName().equals(name)).findFirst();
    return optionalStep.get();
  }




  public static void main(String[] args) throws IOException {
    readWorkFlow("C:\\Users\\Praveen\\IdeaProjects\\github\\workflow\\src\\main\\resources\\workflow.json");
  }

}
