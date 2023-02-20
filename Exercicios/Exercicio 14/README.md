## 💻 Exercício

Exercício prático para uso dos modificadores Volatile e Yield

## 👨‍💻 Volatile
O modificador Volatile basicamente informa a JVM para ter cuidado com as Threads que estão sendo executadas simultaneamente. Essencialmente, volatile é usado para indicar que o valor de uma variável será modificado por diferentes threads.

Declarar uma variável Java com volatile significa:
O valor dessa variável nunca será armazenado em cache localmente: todas as leituras e gravações irão direto para a "main memory"
O acesso à variável atua como se estivesse dentro de um bloco sincronizado.

## 👨‍💻 Yield
Fornece um mecanismo para informar ao “agendador” que o thread atual está disposto a abandonar seu uso atual do processador, mas gostaria de ser agendado novamente o mais rápido possível. O “agendador” é livre para aderir ou ignorar essas informações e, de fato, tem comportamento variável dependendo do sistema operacional.
