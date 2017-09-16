# language: pt
# encoding: iso-8859-1
Funcionalidade: US002 Selecionar Ingresso
	Como gestor de eventos
	Quero ter in�meros tipos de ingresso
	Para que eu possa atingir v�rios n�veis de p�blico
	
	Contexto: 
		Dado que sou gestor do evento

	Esquema do Cen�rio: Deve selecionar o ingresso
		Dado que quero disponibilizar um ingresso "<categoria>"
		Quando selecionar o ingresso
		Ent�o o mesmo deve ter o valor "<valor>"
		
		Exemplos:
		| categoria   | valor |
		| VIP			    | 1000	|
		| BACKSTAGE   | 800   |
		| PLATEIA_VIP | 500   |
		| PLATEIA     | 300   |
