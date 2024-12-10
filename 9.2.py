
##Вариант 2 Задание 2
m = int(input("Введите количество строк"))
n = int(input("Введите количество столбцов"))
a = []
for i in range(m):
    b = []
    for j in range(n):
        print("Введите [", i, ", ", j, "] элемент")
        b.append(int(input()))
    a.append(b)

for i in range(m):
    a[i][0], a[i][n-1] = a[i][n-1], a[i][0]

print("Измененная матрица: ")
for i in range(m):
    for j in range(n):
        print(a[i][j], end=" ")
    print()
