# spring-boot exception

# Referencias
    https://mkyong.com/spring-boot/spring-rest-error-handling-example/
    https://github.com/eugenp/tutorials/blob/master/spring-security-modules/spring-security-web-rest/src/main/java/com/baeldung/web/error/RestResponseEntityExceptionHandler.java
	https://github.com/brunocleite/spring-boot-exception-handling

# Dicas
    https://devwithus.com/exception-handling-spring-boot-rest-api/
    Manipular NoHandlerFoundException
Por padrão, o DispatcherServlet envia uma resposta 404 se não houver um manipulador para uma solicitação específica.

Portanto, para substituir o comportamento padrão de nosso Servlet e lançar NoHandlerFoundException , precisamos adicionar as seguintes propriedades ao arquivo application.properties .

spring.mvc.throw-exception-if-no-handler-found=true
spring.resources.add-mappings=false

Agora, podemos lidar com NoHandlerFoundException da mesma forma que fizemos com outras exceções.