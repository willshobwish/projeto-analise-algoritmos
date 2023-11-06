def heapify(array, n, i):
    # Acha o maior entre os nos e as folhas
    maior = i
    esquerda = 2 * i + 1
    direita = 2 * i + 2
    if esquerda < n and array[i] < array[esquerda]:
        maior = esquerda
    if direita < n and array[maior] < array[direita]:
        maior = direita
    # Caso a raiz nao eh o maior, faz a troca e continua procurando
    if maior != i:
        array[i], array[maior] = array[maior], array[i]
        heapify(array, n, maior)

def heapSort(array):
    n = len(array)
    # Heap maximo
    for i in range(n//2, -1, -1):
        heapify(array, n, i)

    for i in range(n-1, 0, -1):
        # Troca os elementos
        array[i], array[0] = array[0], array[i]

        # Troca a raiz
        heapify(array, i, 0)
