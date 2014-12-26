package com.example.testingdatabase;

public class Comment {
  private long id;
  private String comment;
  private String name;
  private String dorm;
  private String room;
  private String ext;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getComment() {
    return comment;
  }
  
  public String getName() {
	    return name;
	  }
  public String getDorm() {
	    return dorm;
	  }
  public String getRoom() {
	    return room;
	  }
  public String getExt() {
	    return ext;
	  }
  

  public void setComment(String comment) {
    this.comment = comment;
  }
  
  public void setName(String name) {
	    this.name = name;
  }
  
  public void setDorm(String dorm) {
	    this.dorm = dorm;
  }
  
  public void setRoom(String room) {
	    this.room = room;
  }
  
  public void setExt(String ext) {
	    this.ext = ext;
  }
  
  

  // Will be used by the ArrayAdapter in the ListView
  @Override
  public String toString() {
    return comment;
  }
}