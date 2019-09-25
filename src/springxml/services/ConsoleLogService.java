package springxml.services;

public class ConsoleLogService implements LogService {
    @Override
    public String getLogMessage(String message) {
        return message;
    }

    @Override
    public void error(String message) {

    }
}
