def particao(array, l, h): 
    i = ( l - 1 ) 
    x = array[h] 
    for j in range(l, h): 
        if array[j] <= x: 
            i = i + 1
            array[i], array[j] = array[j], array[i]   
    array[i + 1], array[h] = array[h], array[i + 1] 
    return (i + 1) 

def quicksort_iterativo(array:list, l:int, h:int): 
    tamanho = h - l + 1
    pilha = [0] * (tamanho) 
    topo = -1
    topo = topo + 1
    pilha[topo] = l 
    topo = topo + 1
    pilha[topo] = h 
    while topo >= 0: 
        h = pilha[topo] 
        topo = topo - 1
        l = pilha[topo] 
        topo = topo - 1
        p = particao(array, l, h) 
        if p-1 > l: 
            topo = topo + 1
            pilha[topo] = l 
            topo = topo + 1
            pilha[topo] = p - 1
        if p + 1 < h: 
            topo = topo + 1
            pilha[topo] = p + 1
            topo = topo + 1
            pilha[topo] = h 
