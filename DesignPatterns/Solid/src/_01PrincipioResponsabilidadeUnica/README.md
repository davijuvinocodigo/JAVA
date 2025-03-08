**Single Responsability Principle**
- O princípio da responsabilidade única é o primeiro princípio da sigla sólida.
- Uma classe deve ter apenas uma razão para mudar.
- Cada módulo ou classe deve ter responsabilidade sobre uma única parte da funcionalidade fornecida pelo software, e essa responsabilidade deve ser inteiramente encapsulada pela classe.

Cenário do código: *Imagine o cenário de um software de navegação. Temos uma posição que se baseia na direção dada (norte, sul, oeste, leste) a posição deve mudar.*

## Cenário do diagrama sem SOLID
- A classe Posição contém valores relativos à posição do eixo x e y
- A direção é um enum representando a direção norte, leste, sul e oeste.
- E, finalmente, há uma classe Navigator que é responsável por navegar de acordo com a direção e mudança de posição.
- Para navegar corretamente, o navegador deve resolver a próxima posição com base na direção. Além disso, o navegador deve fixar a posição em casos de valores abaixo de 0.
![SINGLE](https://github.com/davijuvino/Backend/blob/main/Java/PadraoProjetos/SOLID/assets/DiagramaSemSOLID_Single.png)
*O problema com essa abordagem é que, caso os critérios de validade da posição mudem da classe Navigator. O mesmo se aplica no caso de mudanças nos mecanismos de movimento de posição. O navegador em vez de apenas navegar é responsável tanto por resolver a próxima posição quanto por fixar a nova posição.*

## Cenário do diagrama aplicando o SOLID
![SINGLE](https://github.com/davijuvino/Backend/blob/main/Java/PadraoProjetos/SOLID/assets/DiagramaComSOLID_Single.png)
*Uma abordagem que não quebra o princípio da responsabilidade única é criar uma classe que resolva a próxima posição e uma classe responsável pela fixação da nova posição.*
- A classe **ResolverProxPosicao** resolverá a próxima posição com base na direção dada.
- A classe **FixarPosicao** irá fixar a posição em caso de valores inválidos x ou y
- A classe Navigator terá como **dependências** as classes **ResolverProxPosicao** e **FixarPosicao** para executar a navegação corretamente.


**Refeencia: https://medium.com/@javatechie/solid-design-principle-java-ae96a48db97**