## 💻 Exercício

Exercício prático para uso de Fila Sincronizada (Synchronized Queue) e Exchanger

## 👨‍💻 Synchronized Queue
As Synchronized Queue são usadas quando um objeto em execução em um thread deve sincronizar com um objeto em execução em outro thread para entregar a ele alguma informação, evento ou tarefa.

Essa classe oferece suporte a uma política de imparcialidade opcional para solicitar encadeamentos de produtores e consumidores em espera. Por padrão, essa ordem não é garantida. No entanto, uma fila construída com imparcialidade definida como true concede acesso aos threads na ordem FIFO.

## 👨‍💻 Exchanger
Quando invocado, o exchange espera que o outro thread no par o chame também. Nesse ponto, o segundo thread descobre que o primeiro thread está esperando com seu objeto. O Thread troca os objetos que está segurando e sinaliza a troca, e agora eles podem retornar.
