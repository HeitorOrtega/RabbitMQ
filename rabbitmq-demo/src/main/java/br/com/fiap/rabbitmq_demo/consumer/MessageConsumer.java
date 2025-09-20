package br.com.fiap.rabbitmq_demo.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    private static final Logger log = LoggerFactory.getLogger(MessageConsumer.class);

    @Value("${app.rabbitmq.queue}")
    private String queueName;

    // Define a função como um listener para a fila especificada
    public void receiveMessage(String message){
        log.info("Recebida mensagem da fila '{}': '{}'", queueName, message);
        // Aqui a gente faria o processamento real da mensagem
        //ex: enviar um email, chamar um microserviço, etc
        try{
            Thread.sleep(100);
            log.info("Mensagem processada com sucesso");
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            log.info("Erro ao processar mensagem");
        } catch (Exception e){
            log.error("Erro inesperado ao processar mensagem: '{}'", message);
        }
    }
}
