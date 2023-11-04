def bubbleSort(array:list):
    tamanho = len(array)
    trocado = False
    for i in range(tamanho-1):
        for j in range(0, tamanho-i-1):
            if array[j] > array[j + 1]:
                trocado = True
                array[j], array[j + 1] = array[j + 1], array[j]
        if not trocado:
            return