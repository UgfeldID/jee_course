package ru.ugfeld.id.lec7.jms;

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.fasterxml.jackson.databind.ObjectMapper;

import ru.ugfeld.id.lec7.model.entities.Warehouse;
import ru.ugfeld.id.lec7.model.requests.ProductsRequest;



public class Requester {

	private static final Logger log = LoggerFactory.getLogger( Requester.class );
	private static final String PRODUCTS_REQUESTS_QUEUE_NAME = "products.request";
	private static final int PRODUCTS_QUEUE_SIZE = 10;
	private static final String ENCODING = "UTF-8";
	
	private JmsTemplate jmsTemplate;
	private Destination destination;
	
	public void request( )
	{
		try{
			ProductsRequest request = new ProductsRequest();
			request.setType( PRODUCTS_REQUESTS_QUEUE_NAME);
			request.setLimit(PRODUCTS_QUEUE_SIZE );
			request.setWarehouse( new Warehouse() );
			
			ObjectMapper jsonMapper = new ObjectMapper( );
			final String json = jsonMapper.writeValueAsString( request );
			final byte[ ] jsonb = json.getBytes( ENCODING );
			
			jmsTemplate.send( destination, new MessageCreator( ){				

				@Override
				public Message createMessage(Session session) 
						throws JMSException {
					
					BytesMessage msg = session.createBytesMessage( );
					msg.writeBytes( jsonb );
					
					return msg;
				}
			} );
			
		} catch (Exception e){
			log.info( "Ошибка при создании запроса", e );
		}
	}
	
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
}
