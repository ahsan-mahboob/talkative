package ae.gov.dubaicustoms.tktlistener.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@Entity
@Table(name = "messages")
public class MessageObj implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MessageObj(String message) {
		super();
		this.message = message;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String message;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{id:").append(id).append(", message:'").append(message).append("'}");
		return builder.toString();
	}
    
}
