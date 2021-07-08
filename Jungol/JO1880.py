# https://ooyoung.tistory.com/104

decoding = list(input())
input_list = list(input())

ans = [""] * len(input_list)
for idx, alpha in enumerate(input_list):
    if alpha.isupper():
        ans[idx] = decoding[ord(alpha) - 65].upper()
    elif alpha.islower():
        ans[idx] = decoding[ord(alpha) - 97].lower()
    else:
        ans[idx] = alpha

print("".join(ans))
