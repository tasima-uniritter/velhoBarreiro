# language: pt
# encoding: iso-8859-1
Funcionalidade: US001 Criar Evento
  Como gestor de eventos
  Quero ter a possibilidade de criar eventos
  Para que meus clientes tenham conhecimento de eventos e suas datas

  Cenário: Deve validar obrigatoriedade do campo nome
    Dado que quero criar um evento
    E que não informo o nome
    E que informo data de validade
    Quando salvar o evento
    Então deve exibir a mensagem de obrigatoriedade "Informe o Nome."

  Cenário: Deve validar obrigatoriedade do campo data de validade
    Dado que quero criar um evento
    E que não informo a data de validade
    E que informo o nome
    Quando salvar o evento
    Então deve exibir a mensagem de obrigatoriedade "Informe a Data de Validade do Evento."

  Cenário: Deve validar se o campo nome possui no máximo 150 caracteres
    Dado que quero criar um evento
    E que informo um nome com mais de 150 caracteres
    E que informo data de validade
    Quando salvar o evento
    Então deve exibir a mensagem "O nome permite no máximo 150 caracteres."

  Cenário: Deve validar se a data de validade é menor que a data atual
    Dado que quero criar um evento
    E informo uma data de validade menor que a data atual
    E que informo o nome
    Quando salvar o evento
    Então deve exibir a mensagem "A data do evento deve ser igual ou maior que a de hoje."

  Cenário: Deve salvar um evento
    Dado que quero criar um evento
    E que informo o nome
    E que informo data de validade
    Quando salvar o evento
    Então deve salvar o evento
    E não deve exibir mensagem de erro
