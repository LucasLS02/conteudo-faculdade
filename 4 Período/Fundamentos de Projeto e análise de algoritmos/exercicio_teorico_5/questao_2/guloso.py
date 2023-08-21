def leilao_guloso(ofertas, energia_disponivel):
    resultado = {
        'valor': 0,
        'GW': 0,
        'Empresas': []
    }

    oferta_mais_cara = lambda a: a['oferta']

    ofertas.sort(reverse=True, key=oferta_mais_cara)

    for oferta in ofertas:
        if resultado['GW'] + oferta['demanda'] <= energia_disponivel:
            resultado['valor'] += oferta['oferta']
            resultado['GW'] += oferta['demanda']
            resultado['Empresas'].append(oferta['nome'])

    return resultado


if __name__ == '__main__':
    ofertas = [{'nome': 'A', 'oferta': 5, 'demanda': 40},
               {'nome': 'B', 'oferta': 9, 'demanda': 80},
               {'nome': 'C', 'oferta': 3, 'demanda': 20},
               {'nome': 'D', 'oferta': 8, 'demanda': 160},
               {'nome': 'E', 'oferta': 6, 'demanda': 60}]

    resultado = leilao_guloso(ofertas, 200)

    print('')
    print('Melhor oferta guloso: ', resultado)
