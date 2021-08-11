package ae.gov.dubaicustoms.tktlistener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ae.gov.dubaicustoms.tktlistener.model.MessageObj;

@Repository
public interface MessageRepository  extends JpaRepository<MessageObj, Long> {

}
