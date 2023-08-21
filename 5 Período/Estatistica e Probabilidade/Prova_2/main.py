from scipy.stats import norm, expon
import math

# Questão 1

media = 71
desvio_padrao = 28.6
percentil = 0.94

tempo_maximo = norm.ppf(percentil, loc=media, scale=desvio_padrao)

print('Questão 1:')
print(f"O tempo máximo para receber o certificado especial é de aproximadamente {round(tempo_maximo, 3)} minutos.")

print('----------------------------------------------------------------')

# Questão 2

media = 6  # média em milissegundos
lambda_param = 1 / media  # parâmetro de taxa
x1 = 7  # tempo mínimo em milissegundos
x2 = 13  # tempo máximo em milissegundos

probabilidade = expon.cdf(x2, scale=1/lambda_param) - expon.cdf(x1, scale=1/lambda_param)

print('Questão 2:')
print(f"A probabilidade de o tempo de resposta estar entre 7 e 13 milissegundos é de aproximadamente {round(probabilidade, 3)}")

print('----------------------------------------------------------------')

# Questão 3

proporcao_observada = 136 / 302
tamanho_amostra = 302
nivel_confianca = 0.96

valor_critico = abs(norm.ppf((1 - nivel_confianca) / 2))

margem_erro = valor_critico * math.sqrt((proporcao_observada * (1 - proporcao_observada)) / tamanho_amostra)

print('Questão 3:')
print(f"A margem de erro da pesquisa com 96% de confiança é de aproximadamente {round(margem_erro, 4)}")

print('----------------------------------------------------------------')

# Questão 4

media_amostra = 54
desvio_padrao_populacional = 20.6
tamanho_amostra = 25
nivel_confianca = 0.99

valor_critico = abs(norm.ppf((1 - nivel_confianca) / 2))

erro_padrao = desvio_padrao_populacional / math.sqrt(tamanho_amostra)

intervalo_min = media_amostra - valor_critico * erro_padrao
intervalo_max = media_amostra + valor_critico * erro_padrao

amplitude = intervalo_max - intervalo_min

print('Questão 4:')
print(f"O intervalo de confiança de 99% para o parâmetro de interesse é de aproximadamente [{round(intervalo_min, 3)}, {round(intervalo_max, 3)}]")
print(f"A amplitude deste intervalo é de aproximadamente {round(amplitude, 3)}")

import scipy.stats as stats

media_amostra = 54
desvio_padrao_populacional = 20.6
tamanho_amostra = 25
nivel_confianca = 0.99

intervalo = stats.t.interval(nivel_confianca, tamanho_amostra - 1, loc=media_amostra, scale=desvio_padrao_populacional / (tamanho_amostra ** 0.5))

intervalo_min = intervalo[0]
intervalo_max = intervalo[1]
amplitude = intervalo_max - intervalo_min

print(f"O intervalo de confiança de 99% para o parâmetro de interesse é de aproximadamente [{round(intervalo_min, 2)}, {round(intervalo_max, 2)}]")
print(f"A amplitude deste intervalo é de aproximadamente {round(amplitude, 3)}")

import scipy.stats as stats
import math

media_amostra = 54
desvio_padrao_populacional = 20.6
tamanho_amostra = 25
nivel_confianca = 0.99

graus_liberdade = tamanho_amostra - 1
valor_critico = stats.t.ppf((1 + nivel_confianca) / 2, graus_liberdade)

erro_padrao = desvio_padrao_populacional / math.sqrt(tamanho_amostra)

intervalo_min = media_amostra - valor_critico * erro_padrao
intervalo_max = media_amostra + valor_critico * erro_padrao

amplitude = intervalo_max - intervalo_min

print(f"O intervalo de confiança de 99% para o parâmetro de interesse é de aproximadamente [{round(intervalo_min, 3)}, {round(intervalo_max, 3)}]")
print(f"A amplitude deste intervalo é de aproximadamente {round(amplitude, 3)}")

import numpy as np

media_amostra = 54
desvio_padrao_populacional = 20.6
tamanho_amostra = 25
nivel_confianca = 0.99

erro_padrao = desvio_padrao_populacional / np.sqrt(tamanho_amostra)

valor_critico = np.abs(stats.norm.ppf((1 - nivel_confianca) / 2))

intervalo_min = media_amostra - valor_critico * erro_padrao
intervalo_max = media_amostra + valor_critico * erro_padrao

amplitude = intervalo_max - intervalo_min

print(f"O intervalo de confiança de 99% para o parâmetro de interesse é de aproximadamente [{round(intervalo_min, 3)}, {round(intervalo_max, 3)}]")
print(f"A amplitude deste intervalo é de aproximadamente {round(amplitude, 3)}")

import scipy.stats as stats
import math

media_amostra = 54
desvio_padrao_populacional = 20.6
tamanho_amostra = 25
nivel_confianca = 0.99

valor_critico = stats.t.ppf((1 + nivel_confianca) / 2, tamanho_amostra - 1)

erro_padrao = desvio_padrao_populacional / math.sqrt(tamanho_amostra)

intervalo_min = media_amostra - valor_critico * erro_padrao
intervalo_max = media_amostra + valor_critico * erro_padrao

amplitude = intervalo_max - intervalo_min

print(f"O intervalo de confiança de 99% para o parâmetro de interesse é de aproximadamente [{round(intervalo_min, 3)}, {round(intervalo_max, 3)}]")
print(f"A amplitude deste intervalo é de aproximadamente {round(amplitude, 3)}")


print('----------------------------------------------------------------')

# Questão 5

desvio_padrao = 1.1
nivel_confianca = 0.98
erro_maximo = 0.48

z_valor = abs(stats.norm.ppf((1 - nivel_confianca) / 2))
tamanho_amostra = math.ceil((z_valor * desvio_padrao / erro_maximo) ** 2)

print('Questão 5:')
print(f"O tamanho mínimo da amostra necessário é de {tamanho_amostra} alunos.")

from scipy import stats
import math

desvio_padrao = 1.1
nivel_confianca = 0.98
erro_maximo = 0.48

z_valor = stats.norm.ppf(1 - (1 - nivel_confianca) / 2)
tamanho_amostra = math.ceil((z_valor * desvio_padrao / erro_maximo) ** 2)

print(f"O tamanho mínimo da amostra necessário é de {tamanho_amostra} alunos.")

print('----------------------------------------------------------------')

# Questão 6

import numpy as np
from scipy import stats

# Dados de peso ao nascer e à desmama
peso_nascer = np.array([62, 74, 66, 98, 88, 80, 78, 68, 75, 86, 84, 78])
peso_desmama = np.array([515, 430, 475, 565, 593, 510, 495, 480, 555, 520, 470, 445])

# Realizando a regressão linear
slope, intercept, r_value, p_value, std_err = stats.linregress(peso_nascer, peso_desmama)

# Peso ao nascer do bezerro para previsão
peso_nascer_previsto = 91

# Previsão do peso à desmama
peso_desmama_previsto = slope * peso_nascer_previsto + intercept

# Imprimindo o resultado com 3 casas decimais
print('Questão 6:')
print(f"A previsão do peso à desmama para um bezerro que nasceu com o peso de {peso_nascer_previsto} lb é de {peso_desmama_previsto:.3f} lb.")

import numpy as np

# Dados de peso ao nascer e à desmama
peso_nascer = np.array([62, 74, 66, 98, 88, 80, 78, 68, 75, 86, 84, 78])
peso_desmama = np.array([515, 430, 475, 565, 593, 510, 495, 480, 555, 520, 470, 445])

# Realizando a regressão linear
A = np.vstack([peso_nascer, np.ones(len(peso_nascer))]).T
m, c = np.linalg.lstsq(A, peso_desmama, rcond=None)[0]

# Peso ao nascer do bezerro para previsão
peso_nascer_previsto = 91

# Previsão do peso à desmama
peso_desmama_previsto = m * peso_nascer_previsto + c

# Imprimindo o resultado com 3 casas decimais
print(f"A previsão do peso à desmama para um bezerro que nasceu com o peso de {peso_nascer_previsto} lb é de {peso_desmama_previsto:.3f} lb.")

import numpy as np

# Dados de peso ao nascer e à desmama
peso_nascer = np.array([62, 74, 66, 98, 88, 80, 78, 68, 75, 86, 84, 78])
peso_desmama = np.array([515, 430, 475, 565, 593, 510, 495, 480, 555, 520, 470, 445])

# Cálculo dos coeficientes da regressão linear
X = np.column_stack((peso_nascer, np.ones_like(peso_nascer)))
y = peso_desmama
coefficients = np.linalg.inv(X.T @ X) @ X.T @ y

# Peso ao nascer do bezerro para previsão
peso_nascer_previsto = 91

# Previsão do peso à desmama
peso_desmama_previsto = coefficients[0] * peso_nascer_previsto + coefficients[1]

# Imprimindo o resultado com 3 casas decimais
print(f"A previsão do peso à desmama para um bezerro que nasceu com o peso de {peso_nascer_previsto} lb é de {peso_desmama_previsto:.3f} lb.")

# Dados de peso ao nascer e à desmama
peso_nascer = [62, 74, 66, 98, 88, 80, 78, 68, 75, 86, 84, 78]
peso_desmama = [515, 430, 475, 565, 593, 510, 495, 480, 555, 520, 470, 445]

# Cálculo dos coeficientes da regressão linear
n = len(peso_nascer)
mean_peso_nascer = sum(peso_nascer) / n
mean_peso_desmama = sum(peso_desmama) / n
covariance = sum((x - mean_peso_nascer) * (y - mean_peso_desmama) for x, y in zip(peso_nascer, peso_desmama))
variance = sum((x - mean_peso_nascer) ** 2 for x in peso_nascer)
slope = covariance / variance
intercept = mean_peso_desmama - slope * mean_peso_nascer

# Peso ao nascer do bezerro para previsão
peso_nascer_previsto = 91

# Previsão do peso à desmama
peso_desmama_previsto = slope * peso_nascer_previsto + intercept

# Imprimindo o resultado com 3 casas decimais
print(f"A previsão do peso à desmama para um bezerro que nasceu com o peso de {peso_nascer_previsto} lb é de {peso_desmama_previsto:.3f} lb.")
