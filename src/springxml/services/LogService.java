package springxml.services;

public interface LogService {
    public String getLogMessage(String message);
    void error(String message);
}
