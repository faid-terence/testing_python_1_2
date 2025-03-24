def count_word_frequency(text):
    for char in ',.!?;:()[]{}"\'-_':
        text = text.replace(char, ' ')
    words = text.lower().split()
    word_count = {}
    
    for word in words:
        if word in word_count:
            word_count[word] += 1
        else:
            word_count[word] = 1
    sorted_words = sorted(word_count.items(), key=lambda x: (-x[1], x[0]))
    
    print("Word Frequencies:")
    for word, count in sorted_words:
        print(f"{word}: {count}")

# Tests for my function
text = "Hello world! This is a test. Hello, this test is only a test."
count_word_frequency(text)