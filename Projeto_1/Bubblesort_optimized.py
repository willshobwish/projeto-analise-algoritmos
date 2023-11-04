def bubbleSort(array:list):
    tamanho = len(array)
    # optimize code, so if the array is already sorted, it doesn't need
    # to go through the entire process
    trocado = False
    # Traverse through all array elements
    for i in range(tamanho-1):
        # range(tamanho) also work but outer loop will
        # repeat one time more than needed.
        # Last i elements are already in place
        for j in range(0, tamanho-i-1):
 
            # traverse the array from 0 to tamanho-i-1
            # Swap if the element found is greater
            # than the next element
            if array[j] > array[j + 1]:
                trocado = True
                array[j], array[j + 1] = array[j + 1], array[j]
         
        if not trocado:
            # if we haven't needed to make a single swap, we
            # can just exit the main loop.
            return