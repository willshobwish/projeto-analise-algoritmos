import datetime
import Heapsort
import numpy as np
import random 
import matplotlib.pyplot as plt
import Bubblesort

def shuffle(vetor):
    inicio = datetime.datetime.now()
    random.shuffle(vetor)
    print(f"Shuffle realizado em: {datetime.datetime.now()-inicio}")

def heapsort(vetor,tempos):
    inicio = datetime.datetime.now()
    Heapsort.heapSort(vetor)
    tempos.append((datetime.datetime.now()-inicio).total_seconds())
    print(f"Heapsort realizado em: {datetime.datetime.now()-inicio}")

def bubble(vetor,tempos):
    inicio = datetime.datetime.now()
    Bubblesort.bubbleSort(vetor)
    tempos.append((datetime.datetime.now()-inicio).total_seconds())
    print(f"Bubblesort realizado em: {datetime.datetime.now()-inicio}")

def ordem_crescente(vetor, dicionario,vetor_quantidade):
    vetor = np.arange(0,step*(i+1),1)
    print(f"{i}/{quantidade_divisao}")
    vetor_heap= vetor.copy()
    vetor_bubble= vetor.copy()
    vetor_quantidade.append(len(vetor))
    heapsort(vetor_heap,dicionario["Heapsort"])
    bubble(vetor_bubble,dicionario["Bubblesort"])
    print()

def ordem_decrescente(vetor, dicionario,vetor_quantidade):
    vetor = np.arange(0,step*(i+1),1)
    vetor[::-1].sort()
    print(f"{i}/{quantidade_divisao}")
    vetor_heap= vetor.copy()
    vetor_bubble= vetor.copy()
    vetor_quantidade.append(len(vetor))
    heapsort(vetor_heap,dicionario["Heapsort"])
    bubble(vetor_bubble,dicionario["Bubblesort"])
    print()

def aleatorio(vetor, dicionario):
    print(f"{i}/{quantidade_divisao}")
    shuffle(vetor)
    vetor_heap= vetor.copy()
    vetor_bubble= vetor.copy()
    quantidade_elemento.append(len(vetor))
    heapsort(vetor_heap,dicionario["Heapsort"])
    bubble(vetor_bubble,dicionario["Bubblesort"])
    print()

quantidade_elemento = []
dicionario_todos = {}
dicionario = {"Heapsort":[],"Bubblesort":[]}
quantidade_divisao_tempo_grafico = 20
quantidade_elemento_grafico = 30

for i in ["Ordem crescente","Ordem decrescente","Aleatorio"]:
    dicionario_todos[i]=dicionario

print(dicionario_todos)

quantidade_divisao = int(input("Quantidade de vetor: "))
maximo = int(input("Numero de elementos maximos em um vetor: "))
quantidade = np.arange(0,)
step = maximo/quantidade_divisao

for i in range(0,quantidade_divisao,1):
    vetor = np.arange(1,step*(i)+1,1)
    ordem_crescente(dicionario=dicionario_todos['Ordem crescente'],)
    ordem_decrescente()
    aleatorio()


tempo_maximo = []
for labels in dicionario.keys():
    tempo_maximo.extend(dicionario[labels])
    plt.plot(quantidade_elemento,dicionario[labels],label=labels)
    

plt.grid()
plt.yticks(np.arange(np.min(tempo_maximo),np.max(tempo_maximo)+np.max(tempo_maximo)/quantidade_divisao_tempo_grafico,np.max(tempo_maximo)/quantidade_divisao_tempo_grafico))
plt.xticks(quantidade_elemento,rotation=45)
plt.xlabel("Quantidade de elementos no vetor")
plt.ylabel("Tempo em segundos")
plt.legend()
plt.show()