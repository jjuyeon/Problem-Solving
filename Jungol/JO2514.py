# https://wayhome25.github.io/python/2017/02/26/py-14-list/

find = ["KOI", "IOI"]
ans = [0, 0]

arr = list(input())
for i in range(0, len(arr) - 2):
    compare = "".join(arr[i : i + 3])  # list를 join해서 문자열로 변경, 앞은 합칠 때마다 구분 할 구분자
    if compare == find[0]:
        ans[0] += 1
    elif compare == find[1]:
        ans[1] += 1

print(ans[0])
print(ans[1])
