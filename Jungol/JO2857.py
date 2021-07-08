# https://yechoi.tistory.com/52

board = [[" "] * 15 for _ in range(5)]

for i in range(5):
    arr = list(input())
    for j, val in enumerate(arr):
        board[i][j] = val

for j in range(15):
    for i in range(5):
        if board[i][j] != " ":
            print(board[i][j], end="")
