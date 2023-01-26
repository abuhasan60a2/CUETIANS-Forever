package Backend;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JavadbReport {

  private long id;
  private String reportTitle;
  private String reportDescription;
  private long cuetianId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getReportTitle() {
    return reportTitle;
  }

  public void setReportTitle(String reportTitle) {
    this.reportTitle = reportTitle;
  }


  public String getReportDescription() {
    return reportDescription;
  }

  public void setReportDescription(String reportDescription) {
    this.reportDescription = reportDescription;
  }


  public long getCuetianId() {
    return cuetianId;
  }

  public void setCuetianId(long cuetianId) {
    this.cuetianId = cuetianId;
  }

  public JavadbReport(ResultSet rs){
    try {
      this.reportTitle = rs.getString("job_title");
      this.reportDescription = rs.getString("job_description");
      this.cuetianId = rs.getLong("cuetian_post_id");
    }
    catch(SQLException e){
      throw new RuntimeException(e);
    }
  }
  public static void InsertReportData(String reportTitle, String reportDescription, long postid) throws SQLException {
    Connection source = db.makeConnections();
    PreparedStatement statement = source.prepareStatement("INSERT INTO `javadb_report` (`id`, `report_title`, `report_Description`, `cuetian_id`) VALUES (NULL, ?, ?, ?)");
    System.out.println("insertjob block");
    statement.setString(1, reportTitle);
    statement.setString(2, reportDescription);
    statement.setLong(3, postid);
    statement.execute();
    statement.close();
  }

}
