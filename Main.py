import datetime
import Heapsort
import numpy as np
import random 
import matplotlib.pyplot as plt

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


dicionario = {"tempo":[],"quantidade_elementos":[]}
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
    shuffle(vetor)
    dicionario["quantidade_elementos"].append(len(vetor))
    heapsort(vetor,dicionario["tempo"])
    print()
print(dicionario)
plt.plot(dicionario["quantidade_elementos"],dicionario["tempo"],label="Heapsort")
plt.grid()
plt.yticks(np.arange(np.min(dicionario["tempo"]),np.max(dicionario["tempo"])+np.max(dicionario["tempo"])/quantidade_divisao_tempo_grafico,np.max(dicionario["tempo"])/quantidade_divisao_tempo_grafico))
plt.xticks(dicionario["quantidade_elementos"])
plt.legend()
plt.show()