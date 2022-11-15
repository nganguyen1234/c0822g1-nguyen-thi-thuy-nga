package exercise3.service;

public interface IPatientService {
    public void showPatientData();
    public boolean checkId(String id);
    public String getPatientName(String id);
    public boolean isVip(String id);
}
