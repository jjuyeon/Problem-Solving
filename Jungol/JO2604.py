# https://bio-info.tistory.com/29

arr = list(input())

now = ""
len = 0
for plate in arr:
    if now == "":
        now = plate
        len += 10
    elif now != plate:
        now = plate
        len += 10
    else:
        len += 5

print(len)
