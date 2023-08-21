def leilao_dinamico(ofertas):
    matriz = [[]]

    for x in range(0, 21):
        matriz[0].append(0)

    comp = lambda a: a['demanda']

    ofertas.sort(key=comp)

    for j in range(1, len(ofertas) + 1):
        matriz.append([0])

        peso = ofertas[j - 1]['demanda']
        valor = ofertas[j - 1]['oferta']

        for i in range(1, 21):
            pos = i - int(peso / 10)
            if pos < 0:
                matriz[j].append(matriz[j - 1][i])
            else:
                valor_atual = matriz[j - 1][i]
                novo_valor = matriz[j - 1][pos] + valor

                if novo_valor > valor_atual:
                    matriz[j].append(novo_valor)
                else:
                    matriz[j].append(valor_atual)

    return matriz


if __name__ == '__main__':
    ofertas = [{'nome': 'A', 'oferta': 5, 'demanda': 40},
               {'nome': 'B', 'oferta': 9, 'demanda': 80},
               {'nome': 'C', 'oferta': 3, 'demanda': 20},
               {'nome': 'D', 'oferta': 8, 'demanda': 160},
               {'nome': 'E', 'oferta': 6, 'demanda': 60}]

    resultado = leilao_dinamico(ofertas)

    print('')
    for c in resultado:
        print(c)
    print('')
    print('Melhor oferta dinamico: ', resultado[5][20])


