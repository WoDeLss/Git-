import scipy.integrate
from sympy import *
#定积分求解
def definite_integral(function,Integral_variable,star,end):
    x = symbols(Integral_variable)
    print(integrate(function, (x, star, end)))
# definite_integral('x**2','x',1,2)


#微积分
def Calculus(function):
    print(diff(function))
Calculus("exp(-x) * cos(x-3)")

#重积分
def Multiple_integral(function):
    p, err = scipy.integrate.dblquad(function, 0, 2, lambda g: 0, lambda h: 1)
    print(p)

# f = lambda x, y: exp(x ** 2 - y ** 2)
# Multiple_integral(f)
