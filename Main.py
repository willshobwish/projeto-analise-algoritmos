import datetime
import Heapsort
import numpy as np
import random 
import matplotlib.pyplot as plt
import Bubblesort
import Quicksort
import Insertion_sort
import Merge_sort
import Shell_sort
import Selection_sort
import pandas

def shuffle(vetor):
    inicio = datetime.datetime.now()
    random.shuffle(vetor)
    print(f"Shuffle realizado em: {datetime.datetime.now()-inicio}")

def heap(vetor,tempos):
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
    Quicksort.quickSortIterative(vetor,0,len(vetor)-1)
    tempos.append((datetime.datetime.now()-inicio).total_seconds())
    print(f"Quicksort realizado em: {datetime.datetime.now()-inicio}")

def quicksort_meio(vetor,tempos):
    inicio = datetime.datetime.now()
    Quicksort.quickSortIterative(vetor,int(np.floor(len(vetor)/2)),len(vetor)-1)
    tempos.append((datetime.datetime.now()-inicio).total_seconds())
    print(f"Quicksort realizado em: {datetime.datetime.now()-inicio}")


def Insertion(vetor,tempos):
    inicio = datetime.datetime.now()
    Insertion_sort.insertionSort(vetor)
    tempos.append((datetime.datetime.now()-inicio).total_seconds())
    print(f"Insertion sort realizado em: {datetime.datetime.now()-inicio}")

def Merge(vetor,tempos):
    inicio = datetime.datetime.now()
    Merge_sort.mergeSort(vetor,0,len(vetor)-1)
    tempos.append((datetime.datetime.now()-inicio).total_seconds())
    print(f"Merge sort realizado em: {datetime.datetime.now()-inicio}")

def Selection(vetor,tempos):
    inicio = datetime.datetime.now()
    Selection_sort.Selection_Sort(vetor)
    tempos.append((datetime.datetime.now()-inicio).total_seconds())
    print(f"Selection sort realizado em: {datetime.datetime.now()-inicio}")

def Shell(vetor,tempos):
    inicio = datetime.datetime.now()
    Shell_sort.shellSort(vetor,len(vetor))
    tempos.append((datetime.datetime.now()-inicio).total_seconds())
    print(f"Shell sort realizado em: {datetime.datetime.now()-inicio}")

def grafico_individual(dicionario:dict,quantidade_elementos:list):
    plt.figure(figsize=(8.27,6))
    for sorts in dicionario.keys():
        plt.plot(quantidade_elementos,dicionario[sorts],label=sorts)
        plt.grid()
        print(sorts)
        plt.yticks(np.arange(np.min(dicionario[sorts]),np.max(dicionario[sorts])+np.max(dicionario[sorts])/quantidade_divisao_tempo_grafico,np.max(dicionario[sorts])/quantidade_divisao_tempo_grafico))
        plt.xticks([quantidade_elementos[i] for i in range(0,len(quantidade_elementos),int(len(quantidade_elementos)/20))],rotation=90)
        # plt.xticks(quantidade_elementos,rotation=90)
        plt.xlabel("Quantidade de elementos no vetor")
        plt.ylabel("Tempo em segundos")
        plt.legend()
        name = datetime.datetime.now().strftime('%Y-%m-%d %H-%M-%S')
        plt.savefig(f"{name} {sorts}.png",dpi=300,format="png")
        plt.clf()


def grafico_todos(dicionario:dict,quantidade_elementos:list):

    tempo_maximo = []
    for sorts in dicionario.keys():
        tempo_maximo.extend(dicionario[sorts])
    plt.figure(figsize=(8.27,6))
    for sorts in dicionario.keys():
        plt.plot(quantidade_elementos,dicionario[sorts],label=sorts)
    plt.grid()
    plt.yticks(np.arange(np.min(tempo_maximo),np.max(tempo_maximo)+np.max(tempo_maximo)/quantidade_divisao_tempo_grafico,np.max(tempo_maximo)/quantidade_divisao_tempo_grafico))
    plt.xticks([quantidade_elementos[i] for i in range(0,len(quantidade_elementos),int(len(quantidade_elementos)/25))],rotation=90)
    plt.xlabel("Quantidade de elementos no vetor")
    plt.ylabel("Tempo em segundos")
    plt.legend()
    name = datetime.datetime.now().strftime('%Y-%m-%d %H-%M-%S')
    plt.savefig(f"{name} all.png",dpi=300,format="png")
    pandas.DataFrame(dicionario).to_csv(f"{name}.csv",index=False)
    plt.clf()

quantidade_elementos = []

dicionario = {"Bubble sort":[],
              "Heap sort":[],
              "Insertion sort":[],
              "Merge sort":[],
              "Quick sort inicio":[],
              "Quick sort meio":[],
              "Selection sort":[],
              "Shell sort":[]}
quantidade_divisao_tempo_grafico = 25


# quantidade_divisao = int(input("Quantidade de vetor: "))
quantidade_iteracao = 40
# maximo = int(input("Numero de elementos maximos em um vetor: "))
elementos_iteracao = 100

# quantidade = np.arange(0,)
# step = maximo/quantidade_divisao

for i in range(1,quantidade_iteracao+1,1):
    vetor = np.arange(0,elementos_iteracao*i,1)
    print(f"Etapa: {i}/{quantidade_iteracao}")
    shuffle(vetor)
    vetor_heap = vetor.copy()
    vetor_bubble = vetor.copy()
    vetor_quicksort = vetor.copy()
    vetor_quicksort_meio=vetor.copy()
    vetor_insert = vetor.copy()
    vetor_merge = vetor.copy()
    vetor_selection = vetor.copy()
    vetor_shell = vetor.copy()
    quantidade_elementos.append(len(vetor))
    bubble(vetor_bubble,dicionario["Bubble sort"])
    heap(vetor_heap,dicionario["Heap sort"])
    Insertion(vetor_insert,dicionario["Insertion sort"])
    Merge(vetor_merge,dicionario["Merge sort"])
    quicksort_comeco(vetor_quicksort,dicionario["Quick sort inicio"])
    quicksort_meio(vetor_quicksort_meio,dicionario["Quick sort meio"])
    Selection(vetor_selection,dicionario["Selection sort"])
    Shell(vetor_shell,dicionario["Shell sort"])
    # heapsort(vetor_heap,dicionario["Heapsort"])
    # bubble(vetor_bubble,dicionario["Bubblesort"])
    # quicksort_comeco(vetor_quicksort,dicionario["Quicksort inicio"])
    # quicksort_meio(vetor_quicksort_meio,dicionario["Quicksort meio"])
    print()
grafico_individual(dicionario=dicionario,quantidade_elementos=quantidade_elementos)
grafico_todos(dicionario=dicionario,quantidade_elementos=quantidade_elementos)