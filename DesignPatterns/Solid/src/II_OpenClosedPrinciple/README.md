**Open Closed Principle**
- O princípio aberto/fechado é o segundo princípio na linha em relação à sigla princípios sólidos.
- As entidades de software (classes, módulos, funções, etc.) devem estar abertas para extensão, mas fechadas para **modificação**.
- Ao empregar esse princípio, o objetivo é estender o comportamento de um módulo sem modificar seu código fonte.

Cenário do código: *Imagine um cenário de aplicação de desconto em um de nossos produtos. Um serviço de desconto aplicará o desconto especificado e devolverá o preço com desconto.*

## Cenário do diagrama sem SOLID
- Atualmente nosso sistema tem apenas um tipo de desconto que se aplica a todos os adultos.
- E o serviço de desconto aplica-se este desconto ao preço dado.
- No entanto, nossa empresa quer oferecer um desconto para idosos, assim temos o desconto sênior.
- Isso torna as coisas um pouco mais complicadas para o serviço de desconto, já que o serviço tem que aplicar tanto o desconto para adultos quanto tanto o desconto para idosos.
![OPENCLOSED](https://github.com/davijuvino/Backend/blob/main/Java/PadraoProjetos/SOLID/assets/DiagramaSemSOLID_OpenClosed.png)
*Ao fazer isso, modificamos o código de origem do **serviço de desconto** para estender seu comportamento. Também para cada desconto diferente que o departamento de vendas for incluir, o serviço de desconto terá métodos extras.*

## Cenário do diagrama aplicando o SOLID
![OPENCLOSED-2](https://github.com/davijuvino/Backend/blob/main/Java/PadraoProjetos/SOLID/assets/DiagramaComSOLID_OpenClosed.png)
*Vamos implementar os principios solid em que, o serviço de descontos poderá aplicar diferentes descontos sem alterar seu código-fonte.*
- Para seguir o princípio aberto/fechado, criaremos uma **interface** de desconto.
- O desconto padrão será renomeado para DescontoAdulto e implementará a interface de desconto.
- A DescontoSenior também implementará a **interface** Desconto.
- Por último, mas não menos importante, nosso DescontoService será refatorado para aplicar descontos com base na **interface** Desconto.
- Com tudo implementadob supondo que queremos ter um desconto básico para ser aplicado extra quando um desconto é aplicado.
- *Ao estender a classe DescontoBasico, podemos ter mais descontos com o comportamento da DescontoBasico e também estender esse comportamento sem modificar o código de origem DescontoBasico.*
