package ae.gov.dubaicustoms.tktsender.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ae.gov.dubaicustoms.tktsender.service.MsgSenderService;
import brave.sampler.Sampler;
import io.micrometer.core.annotation.Timed;

@RestController
@CrossOrigin
@RequestMapping("/message")
public class MsgSenderController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MsgSenderService senderService;

	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

	@PostMapping("send")
	@Timed(value = "sendMessage", description = "Time taken to send message")
	public ResponseEntity<HttpStatus> sendMessage(@RequestParam(required = true) String msg) {
		try {
			log.info("Request Received");
			senderService.send(msg);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
