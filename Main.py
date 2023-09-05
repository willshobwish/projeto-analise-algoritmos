import datetime
import Heapsort
import numpy as np
import random 
import matplotlib.pyplot as plt
import Bubblesort
import Quicksort

def shuffle(vetor):
    inicio = datetime.datetime.now()
    random.shuffle(vetor)
    print(f"Shuffle realizado em: {datetime.datetime.now()-inicio}")
    # print(vetor)


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

def quicksort_comeco(vetor,tempos):
    inicio = datetime.datetime.now()
    Quicksort.quickSort(vetor,0,len(vetor)-1)
    tempos.append((datetime.datetime.now()-inicio).total_seconds())
    print(f"Quicksort realizado em: {datetime.datetime.now()-inicio}")

def quicksort_meio(vetor,tempos):
    inicio = datetime.datetime.now()
    Quicksort.quickSort(vetor,int(np.floor(len(vetor)/2)),len(vetor)-1)
    tempos.append((datetime.datetime.now()-inicio).total_seconds())
    print(f"Quicksort realizado em: {datetime.datetime.now()-inicio}")

dicionario = {"tempo_heap":[],"tempo_bubble":[],"tempo_quicksort_comeco":[],"tempo_quicksort_meio":[],"quantidade_elementos":[]}
quantidade_divisao_tempo_grafico = 20
quantidade_elemento_grafico = 30

quantidade_divisao = int(input("Quantidade de vetor: "))
# minimo = int(input("Numero de elementos minimo em um vetor: "))
maximo = int(input("Numero de elementos maximos em um vetor: "))
quantidade = np.arange(0,)
step = maximo/quantidade_divisao

for i in range(0,quantidade_divisao,1):
    vetor = np.arange(0,step*(i+1),1)
    # print(vetor)
    print(f"Etapa: {i}/{quantidade_divisao}")
    shuffle(vetor)
    vetor_heap= vetor.copy()
    vetor_bubble= vetor.copy()
    vetor_quicksort=vetor.copy()
    dicionario["quantidade_elementos"].append(len(vetor))
    heapsort(vetor_heap,dicionario["tempo_heap"])
    bubble(vetor_bubble,dicionario["tempo_bubble"])
    quicksort_comeco(vetor_quicksort,dicionario["tempo_quicksort_comeco"])
    quicksort_meio(vetor_quicksort,dicionario["tempo_quicksort_meio"])
    print()

tempo_maximo = []
tempo_maximo.extend(dicionario["tempo_bubble"])
tempo_maximo.extend(dicionario["tempo_heap"])
tempo_maximo.extend(dicionario["tempo_quicksort_comeco"])
tempo_maximo.extend(dicionario["tempo_quicksort_meio"])
plt.figure(figsize=(8.27,5))
# print(dicionario)
plt.plot(dicionario["quantidade_elementos"],dicionario["tempo_heap"],label="Heapsort")
plt.plot(dicionario["quantidade_elementos"],dicionario["tempo_bubble"],label="BubbleSort")
plt.plot(dicionario["quantidade_elementos"],dicionario["tempo_quicksort_comeco"],label="Quicksort começo")
plt.plot(dicionario["quantidade_elementos"],dicionario["tempo_quicksort_meio"],label="Quicksort meio")
plt.grid()
plt.yticks(np.arange(np.min(tempo_maximo),np.max(tempo_maximo)+np.max(tempo_maximo)/quantidade_divisao_tempo_grafico,np.max(tempo_maximo)/quantidade_divisao_tempo_grafico))
plt.xticks(dicionario["quantidade_elementos"],rotation=90)
plt.xlabel("Quantidade de elementos no vetor")
plt.ylabel("Tempo em segundos")
plt.legend()
plt.savefig(f"{datetime.datetime.now()}.png",dpi=300,format="png")

plt.show()