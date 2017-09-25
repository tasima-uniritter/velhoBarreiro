# language: pt
# encoding: iso-8859-1
Funcionalidade: US001 Criar Evento
  Como gestor de eventos
  Quero ter a possibilidade de criar eventos
  Para que meus clientes tenham conhecimento de eventos e suas datas

  Cenario: Deve validar obrigatoriedade do campo nome
    Dado que quero criar um evento
    E que nao informo o nome
    E que informo data de validade
    Quando salvar o evento
    Entao deve exibir a mensagem de obrigatoriedade "Informe o Nome."

  Cenario: Deve validar obrigatoriedade do campo data de validade
    Dado que quero criar um evento
    E que nao informo a data de validade
    E que informo o nome
    Quando salvar o evento
    Entao deve exibir a mensagem de obrigatoriedade "Informe a Data de Validade do Evento."

  Cenario: Deve validar se o campo nome possui no máximo 150 caracteres
    Dado que quero criar um evento
    E que informo um nome com mais de 150 caracteres
    E que informo data de validade
    Quando salvar o evento
    Entao deve exibir a mensagem "O nome permite no máximo 150 caracteres."

  Cenario: Deve validar se a data de validade menor que a data atual
    Dado que quero criar um evento
    E informo uma data de validade menor que a data atual
    E que informo o nome
    Quando salvar o evento
    Entao deve exibir a mensagem "A data do evento deve ser igual ou maior que a de hoje."

  Esquema do Cenario: Deve salvar um evento
    Dado que quero criar um evento
    E que informo o nome
    E que informo data de validade com valor "<data>"
    Quando salvar o evento
    Entao deve salvar o evento
    E nao deve exibir mensagem de erro

    Exemplos: 
      | data   |
      | hoje   |
      | futuro |
