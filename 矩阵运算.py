import numpy as np


    #矩阵的转置
def Matrix_transpose(matrix):
    return matrix.T


    #矩阵求逆

def Matrix_inversion(matrix):
    return np.linalg.inv(matrix)


    #矩阵加法

def Matrix_addition(matrixA,matrixB):
    try:
        res = matrixA + matrixB
        return matrixA + matrixB
    except:
        print("请检查矩阵的形状是否一致")

    #矩阵减法

def Matrix_subtraction(matrixA,matrixB):
    try:
        res = matrixA - matrixB
        return matrixA - matrixB
    except:
        print("请检查矩阵的形状是否一致")

    #矩阵乘法

def Matrix_multiplication(matrixA,matrixB):
    try:
        res = np.matmul(matrixA,matrixB)
        return res
    except:
        print("矩阵的格式不对")


    #矩阵求秩

def Rank_of_matrix(matrix):
    try:
        res = np. linalg.matrix_rank(matrix)
        return res
    except:
        print("矩阵不是方阵")

    #矩阵行列式

def Determinant_of_matrix(matrix):
    try:
        res = np.linalg.det(matrix)
        return res
    except:
        print("矩阵不是方阵")

    #矩阵求特征值

def Matrix_eigenvalue(matrix):
        #的特征值与特征向量
    e, v = np.linalg.eig(matrix)
    return e , v
