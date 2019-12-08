package server.employee.model;

public class Employee {
    private Long employeeId;
    private String name;
    private String practiceArea;
    private String designation;
    private String companyInfo;


    public Employee(Long employeeId, String name, String practiceArea, String designation, String companyInfo) {
        this.employeeId = employeeId;
        this.name = name;
        this.practiceArea = practiceArea;
        this.designation = designation;
        this.companyInfo = companyInfo;
    }


    public Employee() {

    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPracticeArea() {
        return practiceArea;
    }

    public void setPracticeArea(String practiceArea) {
        this.practiceArea = practiceArea;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", name=" + name + ", practiceArea=" + practiceArea
                + ", designation=" + designation + ", companyInfo=" + companyInfo + "]";
    }

}