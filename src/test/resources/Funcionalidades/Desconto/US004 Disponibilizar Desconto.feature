# language: pt
# encoding: iso-8859-1
Funcionalidade: US004 Disponibilizar Desconto
  Como gestor de eventos
  Quero  disponibilizar descontos em ingressos conforme a lei e também para o meu programa de associados
  Para que eu possa atender a lei e dar vantagens para meus associados

  Esquema do Cenario: US004 Deve disponibilizar desconto de acordo com o tipo de cliente
    Dado que tenho um cliente do tipo "<tipoCliente>"
    E que o valor do ingresso é "100" pilas
    Quando calcular o desconto
    Então o cliente ganhara "<percentualDesconto>"
    Então o cliente pagara o valor "<valorPago>"

    Exemplos: 
      | tipoCliente      | percentualDesconto | valorPago |
      | ClienteEstudante |                0.5 |        50 |
      | ClienteIdoso     |                0.5 |        50 |
      | ClienteGold      |               0.25 |        25 |
      | ClienteSilver    |                0.4 |        40 |
      | ClienteGeral     |                1.0 |       100 |
