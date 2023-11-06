def shellSort(array: list):
    tamanho = len(array)
    # Divisao de numeros com o resultado inteiro, ou seja, sem considerar o ponto flutuante 
    intervalo=tamanho//2
    while intervalo>0: 
        j=intervalo 
        while j<tamanho: 
            i=j-intervalo
            while i>=0: 
                if array[i+intervalo]>array[i]: 
                    break
                else: 
                    array[i+intervalo],array[i]=array[i],array[i+intervalo] 
                i=i-intervalo 
            j+=1
        intervalo=intervalo//2