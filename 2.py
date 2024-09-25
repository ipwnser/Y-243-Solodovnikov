
import math
x = float(input("Введите x "))
y = float(input("Введите y "))
z = float(input("Введите z "))
s = (((9+(x-y)**2)**1/3)/x**2+y**2+2)-math.exp(abs(x-y))*(math.tan(z))**3
print("s = {0:.6f}".format(s))


