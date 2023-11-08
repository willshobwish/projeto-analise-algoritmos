def merge(array, esquerda, meio, direita):
    index_1 = meio - esquerda + 1
    index_2 = direita - meio
 
    # Cria vetores temporarios
    vetor_esquerda = [0] * (index_1)
    vetor_direita = [0] * (index_2)

    for i in range(0, index_1):
        vetor_esquerda[i] = array[esquerda + i]
 
    for j in range(0, index_2):
        vetor_direita[j] = array[meio + 1 + j]

    i = 0     
    j = 0     
    k = esquerda    
 
    while i < index_1 and j < index_2:
        if vetor_esquerda[i] <= vetor_direita[j]:
            array[k] = vetor_esquerda[i]
            i += 1
        else:
            array[k] = vetor_direita[j]
            j += 1
        k += 1
 
    while i < index_1:
        array[k] = vetor_esquerda[i]
        i += 1
        k += 1
 
    while j < index_2:
        array[k] = vetor_direita[j]
        j += 1
        k += 1
 
 
def mergeSort(array, esquerda, direita):
    if esquerda < direita:
        # Encontra o elemento central para particionar 
        meio = esquerda+(direita-esquerda)//2
        # Divide o vetor em duas particoes
        mergeSort(array, esquerda, meio)
        mergeSort(array, meio+1, direita)
        merge(array, esquerda, meio, direita)
 
