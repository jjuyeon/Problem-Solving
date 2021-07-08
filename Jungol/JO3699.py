tc = int(input())

for i in range(tc):
    dic = {}
    n = int(input())

    for j in range(n):
        acc = input().split()
        if acc[1] in dic:
            dic[acc[1]] = dic.get(acc[1]) + 1
        else:
            dic[acc[1]] = 1

    ans = 1
    for val in dic.values():
        ans *= val + 1  # 전체 경우의 수: (얼굴 개수 + 1) * (상의 개수 + 1) * (하의 개수 + 1)

    ans -= 1  # 아무것도 안입는 경우인 1가지 경우의 수를 빼주면 된다.

    print(ans)
