##Вариант 2 Задание 1
n = int(input("Введите сторону квадрата матрицы: "))
m = n
A = []
for i in range(n):
    B = []
    for j in range(n):
        print("Введите [",i,",",j,"] элемент: ")
        B.append(int(input()))
    A.append(B)
s1 = s2 = key = 0
while key != 1:
    for i in range(0, n):
        s1 += A[i][0]
    print("s1", s1) ##
    while m != 0:
        for i in range(0, n):
            s2 += A[i][m-1]
        print("s2", s2) ##
        if s1 != s2:
            print("Матрица не является магическим квадратом")
            key = 1
            m = 0
        else:
            m -= 1
            s2 = 0 ##!!~!~!~
m = n ##tabx3???
while key != 1:
    for i in range(0, n):
        s1 += A[0][i]
    print(s1) ##
    while m != 0:
        for i in range(0, n):
            s2 += A[m-1][i]
        print(s2) ##
        if s1 != s2:
            print("Матрица не является магическим квадратом")
            key = 1
            m = 0
        else:
            m -= 1
            s2 = 0 ##
if key == 0:
    print("Матрица является магическим квадратом!!!!!!!!!!")

