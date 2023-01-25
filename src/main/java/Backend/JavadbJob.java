package Backend;


public class JavadbJob {

  private long id;
  private String jobTitle;
  private String jobDescription;
  private String jobStatus;
  private long cuetianPostId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }


  public String getJobDescription() {
    return jobDescription;
  }

  public void setJobDescription(String jobDescription) {
    this.jobDescription = jobDescription;
  }


  public String getJobStatus() {
    return jobStatus;
  }

  public void setJobStatus(String jobStatus) {
    this.jobStatus = jobStatus;
  }


  public long getCuetianPostId() {
    return cuetianPostId;
  }

  public void setCuetianPostId(long cuetianPostId) {
    this.cuetianPostId = cuetianPostId;
  }

}
