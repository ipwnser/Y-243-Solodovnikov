##Вариант 2 Задание 2
x = int(input("Введите длину массива: \n"))
a = []
p = []
n = []
for i in range(x):
    print("Введите ",i+1 ,"Элемент массива: ")
    a.append(int(input()))
for i in range(x):
    if a[i] >= 0:
        p.append(a[i])
    elif a[i] < 0:
        n.append(a[i])
print("Начальный массив: ", a)
print("Массив положительных чисел: ", p)
print("Массив отрицательных чисел: ", n)