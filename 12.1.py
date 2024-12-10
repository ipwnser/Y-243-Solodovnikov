
##Блок А Задание 2
def d(a, b):
    if a < b:
        return a
    return d(a-b, b)

a = int(input("Введите число а: "))
b = int(input("Введите число b: "))
s = d(a, b)
print("Остаток от деления a на b равен: ",s)

