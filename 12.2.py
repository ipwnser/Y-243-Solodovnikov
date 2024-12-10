
##Блок Б Задание 4
def f(n, d = None):
    if d is None:
        d = 2
    if d > n**0.5:
        return True
    if n%d == 0:
        return False
    return f(n, d+1)
n = int(input("Введите натуральное число n (n>1): "))
if n > 1:
    if f(n):
        print("YES")
    else:
        print("NO")

