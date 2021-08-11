package ae.gov.dubaicustoms.tktindex.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ae.gov.dubaicustoms.tktindex.model.MessageObj;


@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "messages", path = "messages")
public interface MessageRepository  extends PagingAndSortingRepository<MessageObj, Long> {

}
