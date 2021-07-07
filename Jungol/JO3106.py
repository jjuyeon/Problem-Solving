def solution(n, q):
    rev_base = ""
    if n == 0:
        rev_base = "0"

    while n > 0:
        # 몫과 나머지를 구해주는 함수 divmod : 정수를 나눈 몫과 나머지를 구해줌
        n, mod = divmod(n, q)  # 몫, 나머지

        if mod >= 10:
            mod = chr(mod - 10 + 65)  # 아스키코드를 문자열로 변환하는 함수
        else:
            mod = str(mod)  # int에서 string으로 변환

        rev_base += mod

    return rev_base[::-1]  # 역순인 진수를 뒤집어 줘야 원래 변환 하고자하는 base가 출력된다.


while True:
    line = input()
    if line == "0":
        break

    a, n, b = line.split()  # 입력받은 값을 공백을 기준으로 분리
    print(solution(int(n, int(a)), int(b)))
