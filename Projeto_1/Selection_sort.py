def Selection_Sort(array:list):
    for i in range(len(array)):
        index_minimo = i
        for j in range(i+1, len(array)):
            if array[index_minimo] > array[j]:
                index_minimo = j
        # Faz a troca dos elementos
        array[i], array[index_minimo] = array[index_minimo], array[i]