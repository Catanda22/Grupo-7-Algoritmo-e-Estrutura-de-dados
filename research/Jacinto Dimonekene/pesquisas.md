
 Contextualização da Implementação 
A presente implementação prática tem como objetivo demonstrar a aplicação dos 
Algoritmos em Grafos na resolução de um problema do mundo real, 
nomeadamente a identificação de zonas urbanas com iluminação pública 
inadequada. O grafo foi representado por meio de listas de adjacência, pois esta 
estrutura permite armazenar de forma eficiente as ligações entre as zonas. As 
ligações foram consideradas não direcionadas, uma vez que as ruas permitem 
deslocamento nos dois sentidos. 
O problema consiste em identificar zonas da cidade que não possuem ligação 
com a rede principal de iluminação pública. Essas zonas são consideradas áreas 
com iluminação inadequada, uma vez que não estão conectadas a zonas 
iluminadas. De forma simplificada, pretende-se responder à seguinte questão: 
Quais zonas da cidade não estão conectadas à rede de iluminação 
existente? 
4.2 Modelação do Problema com Grafos 
Para a resolução do problema, a cidade foi modelada como um grafo não 
direcionado, onde: 
• Cada vértice representa uma zona da cidade; 
• Cada aresta representa uma ligação entre duas zonas por meio de ruas 
com iluminação; 
• A ausência de ligação indica falta de cobertura da rede de iluminação. 
Essa modelação permite analisar a conectividade da rede de forma eficiente e 
estruturada. 
4.3 Algoritmo Utilizado 
4.4 Estruturas de Dados Utilizadas 
