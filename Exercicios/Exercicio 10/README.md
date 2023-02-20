## 💻 Exercício

Exercício prático para uso de metodos Sincronizados (Synchronized)

## 👨‍💻 Synchronized
Na partilha de dados entre tarefas é necessário garantir que os dados estão consistentes. Caso a sincronização não seja implementada, pode ocorrer interferência entre tarefas, levando a situações de inconsistência nos dados partilhados. Por outro lado, a presença de mecanismos de sincronização pode originar contenção quando duas ou mais tarefas tentam aceder ao mesmo recurso em simultâneo. Se apenas existir leitura de dados partilhados por parte das tarefas concorrentes, estes problemas não se colocam.

Cada objeto Java tem um trinco lógico (mutex) próprio, que pode ser (implicitamente) adquirido através da primitiva synchronized.

A primitiva synchronized é aplicada a métodos do objeto e oferece um mecanismo de exclusão mútua a um recurso partilhado, que previne a reordenação do código pelo compilador. Um método sincronizado adquire o trinco do objeto no início de execução e liberta-o no fim.
