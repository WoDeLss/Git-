import 矩阵运算 as M
import numpy as np


# [[]]/行
# []列

matrixA = np.array([[5,2,3],[2,3,4],[4,5,9]])
matrixB = np.array([[2,3,4],[3,4,5],[4,5,6]])
#特征值与特征向量
res,value = M.Matrix_eigenvalue(matrixA)
print(res)
print(value)
#转置
res = M.Matrix_transpose(matrixA)
#求秩
res = M.Rank_of_matrix(matrixA)
#加法
res = M.Matrix_addition(matrixA,matrixB)
#乘法
res = M.Matrix_subtraction(matrixA,matrixB)
#行列式
res = M.Determinant_of_matrix(matrixA)
#特征值



