#language:pt

Feature:
Como gestor de eventos
Quero ter a possibilidade de criar eventos
Para que meus clientes tenham conhecimento de eventos e suas datas

Scenario: deve validar obrigatoriedade do campo nome
Given que quero criar um evento 
And que não informo o nome
And que informo data de validade
When salvar o evento
Then deve exibir a mensagem de obrigatoriedade "Informe o Nome."

Scenario: deve validar obrigatoriedade do campo data de validade
Given que quero criar um evento 
And que não informo a data de validade
And que informo o nome
When salvar o evento
Then deve exibir a mensagem de obrigatoriedade "Informe a Data de Validade do Evento."

Scenario: deve validar se o campo nome possui no máximo 150 caracteres
Given que quero criar um evento 
And que informo um nome com mais de 150 caracteres 
And que informo data de validade
When salvar o evento
Then deve exibir a mensagem "O nome permite no máximo 150 caracteres."

Scenario: deve validar se a data de validade é menor que a data atual
Given que quero criar um evento 
And informo uma data de validade menor que a data atual
And que informo o nome
When salvar o evento
Then deve exibir a mensagem "A data do evento deve ser igual ou maior que a de hoje."

Scenario: deve salvar um evento
Given que quero criar um evento 
And que informo o nome
And que informo data de validade
When salvar o evento
Then deve salvar o evento 
And não deve exibir mensagem de erro