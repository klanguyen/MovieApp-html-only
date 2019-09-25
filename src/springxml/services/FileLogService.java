package springxml.services;

public class FileLogService implements LogService {
    @Override
    public String getLogMessage(String message) {
        return message;
    }

    @Override
    public void error(String message) {

    }
}
