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
import Bubblesort_optimized
import pandas
import os 

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
    Quicksort.quicksort_iterativo(vetor,0,len(vetor)-1)
    tempos.append((datetime.datetime.now()-inicio).total_seconds())
    print(f"Quicksort com o pivô inicial realizado em: {datetime.datetime.now()-inicio}")

def quicksort_meio(vetor,tempos):
    inicio = datetime.datetime.now()
    Quicksort.quicksort_iterativo(vetor,int(np.floor(len(vetor)/2)),len(vetor)-1)
    tempos.append((datetime.datetime.now()-inicio).total_seconds())
    print(f"Quicksort com o pivô no meio realizado em: {datetime.datetime.now()-inicio}")


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
    Shell_sort.shellSort(vetor)
    tempos.append((datetime.datetime.now()-inicio).total_seconds())
    print(f"Shell sort realizado em: {datetime.datetime.now()-inicio}")

def bubble_optimized(vetor,tempos):
    inicio = datetime.datetime.now()
    Bubblesort_optimized.bubbleSort(vetor)
    tempos.append((datetime.datetime.now()-inicio).total_seconds())
    print(f"Bubble sort otimizado realizado em: {datetime.datetime.now()-inicio}")

def grafico_individual(array_type:str, dicionario:dict,quantidade_elementos:list):
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
        os.makedirs(f"Graficos {array_type}",exist_ok=True)
        plt.savefig(os.path.join(f"Graficos {array_type}",f"{name} {sorts}.png"),dpi=300,format="png")
        plt.clf()


def grafico_todos(array_type:str, dicionario:dict,quantidade_elementos:list):
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
    os.makedirs(f"Graficos {array_type}",exist_ok=True)
    plt.savefig(os.path.join(f"Graficos {array_type}",f"{name} all.png"),dpi=300,format="png")
    pandas.DataFrame(dicionario).to_csv(os.path.join(f"Graficos {array_type}",f"{name}.csv"),index=False)
    plt.clf()


quantidade_divisao_tempo_grafico = 25


# quantidade_divisao = int(input("Quantidade de vetor: "))
quantidade_iteracao = int(input("Quantidade de iterações: "))

# maximo = int(input("Numero de elementos maximos em um vetor: "))
elementos_iteracao = int(input("Quantidade de elementos por iteração: "))

# quantidade = np.arange(0,)
# step = maximo/quantidade_divisao

def sorting(sorting_method:list):
    
    for each_sorting_method in sorting_method:
        quantidade_elementos = []
        dicionario = {
              "Bubble sort":[],
              "Bubble sort otimizado":[],
              "Heap sort":[],
              "Insertion sort":[],
              "Merge sort":[],
              "Quick sort inicio":[],
              "Quick sort meio":[],
              "Selection sort":[],
              "Shell sort":[]}
        for i in range(1,quantidade_iteracao+1,1):
            vetor = np.arange(0,elementos_iteracao*i,1)
            print(f"Etapa: {i}/{quantidade_iteracao}")
            if each_sorting_method=="Aleatório":
                shuffle(vetor)
            if each_sorting_method == "Decrescente":
                vetor[::-1].sort()
            # Caso seja crescente, nao realiza nada porque o vetor ja eh instanciado de forma crescente
            vetor_heap = vetor.copy()
            vetor_bubble = vetor.copy()
            vetor_quicksort = vetor.copy()
            vetor_quicksort_meio=vetor.copy()
            vetor_insert = vetor.copy()
            vetor_merge = vetor.copy()
            vetor_selection = vetor.copy()
            vetor_shell = vetor.copy()
            vetor_bubble_optimized = vetor.copy()
            quantidade_elementos.append(len(vetor))
            bubble(vetor_bubble,dicionario["Bubble sort"])
            heap(vetor_heap,dicionario["Heap sort"])
            Insertion(vetor_insert,dicionario["Insertion sort"])
            Merge(vetor_merge,dicionario["Merge sort"])
            quicksort_comeco(vetor_quicksort,dicionario["Quick sort inicio"])
            quicksort_meio(vetor_quicksort_meio,dicionario["Quick sort meio"])
            Selection(vetor_selection,dicionario["Selection sort"])
            Shell(vetor_shell,dicionario["Shell sort"])
            bubble_optimized(vetor_bubble_optimized,dicionario["Bubble sort otimizado"])
            print()
        grafico_individual(array_type=each_sorting_method, dicionario=dicionario,quantidade_elementos=quantidade_elementos)
        grafico_todos(array_type=each_sorting_method, dicionario=dicionario,quantidade_elementos=quantidade_elementos)

sorting(["Aleatório","Decresente","Crescente"])