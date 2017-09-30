# language: pt
# encoding: iso-8859-1
Funcionalidade: US003 Disponibilizar Ingressos
  Como gestor de eventos
  Quero  para cada evento disponibilizar variados tipos de ingressos com per�odo de vendas
  Para que eu possa atingir v�rios n�veis de p�blico

  Cenario: US003 Deve mostrar mensagem de erro se n�o for selecionado um evento
    Dado que nao seleciono nenhum evento
    E que informo a data de inicio e fim com valores validos
    Quando salvar o periodo de venda
    Entao deve mostrar a mensagem "Informe o evento."

  Cenario: US003 Deve mostrar mensagem de erro se n�o for informada data de inicio
    Dado que seleciono um evento para criar um periodo de venda
    E que nao informo data de inicio
    E que informo data de fim
    Quando salvar o periodo de venda
    Entao deve mostrar a mensagem "Informe a data de inicio."

  Cenario: US003 Deve mostrar mensagem de erro se n�o for informada data de fim
    Dado que seleciono um evento para criar um periodo de venda
    E que nao informo data de fim
    E que informo data de inicio
    Quando salvar o periodo de venda
    Entao deve mostrar a mensagem "Informe a data de fim."

  Cenario: US003 Deve mostrar mensagem de erro se data inicio for posterior a data de fim
    Dado que seleciono um evento para criar um periodo de venda
    E que informo a data de incio maior que a data de fim
    Quando salvar o periodo de venda
    Entao deve mostrar a mensagem "A data de inicio de venda deve ser inferior a data de fim."
    
    Cenario: US003 Deve permitir incluir um periodo de venda sem categoria de ingresso
    Dado que seleciono um evento para criar um periodo de venda
    E que informo a data de inicio e fim com valores validos
    E que nao seleciono nenhuma categoria de ingresso
    Quando salvar o periodo de venda
    Entao o periodo de venda e salvo
    
  Cenario: US003 Deve mostrar mensagem de erro se incluir uma categoria de ingresso ja existente em um periodo de venda
    Dado que tenho um periodo de venda cadastrado com a categoria de ingresso "VIP"
    E que adiciona a categoria "VIP" novamente
    Quando salvar o periodo de venda
    Entao deve mostrar a mensagem "Categoria de ingresso ja cadastrado para o periodo de venda."

  Cenario: US003 Deve cadastrar um periodo de venda com uma categoria de ingresso
    Dado que seleciono um evento para criar um periodo de venda
    E que seleciono a categoria "PLATEIA"
    E que informo a data de inicio e fim com valores validos
    Quando salvar o periodo de venda
    Entao o periodo de venda e salvo
    E a categoria de ingresso foi associada

  Cenario: US003 Deve permitir cadastrar nova categoria de ingresso para um periodo de venda existente
    Dado que tenho um periodo de venda cadastrado com a categoria de ingresso "VIP"
    Dado que seleciono a categoria "PLATEIA"
    Quando salvar o periodo de venda
    Entao o periodo de venda e salvo
    E a categoria de ingresso foi associada
