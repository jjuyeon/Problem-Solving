# https://wikidocs.net/16
# https://kkamikoon.tistory.com/138

while True:
    line = input()
    if line == "END":
        break

    dic = {}
    input_list = line.split()
    for val in input_list:
        if val in dic:
            dic[val] = dic.get(val) + 1
        else:
            dic[val] = 1

    sort_dic = sorted(dic.items())
    for key, value in sort_dic:
        print(key, ":", value)
