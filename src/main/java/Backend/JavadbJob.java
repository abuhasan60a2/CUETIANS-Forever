package Backend;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JavadbJob {

  private static long id;
  private String jobTitle;
  private String jobDescription;
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

  public long getCuetianPostId() {
    return cuetianPostId;
  }

  public void setCuetianPostId(long cuetianPostId) {
    this.cuetianPostId = cuetianPostId;
  }
  public JavadbJob(ResultSet rs){
    try {
      this.jobTitle = rs.getString("job_title");
      this.jobDescription = rs.getString("job_description");
      this.cuetianPostId = rs.getLong("cuetian_post_id");
    }
    catch(SQLException e){
      throw new RuntimeException(e);
    }
  }

  public static void insertjobdata(String jobTitle, String jobDescription, long postid) throws SQLException {
    Connection source = db.makeConnections();
    PreparedStatement statement = source.prepareStatement("INSERT INTO `javadb_job` (`id`, `job_title`, `job_description`, `cuetian_post_id`) VALUES (NULL, ?, ?, ?)");
    System.out.println("insertjob block");
    statement.setString(1, jobTitle);
    statement.setString(2, jobDescription);
    statement.setLong(3, postid);
    statement.execute();
    statement.close();
  }

}
