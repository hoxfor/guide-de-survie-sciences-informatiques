def topk_words(words_list, k):
    frequency_dict = {}
    
    for word in words_list:
        if word in frequency_dict.keys():
            frequency_dict[word] += 1
        else:
            frequency_dict[word] = 1
            
    frequency_list = frequency_dict.items()
    
    top_frequency = []
    for word, frequency in frequency_list:
        if frequency >= k or k > len(words_list):
            top_frequency.append((frequency, word))
    return top_frequency