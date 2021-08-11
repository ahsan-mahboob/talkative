package ae.gov.dubaicustoms.tktlistener.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import ae.gov.dubaicustoms.tktlistener.handler.SocketTextHandler;
import ae.gov.dubaicustoms.tktlistener.model.MessageObj;
import ae.gov.dubaicustoms.tktlistener.repository.MessageRepository;
import io.micrometer.core.annotation.Timed;

@Service
public class MsgListenerService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MessageRepository messageRepo;

	@JmsListener(destination = "${tkt.jms.msg.queue.address}")
	@Timed(value = "receiveMessage", description = "Time taken to receive message")
	public void receive(Message<?> message) throws IOException {
		log.info("Recieved Message: " + message.getPayload().toString());
		saveMessage(message.getPayload().toString());
	}

	@Timed(value = "saveMessage", description = "Time taken to save message")
	private void saveMessage(String msg) throws IOException {
		MessageObj _message = messageRepo.save(new MessageObj(msg));
		log.info("Message saved");
		for (WebSocketSession session : SocketTextHandler.sessions) {
			if (session.isOpen()) {
				//ObjectMapper objectMapper = new ObjectMapper();
				//session.sendMessage(new TextMessage(objectMapper.writeValueAsString(_message)));
				session.sendMessage(new TextMessage(_message.toString()));
				log.info("Message sent to client with id", session.getId());
			}
		}
	}
}
