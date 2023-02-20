## 💻 Exercício

Exercício prático para uso de CountDownLatch

## 👨‍💻 CountDownLatch
A classe CountDownLatch é uma classe importante para execução simultânea. É um auxílio de sincronização que permite que um ou mais threads esperem até que um conjunto de operações executadas em outro thread seja concluído.

Ele inicializa com o count, que passamos para o construtor. A invocação do método countDown() faz com que os métodos await sejam bloqueados até que a contagem atual chegue a zero, após o que todos os encadeamentos em espera são liberados e quaisquer invocações subsequentes de await retornam imediatamente. CountDownLatch não exige que o thread countdown() espere que a contagem chegue a zero antes de prosseguir. Isso evita que qualquer thread passe e aguarde até que todos os threads possam passar.
