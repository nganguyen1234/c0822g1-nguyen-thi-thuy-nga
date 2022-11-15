package exercise3.model;

public class Treatment {
    private int order;
    private String doctorId;
    private String doctorName;
    private String patientId;
    private String patientName;
    private double cost;

    public Treatment() {
    }

    public Treatment(int order, String doctorId, String doctorName, String patientId, String patientName, double cost) {
        this.order = order;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.patientId = patientId;
        this.patientName = patientName;
        this.cost = cost;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "order=" + order +
                ", doctorId='" + doctorId + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", patientId='" + patientId + '\'' +
                ", patientName='" + patientName + '\'' +
                ", cost=" + cost +
                '}';
    }

    public String convertLine() {
        final String COMMA = ",";
        return order + COMMA + doctorId + COMMA + doctorName + COMMA + patientId + COMMA + patientName + COMMA + cost;
    }
}
