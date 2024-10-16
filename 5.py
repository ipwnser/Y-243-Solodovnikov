##ЛР 5 Задание 2
a = int(input("Введите число больше 2: "))
for i in range(2, a//2):
    if a%i==0:
        print("Наименьший делитель равен: ", i)
        break
