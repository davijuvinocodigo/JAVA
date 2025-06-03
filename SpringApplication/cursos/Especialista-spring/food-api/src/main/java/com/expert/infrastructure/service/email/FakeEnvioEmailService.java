package com.expert.infrastructure.service.email;

import com.expert.domain.service.EnvioEmailService;
import org.springframework.beans.factory.annotation.Autowired;



import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FakeEnvioEmailService implements EnvioEmailService {

	@Autowired
	private ProcessadorEmailTemplate processadorEmailTemplate;
	
	@Override
	public void enviar(Mensagem mensagem) {
		String corpo = processadorEmailTemplate.processarTemplate(mensagem);

		log.info("[FAKE E-MAIL] Para: {}\n{}", mensagem.getDestinatarios(), corpo);
	}

}
