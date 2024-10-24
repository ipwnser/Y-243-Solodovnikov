s = str(input("Введите текст: \n")) ##Вариант 2
num = 0
for i in range(len(s)):
    if s[i] == ":":
        s = s.replace(":","%")
    num = s.count("%")
print("Текст после замены: ", s, "\n Количество замен = ", num)
