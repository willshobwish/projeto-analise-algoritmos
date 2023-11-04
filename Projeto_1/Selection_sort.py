def Selection_Sort(array:list):
    for i in range(len(array)):
        minimun_index = i
        for j in range(i+1, len(array)):
            if array[minimun_index] > array[j]:
                minimun_index = j
        array[i], array[minimun_index] = array[minimun_index], array[i]