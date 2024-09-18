
import math
x = float(input("Введите x "))
y = float(input("Введите y "))
z = float(input("Введите z "))
s = math.log(y**(-(abs(x)**0.5))) * (x-y/2) + math.sin(math.atan(z))**2
print("s = {0:.3f}".format(s))


