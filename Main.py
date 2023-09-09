import datetime
import Heapsort
import numpy as np
import random 
import matplotlib.pyplot as plt
import Bubblesort
import Quicksort
import pandas

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

def grafico_individual(dicionario:dict,quantidade_elementos:list):
    for sorts in dicionario.keys():
        plt.plot(quantidade_elementos,dicionario[sorts],label=sorts)
        plt.grid()
        print(sorts)
        plt.yticks(np.arange(np.min(dicionario[sorts]),np.max(dicionario[sorts])+np.max(dicionario[sorts])/quantidade_divisao_tempo_grafico,np.max(dicionario[sorts])/quantidade_divisao_tempo_grafico))
        plt.xticks(quantidade_elementos,rotation=90)
        plt.xlabel("Quantidade de elementos no vetor")
        plt.ylabel("Tempo em segundos")
        plt.legend()
        name = datetime.datetime.now().strftime('%Y-%m-%d %H-%M-%S')
        plt.savefig(f"{name}.png",dpi=300,format="png")
        # pandas.DataFrame(dicionario).to_csv(f"{name}{sorts}.csv",index=False)
        plt.show()


def grafico_todos(dicionario:dict,quantidade_elementos:list):
    tempo_maximo = []
    for sorts in dicionario.keys():
        tempo_maximo.extend(dicionario[sorts])
    # tempo_maximo.extend(dicionario["Heapsort"])
    # tempo_maximo.extend(dicionario["Quicksort inicio"])
    plt.figure(figsize=(8.27,6))
    for sorts in dicionario.keys():
        plt.plot(quantidade_elementos,dicionario[sorts],label=sorts)
    # plt.plot(quantidade_elementos,dicionario["Heapsort"],label="Heapsort")
    # plt.plot(quantidade_elementos,dicionario["Bubblesort"],label="BubbleSort")
    # plt.plot(quantidade_elementos,dicionario["Quicksort inicio"],label="Quicksort começo")
    plt.grid()
    plt.yticks(np.arange(np.min(tempo_maximo),np.max(tempo_maximo)+np.max(tempo_maximo)/quantidade_divisao_tempo_grafico,np.max(tempo_maximo)/quantidade_divisao_tempo_grafico))
    plt.xticks(quantidade_elementos,rotation=90)
    plt.xlabel("Quantidade de elementos no vetor")
    plt.ylabel("Tempo em segundos")
    plt.legend()
    name = datetime.datetime.now().strftime('%Y-%m-%d %H-%M-%S')
    plt.savefig(f"{name}.png",dpi=300,format="png")
    pandas.DataFrame(dicionario).to_csv(f"{name}.csv",index=False)
    plt.show()


quantidade_elementos =[]
dicionario = {"Heapsort":[],"Bubblesort":[],"Quicksort inicio":[],}
quantidade_divisao_tempo_grafico = 20
quantidade_elemento_grafico = 30

# quantidade_divisao = int(input("Quantidade de vetor: "))
quantidade_divisao = int(10)
# minimo = int(input("Numero de elementos minimo em um vetor: "))
# maximo = int(input("Numero de elementos maximos em um vetor: "))
maximo = int(1000)
quantidade = np.arange(0,)
step = maximo/quantidade_divisao
# vetor_nlogn=[]
for i in range(0,quantidade_divisao,1):
    vetor = np.arange(0,step*(i+1),1)
    # print(vetor)
    print(f"Etapa: {i}/{quantidade_divisao}")
    shuffle(vetor)

    vetor_heap= vetor.copy()
    vetor_bubble= vetor.copy()
    vetor_quicksort=vetor.copy()
    quantidade_elementos.append(len(vetor))
    heapsort(vetor_heap,dicionario["Heapsort"])
    bubble(vetor_bubble,dicionario["Bubblesort"])
    quicksort_comeco(vetor_quicksort,dicionario["Quicksort inicio"])
    # quicksort_meio(vetor_quicksort,dicionario["tempo_quicksort_meio"])
    print()

grafico_individual(dicionario=dicionario,quantidade_elementos=quantidade_elementos)
grafico_todos(dicionario=dicionario,quantidade_elementos=quantidade_elementos)