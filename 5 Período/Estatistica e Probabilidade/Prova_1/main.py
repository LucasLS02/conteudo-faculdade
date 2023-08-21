import statistics

# Questão 2
print('-----------------------------')
print('Questão 2')

tempos = [6.8, 7.1, 5.9, 7.5, 6.4, 6.9, 7.2, 8, 6.6]

dp = statistics.stdev(tempos)

media = statistics.mean(tempos)

cv = dp / media * 100

print('dp: ', dp)
print('media: ', media)
print('cv: ', cv)

print('-----------------------------')
print('Questão 3')

s = [250, 206, 215, 258, 187, 187, 183]

mediana = statistics.median(s)

funcionarios = 0.2 * mediana

print('mediana: ', mediana)
print('funcionarios: ', funcionarios)
print('-----------------------------')

print('-----------------------------')
print('Questão 4')

a = 10
b = 15
c = 15
d = 40
e = 20

a_ = 1.5
b_ = 1.5
c_ = 0.8
d_ = 1.9
e_ = 8.2

erros = (a / 100 * a_ / 100) + (b / 100 * b_ / 100) + (c / 100 * c_ / 100) + (d / 100 * d_ / 100) + (e / 100 * e_ / 100)

print('erros: ', round(erros, 3))


print('-----------------------------')
print('Questão 5')

p = 0.08
lotes = 25

num_ = p * lotes

print('num_: ', num_)

print('-----------------------------')
print('Questão 6')

value = (6 / 40) * (5 / 39) * (4 / 38) * (34 / 37) * (33 / 36) * (34 / 35)

print('value: ', round(value, 4))

print('-----------------------------')
print('Questão 7')

request_per_min = 1.2



