##Вариант 2 Задание 1
x = int(input("Введите длину массива: \n"))
a = []
m = 9999999
for i in range(x):
    print("Введите ",i+1 ,"Элемент массива: ")
    a.append(int(input()))
for i in range(x):
    if a[i] < m:
        m = a[i]
print("Минимальный элемент массива: ",m)
print("Индекс минмального элемента: ",a.index(m))
