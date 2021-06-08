N = int(input())
a = []

for i in range(N): #0부터 N-1까지 반복
    temp = int(input())
    a.append(temp)

a.sort()

for i in range(N):
    print(a[i])
