package api.service;

public interface SendService {

    void sendMessage(String message);

    void sendFanout(String message);

    void sendTopic(String message);

    void sendSimpleQueue(String message);
}
