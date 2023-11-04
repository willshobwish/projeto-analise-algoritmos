def bubbleSort(array:list):
    tamanho = len(array)
    # optimize code, so if the array is already sorted, it doesn't need
    # to go through the entire process
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
                array[j], array[j + 1] = array[j + 1], array[j]
         