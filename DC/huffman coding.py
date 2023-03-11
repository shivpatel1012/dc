# huffman



# import heapq
# class node:
#     def __init__(self, freq, symbol, left=None, right=None):
#         self.freq = freq
#         self.symbol = symbol
#         self.left = left
#         self.right = right
#         self.huff = ''
#     def __lt__(self, nxt):
#         return self.freq < nxt.freq

# def printNodes(node, val=''):
#     newVal = val + str(node.huff)
#     if(node.left):
#         printNodes(node.left, newVal)
#     if(node.right):
#         printNodes(node.right, newVal)
#     if(not node.left and not node.right):
#         print(f"{node.symbol} -> {newVal}")
# char = []
# freq = []
# n = int(input("enter the no of char: "))
# for i in range(0,n):
#     ch1 = input("enter the char: ")
#     char.append(ch1)

# for i in range(0,n):
#     fr1 = int(input("enter the freq: "))
#     freq.append(fr1)

# nodes = []
# for x in range(len(char)):
#     heapq.heappush(nodes, node(freq[x], char[x]))
# while len(nodes) > 1:
#     left = heapq.heappop(nodes)
#     right = heapq.heappop(nodes)
#     left.huff = 0
#     right.huff = 1
#     newNode = node(left.freq+right.freq, left.symbol+right.symbol, left, right)
#     heapq.heappush(nodes, newNode)
# printNodes(nodes[0])
#############################################################

# lz78
####################3
# def lz78_compress(text):
#     dictionary = { '': 0 }
#     result = []
#     current = ''
    
#     for char in text:
#         if current + char in dictionary:
#             current = current + char
#         else:
#             result.append((dictionary[current], char))
#             dictionary[current + char] = len(dictionary)
#             current = ''
    
#     if current:
#         result.append((dictionary[current], ''))
    
#     return result

# def lz78_decompress(compressed):
#     dictionary = { 0: '' }
#     result = ''
    
#     for index, char in compressed:
#         if char == '':
#             result += dictionary[index]
#             continue
#         new_string = dictionary[index] + char
#         result += new_string
#         dictionary[len(dictionary)] = new_string
    
#     return result
# text = 'shivam patel'
# compressed = lz78_compress(text)
# print(compressed)

# decompressed = lz78_decompress(compressed)
# print(decompressed)
# def lz78_compress(text):
#     dictionary = { '': 0 }
#     result = []
#     current = ''
    
#     for char in text:
#         if current + char in dictionary:
#             current = current + char
#         else:
#             result.append((dictionary[current], char))
#             dictionary[current + char] = len(dictionary)
#             current = ''
    
#     if current:
#         result.append((dictionary[current], ''))
    
#     return result

# def lz78_decompress(compressed):
#     dictionary = { 0: '' }
#     result = ''
#     for index, char in compressed:
#         if char == '':
#             result += dictionary[index]
#             continue

#         new_string = dictionary[index] + char
#         result += new_string
#         dictionary[len(dictionary)] = new_string
    
#     return result
# text = 'data compression'
# compressed = lz78_compress(text)
# print(compressed)

# decompressed = lz78_decompress(compressed)
# print(decompressed)


########################################################3

# lz55
################

# def lz55_compress(text, buffer_size):
#     buffer = text[:buffer_size]
#     result = []
#     i = 0
#     while i < len(text):
#         j = buffer.rfind(text[i:i+buffer_size])
#         if j == -1:
#             result.append((0, text[i]))
#             buffer = buffer[1:] + text[i]
#             i += 1
#         else:
#             match_length = buffer_size - j
#             lookbehind_offset = len(buffer) - j
#             result.append((match_length, lookbehind_offset))
#             i += match_length
#     return result
# text = 'hello world'
# buffer_size = 4
# compressed = lz55_compress(text, buffer_size)
# print(compressed)

##########################################################
# Arithmetic
#######################33

# def generate_binary_code(message, probability_table):
#     ranges = []
#     lower_bound = 0
#     for symbol in message:
#         upper_bound = lower_bound + probability_table[symbol]
#         ranges.append((lower_bound, upper_bound))
#         lower_bound = upper_bound
#     code = ""
#     for i in range(32):
#         mid = (ranges[-1][0] + ranges[-1][1]) / 2
#         if mid < 0.5:
#             code += "0"
#             ranges = [(ranges[-1][0] * 2, ranges[-1][1] * 2)]
#         else:
#             code += "1"
#             ranges = [(2 * ranges[-1][0] - 1, 2 * ranges[-1][1] - 1)]
#     return code

# # Example usage
# probability_table = {"a": 0.4, "b": 0.3, "c": 0.2, "d": 0.1}
# message = "abcd"
# binary_code = generate_binary_code(message, probability_table)
# print(binary_code)

######################################33


