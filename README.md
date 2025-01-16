# Challenge-Alura---Conversor-de-moedas

## Autor

**Vitor Silva**

## Descrição 

Esse projeto proposto na formação Java e orientação a objetos G7 é um conversor de moedas feito na linguagem Java que a partir de um simples menu de interação com usuário, converte uma moeda escolhida em outro tipo de moeda, considerando a taxa de conversão em tempo real. Para a conversão em tempo real foi utilizado a API ExchangeRate do site https://www.exchangerate-api.com/.

## Funcionalidades

1. **Conversão de Moedas**: Permite a conversão entre diferentes moedas utilizando taxas de câmbio em tempo real.
2. **Atualização em Tempo Real**: As taxas de câmbio são atualizadas automaticamente, garantindo informações precisas.
3. **Interface Simples**: Fácil de usar, com uma interface intuitiva para facilitar a interação do usuário.
4. **Acesso Gratuito**: Utiliza a Exchange Rate API, que é gratuita e acessível para todos os usuários.
5. **Suporte a Múltiplas Moedas**: Oferece suporte para várias moedas, permitindo conversões diversificadas.


## Relato de desenvolvimento

O meu maior aprendizado nesse projeto além de consolidar tudo que aprendi nas etapas teoricas anteriores, diria que foi a aprender a implementação do atributo do tipo Map. No processo de resgatar o valor de uma moeda em relação a outra para realizar a lógica de conversão que é o valor digitado pelo usuário vezes o valor da moeda destino em relação a moeda origem (ex: 1 USD sendo moeda origem vale aproximademente 6 BRL sendo essa a moeda destino) precisando fazer a desserialização de um objeto de Json para Java eu me deparei com uma estrutura diferente desse json, sendo:

"conversion_rates":{
  "USD":1,
  "AED":3.6725,
  "AFN":73.3681,
...

Anteriormente, eu apenas precisava imprimir o json completo convertido em um objeto Java, agora eu precisaria resgatar um valor especifico dentro de vários outros de uma estrutura que eu nunca tinha visto (conversion_rates: - um conjunto de taxas de conversão que representa os objetos json em pares de chave-valor) . Por conta de ser algo novo eu precisei procurar formas que eu ainda não tinha aprendido para fazer essa desserialização e foi aí que aprendi o Map , um tipo de dado que assim como o como o "conversion_rates" representa um conjunto objetos chave-valor. Criando uma classe chamada TipoDeMoeda do tipo record eu defini um atributo map contendo uma String e um Double assim como o json, nomeando como conversion_rates e podendo então resgatar o valor da moeda destino com o nome da chave, ex:

tipoDeMoeda.conversion_rates().get(moedaDestino);

Sendo a moedaDestino o nome da moeda que usuário pode escolher para fazer a conversão (USD,ARS,BRL...)
