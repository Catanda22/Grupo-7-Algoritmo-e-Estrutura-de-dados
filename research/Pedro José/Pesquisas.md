# Vantagens das tabelas hash
As Principais vantagens das tabelas são a velocidade em operações de busca, inserção e remoção (próximo ao tempo constante, 0 (1)), a eficiência em lidar com grandes volumes de dados, a flexibilidade para armazenar diversos tipos de dados (pares chave-valor) e a simplicidade na implementação e uso para mapeamento rapido, sendo fundamentais em caches, bancos de dados e dicionários.
## Detalhadamente temos as seguintes vantagens: 
•	Alta eficiência na operação de busca quase contante para encontrar um item. Em vez de percorrer toda a estrutura como em um array, a função hash calcula directamente a posição (indice) do dado, independentemente do tamanho da tabela; 
•	Caso médio é O(1) enquanto o da busca linear é O(N) e a da busca binária é O(log2 N);
•	Tempo de busca é praticamente independente do número de chaves armazenadas na tabela;
•	 Implementação simples;
•	Escalabilidade: O desenpenho não degrada significativamente com aumento do número de elementos , pois a busca permanece rápida;
•	Flexibilidade: podem armazenar e acessar qualquer tipo de dado, desde que haja uma função hash para a chave;
•	Simplicidade: A lógica para implenentar tabelas hash relativamente directa, facilitando o desenvolvimento;
•	Uso em em Aplicações Reais: Essenciais para caching (navegadores), bancos de dados, dicionários/mapas (associative arrays), e autenticação de usuários (armazenamento de senhas);
•	Estrutura Dinâmica: Podem crescer ou diminuir conforme a necessidadede dado.
Em resumo, as tabelas hash são ideias para cenários que exigem um acessoe recuperação de dados extremamente rápidos e eficientes.
# Aplicações das Tabelas Hash
• A tabela hash pode ser utilizada para busca de elementos em base de dados ,estruturas de dados em memória, bancos de dados e mecanismos de busca na Internet; 
verificação de integridade de dados e autenticação de mensagens os dados são enviados juntamente com o resultado da função de hashing ;
 Quem receber os dados recalcula a função de hashing usando os dados recebidos e compara o resultado obtido com o que ele recebeu;
 Resultados diferentes: erro de transmissão.
• A tabela hash pode ser utilizada para armazenamento de senhas com segurança;
A senha não é armazenada no servidor, mas sim o resultado da função de hashing;
Implementação da tabela de símbolos dos compiladores;
Criptografia MD5 e família SHA (Secure Hash Algorithm).
Em resumo as tabelas hash são usadas para armazenamento e recuperação rápida de dados (O(1)), implementando dicionários e caches, verificando duplicatas, gerenciando senhas (hashing de senhas), e em compiladores (tabelas de símbolos), além de segurança digital, como assinaturas digitais e verificação de integridade, permitindo acesso eficiente em base de dados e sistemas operacionais.

