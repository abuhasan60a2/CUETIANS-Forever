package Backend;


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

}
