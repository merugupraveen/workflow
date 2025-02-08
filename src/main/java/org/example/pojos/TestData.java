package org.example.pojos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestData {

  private int uid;

  // Getters and Setters
  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }
}

