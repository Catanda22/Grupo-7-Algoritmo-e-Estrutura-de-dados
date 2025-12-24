#Funções de Hash
Hashing é uma técnica na qual, quando fornecemos dados de tamanho arbitrária a uma função, obtemos um valor pequeno e simplificado. Essa função é chamada de função hash. 
O hashing usa uma função hash para mapear as chaves para outra faixa de dados de tal forma que uma nova faixa de chaves possa ser usada como um índice na tabela hash; em outras palavras, o hashing é usado para converter os valores das chaves em valores inteiros, que podem ser usados como índice na tabela hash. Em nossas discussões neste capítulo, estamos usando hashing para converter strings em inteiros. Poderíamos ter usado qualquer outro tipo de dados em vez de strings que possam ser convertidos em inteiros. 
Vamos pegar um exemplo: Digamos que queremos fazer o hash da expressão "helloworld" ou seja, queremos obter um valor numérico correspondente a essas tring que possa ser usado como índice na tabela hash. 
No Python, a função ord() retorna um valor inteiro único (conhecido como valores ordinais) que é mapeado para um caractere no sistema de codificação Unicode. Os valores ordinais mapeiam o caractere Unicode para uma representação numérica exclusiva, desde que o caractere seja compatível com Unicode, por exemplo, os números 0-127 são mapeados para caracteres ASCII, que também correspondem aos valores ordinais nos sistemas Unicode. No entanto, a faixa de codificação Unicode pode ser maior. Portanto, a codificação Unicode é um superconjunto do ASCII. Por exemplo, no Python, obtemos um valor ordinal exclusivo 102 para o caractere 'f' usando ord ('f'). Além disso, para obter o hash de toda as tring, podemos simplesmente somar os números ordinais de cada caractere na string. 
Veja o seguinte trecho de código:
Sum (map(ord, 'helloworld')) 
SAÍDA:
 Na saída acima, obtemos um valor numérico, 1116, para a string "helloworld", que é o hash da string fornecida. Considere a Figura 8. 2 a seguir para ver os valores ordinais de cada caractere na string que resulta no valor hash 1116:
h	e	I	I	o		w	o	r	l	d
104	101	108	108	111	32	119	111	114	108	100

= 1116
Figure 8.2: Ordinal values of each character for the hello world string
#Colisões
Colisões ocorrem quando a função hash gera o mesmo índice para duas ou mais chaves diferentes. Existem várias técnicas para lidar com colisões:
Encadeamento Separado: Cada bucket no array armazena uma lista ligada de todos os pares de chave-valor que compartilham o mesmo índice. Essa abordagem é simples de implementar, mas pode levar a listas longas em caso de muitas colisões.
Endereçamento Aberto: Quando ocorre uma colisão, a Tabela Hash busca a próxima posição livre no array para armazenar o novo par chave-valor. Existem várias estratégias de endereçamento aberto, como sondagem linear, sondagem quadrática e duplo hashing.
Implementação em Python e TypeScript
A implementação de uma Tabela Hash pode variar dependendo da linguagem de programação e dos requisitos específicos, mas os princípios fundamentais permanecem os mesmos.
Causas das Colisões 
Número de Chaves: Quando o conjunto de chaves (U) é maior que o tamanho da tabela (m), é inevitável que ocorram colisões.
Função Hash: Uma função hash mal projetada pode aumentar a probabilidade de colisões, pois pode não distribuir as chaves uniformemente entre os índices da tabela. 




#Métodos de Tratamento de Colisões
Existem várias técnicas para lidar com colisões em tabelas hash, sendo as mais comuns temos:
1.	Encadeamento: Neste método, cada posição da tabela contém uma lista encadeada de elementos que colidiram. Quando uma nova chave gera uma colisão, ela é adicionada à lista correspondente. Isso permite armazenar múltiplas chaves no mesmo índice sem perder dados. 
Vantagens:
•	¬Simplicidade de implementação.
•	Não requer redimensionamento da tabela hash, pois a lista pode crescer conforme necessário.
Desvantagens:
•	Pode levar a listas longas se muitas colisões ocorrerem, o que pode degradar o desempenho para operações de busca e inserção.

2.	Endereçamento Aberto: Neste método, quando ocorre uma colisão, a tabela é percorrida em busca da próxima posição livre. Isso pode ser feito de várias maneiras, tais como:
•	Sondagem Linear: A próxima posição é verificada sequencialmente até encontrar uma vaga.
•	Sondagem Quadrática: A distância entre as sondagens aumenta quadraticamente.
•	Duplo Hashing: Uma segunda função hash é utilizada para determinar a próxima posição a ser verificada. 

##Vantagens:
•	Utiliza menos memória do que o encadeamento separado, pois todos os elementos são armazenados diretamente na tabela.
•	Pode ser mais eficiente em termos de tempo se a tabela estiver bem dimensionada e as colisões forem raras.
##Desvantagens:
•	O desempenho pode degradar rapidamente se muitas colisões ocorrerem, levando a um fenômeno conhecido como "clustering".




