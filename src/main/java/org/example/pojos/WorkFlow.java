package org.example.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkFlow {

  @JsonProperty("workflow_id")
  private boolean workflowId;

  @JsonProperty("steps")
  private List<Step> steps;

  @Override
  public String toString(){
  ObjectMapper objectMapper = new ObjectMapper();
    try {
     return objectMapper.writeValueAsString(this);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

}
