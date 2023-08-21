import random
import time
from relatorios import gerarRelatorio
import sys


def trocar(dados, pos1, pos2):
    aux = dados[pos1]
    dados[pos1] = dados[pos2]
    dados[pos2] = aux


def gera_vetor(tamanho, ordenado):
    dados = []
    for index in range(tamanho):
        dados.append(index + 1)
    if not ordenado:
        for i in range(len(dados) * 3):
            pos1 = random.randint(0, tamanho - 1)
            pos2 = random.randint(0, tamanho - 1)
            trocar(dados, pos1, pos2)
    return dados


# def bolha(dados):
#     for i in range(len(dados) - 1, 0, -1):
#         trocas = 0
#         for index in range(i):
#             if dados[index] > dados[index + 1]:
#                 trocar(dados=dados, pos1=index, pos2=index + 1)
#                 trocas += 1
#         if trocas == 0:
#             return None
#     return dados

def bubbleSort(array):
    for i in range(len(array)):
        for j in range(0, len(array) - i - 1):
            if array[j] > array[j + 1]:
                temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp


# def particao(dados, inicio, fim):
#     posicao = inicio - 1
#     pivot = dados[fim]
#     for i in range(inicio, fim):
#         if dados[i] < pivot:
#             posicao += 1
#             trocar(dados=dados, pos1=posicao, pos2=i)
#     posicao += 1
#     trocar(dados=dados, pos1=posicao, pos2=fim)
#     return posicao
#
#
# def quicksort(dados, inicio, fim):
#     if inicio < fim:
#         p = particao(dados=dados, inicio=inicio, fim=fim)
#         quicksort(dados=dados, inicio=inicio, fim=p-1)
#         quicksort(dados=dados, inicio=p+1, fim=fim)

def partition(l, r, nums):
    pivot, ptr = nums[r], l
    for i in range(l, r):
        if nums[i] <= pivot:
            nums[i], nums[ptr] = nums[ptr], nums[i]
            ptr += 1
    nums[ptr], nums[r] = nums[r], nums[ptr]
    return ptr


def quicksort(l, r, nums):
    if len(nums) == 1:
        return nums
    if l < r:
        pi = partition(l, r, nums)
        quicksort(l, pi - 1, nums)
        quicksort(pi + 1, r, nums)
    return nums


def main():
    sys.setrecursionlimit(150000)
    random.seed(42)
    # tamanhos_de_vetor = [62_500, 125_000, 250_000, 375_000]
    tamanhos_de_vetor = [375_000]
    for tam in tamanhos_de_vetor:
        tempos_de_execucao = []
        for i in range(1):
            vet = gera_vetor(tam, True)
            inicio = time.time()
            quicksort(0, len(vet) - 1, vet)
            fim = time.time()
            tempos_de_execucao.append(fim - inicio)
        gerarRelatorio(tempos_execucao=tempos_de_execucao, metodo='quicksort', tam_vetor=tam)
        tempos_de_execucao.clear()


if __name__ == '__main__':
    main()
