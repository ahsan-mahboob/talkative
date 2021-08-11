package ae.gov.dubaicustoms.tktsender.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MsgSenderService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${tkt.jms.msg.queue.address}")
	String destinationQueue;
	
	public void send(String msg){
		log.info("in MsgSenderService:send()");
		jmsTemplate.convertAndSend(destinationQueue, msg);
		log.info("Message sent");
	}
	
}
