# language: pt
# encoding: iso-8859-1
Funcionalidade: US003 Disponibilizar Ingressos
  Como gestor de eventos
  Quero  para cada evento disponibilizar variados tipos de ingressos com per�odo de vendas
  Para que eu possa atingir v�rios n�veis de p�blico

  Cenario: US003 Deve mostrar mensagem de erro se data in�cio for posterior a data de fim
  Dado que seleciono um evento para criar um periodo de venda
  E que informa a data de in�cio maior que a data de fim
  Quando salvar o periodo de venda
  Entao deve mostrar a mensagem "A data de in�cio de venda deve ser inferior a data de fim."
  
  Cenario: US003 Deve mostrar mensagem de erro se incluir uma categoria de ingresso ja existente em um periodo de venda
  Dado que tenho um periodo de venda cadastrado com a categoria de ingresso "VIP"
  E que adiciona a categoria "VIP" novamente
  Quando salvar o periodo de venda
  Entao deve mostrar a mensagem "Categoria de ingresso j� cadastrado para o per�odo de venda."
  
  Cenario: US003 Deve cadastrar um periodo de venda com uma categoria de ingresso
  Dado que seleciono a categoria "PLATEIA"
  E que informo valores validos para data final e inicial
  Quando salvar o periodo de venda
  Entao deve cadastrar o periodo de venda
  
  Cenario: US003 Deve permitir cadastrar nova categoria de ingresso para um periodo de venda existente
  Dado que tenho um periodo de venda cadastrado com a categoria de ingresso "VIP"
  Dado que seleciono a categoria "PLATEIA"
  Quando salvar o periodo de venda
  Entao deve mostrar a mensagem "Categoria de ingresso j� cadastrado para o per�odo de venda."