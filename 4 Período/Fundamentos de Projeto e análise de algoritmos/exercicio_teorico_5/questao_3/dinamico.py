def comp(e):
    return e['peso']


def dinamico(lucros):
    matriz = [[]]

    for x in range(0, 5):
        matriz[0].append({
                'valor': 0,
                'nome': 'inicial'
            })

    lucros.sort(key=comp)

    i = 0

    for j in range(1, int((len(lucros)) / 4) + 1):
        matriz.append([{
                'valor': 0,
                'nome': 'inicial'
            }])

        peso = lucros[i]['peso']
        valor = []

        for x in range(i, i + 4):
            valor.append({
                'valor': lucros[x]['valor'],
                'nome': lucros[x]['nome']
            })

        for i in range(1, 5):
            print('entrou ', i)
            pos = i - int(peso / 1000)
            if pos < 0:
                matriz[j].append(matriz[j - 1][i])
            else:
                valor_atual = matriz[j - 1][i]['valor']
                novo_valor = matriz[j - 1][pos]['valor'] + valor[0]['valor']
                if novo_valor > valor_atual:
                    matriz[j].append({
                        'valor': novo_valor,
                        'nome': matriz[j - 1][i]['nome'] + ', ' + valor[0]['nome']
                    })
                else:
                    matriz[j].append(matriz[j - 1][i])
            for y in range(1, len(valor)):
                valor_atual = matriz[j][i]['valor']
                novo_valor = valor[y]['valor']
                if novo_valor > valor_atual:
                    matriz[j][i] = valor[y]
        i += 4    
    return matriz


if __name__ == '__main__':
    lucros = [{'nome': 'cobre 1', 'peso': 1000, 'valor': 10},
              {'nome': 'cobre 2', 'peso': 2000, 'valor': 17},
              {'nome': 'cobre 3', 'peso': 3000, 'valor': 19},
              {'nome': 'cobre 4', 'peso': 4000, 'valor': 19},
              {'nome': 'coaxial 1', 'peso': 1000, 'valor': 6},
              {'nome': 'coaxial 2', 'peso': 2000, 'valor': 7},
              {'nome': 'coaxial 3', 'peso': 3000, 'valor': 11},
              {'nome': 'coaxial 4', 'peso': 4000, 'valor': 13},
              {'nome': 'optico 1', 'peso': 1000, 'valor': 8},
              {'nome': 'optico 2', 'peso': 2000, 'valor': 11},
              {'nome': 'optico 3', 'peso': 3000, 'valor': 11},
              {'nome': 'optico 4', 'peso': 4000, 'valor': 11}
              ]

    resultado = dinamico(lucros)

    print('Resultado: ')

    for x in resultado:
        print(x)

    print('')
    print('Melhor Resultado: ', resultado[3][4])
