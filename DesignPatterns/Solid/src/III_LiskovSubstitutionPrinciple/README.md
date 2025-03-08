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
![SINGLE](https://github.com/davijuvino/Backend/blob/main/Java/PadraoProjetos/SOLID/assets/DiagramaComSOLID_Single.png)
*Uma abordagem que não quebra o princípio da responsabilidade única é criar uma classe que resolva a próxima posição e uma classe responsável pela fixação da nova posição.*
- A classe **ResolverProxPosicao** resolverá a próxima posição com base na direção dada.
- A classe **FixarPosicao** irá fixar a posição em caso de valores inválidos x ou y
- A classe Navigator terá como **dependências** as classes **ResolverProxPosicao** e **FixarPosicao** para executar a navegação corretamente.
